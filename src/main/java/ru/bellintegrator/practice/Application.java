package ru.bellintegrator.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ru.bellintegrator.practice.controller.impl.BillControllerImpl;
import ru.bellintegrator.practice.controller.impl.CurrencyControllerImpl;
import ru.bellintegrator.practice.controller.impl.OrganizationControllerImpl;
import ru.bellintegrator.practice.controller.impl.PaymentControllerImpl;
import ru.bellintegrator.practice.dao.OrganizationDaо;
import ru.bellintegrator.practice.dao.impl.BillDaoImpl;
import ru.bellintegrator.practice.dao.impl.CurrencyDaoImpl;
import ru.bellintegrator.practice.dao.impl.PaymentDaoImpl;
import ru.bellintegrator.practice.service.impl.BillServiceImpl;
import ru.bellintegrator.practice.service.impl.CurrencyServiceImpl;
import ru.bellintegrator.practice.service.impl.OrganizationServiceImpl;
import ru.bellintegrator.practice.service.impl.PaymentServiceImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        OrganizationControllerImpl.class, OrganizationServiceImpl.class, OrganizationDaо.class,
        CurrencyControllerImpl.class, CurrencyServiceImpl.class, CurrencyDaoImpl.class,
        PaymentControllerImpl.class, PaymentServiceImpl.class, PaymentDaoImpl.class,
        BillControllerImpl.class, BillServiceImpl.class, BillDaoImpl.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Bean
    public TaskExecutor controllerPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
        executor.setQueueCapacity(25);
        return executor;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Bean
    public Docket curApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("currency").apiInfo(apiInfo()).
                select().paths(regex("/currency.*")).build();
    }

    @Bean
    public Docket orgApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("organizations").apiInfo(apiInfo()).
                select().paths(regex("/organtizations.*")).build();
    }

    @Bean
    public Docket payApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("payments").apiInfo(apiInfo()).
                select().paths(regex("/payments.*")).build();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .version("1.0")
                .build();
    }



}