INSERT INTO `Organizations` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
					VALUES  (1, 0, 'ООО "Рисковый Джек"', 'г. Пенза, ул. Московская, д.27, оф.15', '5851234567', '5851234567890');
INSERT INTO `Organizations` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
					VALUES  (2, 0, 'ООО "Суровый Хенк"', 'г. Пенза, ул. Циолковского, 7', '5851255567', '5851237897890');
INSERT INTO `Organizations` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
					VALUES  (3, 0, 'ООО "Веселый Билли"', 'г. Пенза, ул. Воровского, д.14', '5851212467', '5851237897000');
INSERT INTO `Organizations` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
					VALUES  (4, 0, 'ООО "Честный Джимми"', 'г. Пенза, ул. Лазо, 4', '5851255987', '5851247097891');
INSERT INTO `Organizations` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`) 
					VALUES  (5, 0, 'ООО "Грязный Гарри"', 'г. Пенза, ул. Гоголя, 1', '5851206667', '5851266697890');

INSERT INTO `ServicePayment`      (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (1, 0, 'Установка, настройка  Windows XP', 10.5);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (2, 0, 'Установка пакета Microsoft Office', 5.75);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (3, 0, 'Установка драйверов, за 1 ед', 0.45);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (4, 0, 'Настройка доступа в Интернет', 2.9);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (5, 0, 'Настройка другого программного обеспечения за 1 шт', 2);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (6, 0, 'Разбивка жесткого диска', 2.5);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (7, 0, 'Удаление нежелательных всплывающих баннеров и заставок с рабочего стола', 3.33);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (8, 0, 'Диагностика неисправного системного блока', 3.15);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (9, 0, 'Установка/настройка внешнего устройства (сканер, принтер, фотоаппарат и т.д.)', 4.57);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (10, 0, 'Установка/замена материнской платы с перенастройкой системы', 19.63);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (11, 0, 'Восстановление ОС', 1.8);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (12, 0, 'Сброс пароля Windows', 0.5);
INSERT INTO `ServicePayment` (`id`, `version`, `service_name`, `service_cost`)
					VALUES  (13, 0, 'Оптимизация работы ПК (ускорение работы и восстановление  рабочего состояния)', 5.5);				

INSERT INTO `Currency` (`id`, `version`, `currency_code`, `currency_name`) 
					VALUES  (1, 0, 'RU', 'рубль');
INSERT INTO `Currency` (`id`, `version`, `currency_code`, `currency_name`) 
					VALUES  (2, 0, 'US', 'доллар');
INSERT INTO `Currency` (`id`, `version`, `currency_code`, `currency_name`) 
					VALUES  (3, 0, 'EU', 'евро');
					
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (1, 0, 1, '585-02-01', 'Колобков Прохор Вениаминович', '+7-964-385-10-52', 'Колобков Прохор Вениаминович', 'Сапсанов Лев Львович', '2017-02-19', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (2, 0, 2, '585-16-37', 'Чижова Алёна Петровна', '+7(928)144-00-00', 'Чижов Константин Григорьевич', 'Шитова Мария Артемовна', '2017-02-19', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (3, 0, 3, '585-19-21', 'Салаева Гульнара Эдиковна', '+7-927-219-14-57', 'Кожедуб Захар Матвеевич', 'Комаров Алексей Сергеевич', '2017-02-21', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (4, 0, 4, '585-77-06', 'Кочетков Максим Владимирович', '8(412)52-17-32', 'Кочетков Максим Владимирович', 'Воронов Леонид Антонович', '2017-02-15', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (5, 0, 5, '585-88-14', 'Солянкина Виктория Степановна', '+7-919-331-99-99', 'Солянкина Виктория Степановна', 'Мурашов Антон Александрович', '2017-02-23', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (6, 0, 4, '585-77-07', 'Кочетков Максим Владимирович', '+8(412)52-17-32', 'Кочетков Максим Владимирович', 'Воронов Леонид Антонович', '2017-02-15', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (7, 0, 4, '585-77-10', 'Романова Дарья Михайловна', '+7-999-555-00-55', 'Романова Дарья Михайловна', 'Воронов Леонид Антонович', '2017-02-19', 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `organization_id`, `receipt_number`, `customer_name`, `customer_phone_number`, `payment_customer`, `payment_manager`, `payment_date`, `payment_currency_id`) 
					VALUES  (8, 0, 2, '585-16-52', 'Шевченко Остап Николаевич', '+7-964-387-17-17', 'Шевченко Остап Николаевич', 'Корнеев Василий Васильевич', '2017-02-22', 1);
					
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (1, 0, 1, 13);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (2, 0, 1, 5);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (3, 0, 1, 7);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (4, 0, 2, 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (5, 0, 3, 6);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (6, 0, 3, 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (7, 0, 3, 2);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (8, 0, 3, 3);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (9, 0, 3, 4);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (10, 0, 4, 4);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (11, 0, 5, 7);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (12, 0, 6, 2);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (13, 0, 6, 13);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (14, 0, 7, 12);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (15, 0, 7, 11);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (16, 0, 8, 1);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (17, 0, 8, 2);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (18, 0, 8, 3);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (19, 0, 8, 4);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (20, 0, 8, 5);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (21, 0, 8, 6);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (22, 0, 8, 7);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (23, 0, 8, 8);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (24, 0, 8, 9);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (25, 0, 8, 10);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (26, 0, 8, 11);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (27, 0, 8, 12);
INSERT INTO `ReceiptForPayment` (`id`, `version`, `receipt_id`, `service_id`)
					VALUES  (28, 0, 8, 13);