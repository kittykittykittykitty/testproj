INSERT INTO `Organization` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
VALUES (1, 0, 'Organization1', 'Penza, street 1, house 1', '5851234567', '5851234567890');
INSERT INTO `Organization` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
VALUES (2, 0, 'Organization2', 'Penza, street 2, house 2', '5851255567', '5851237897890');
INSERT INTO `Organization` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
VALUES (3, 0, 'Organization3', 'Penza, street 3, house 3', '5851212467', '5851237897000');
INSERT INTO `Organization` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
VALUES (4, 0, 'Organization4', 'Penza, street 4, house 4', '5851255987', '5851247097891');
INSERT INTO `Organization` (`id`, `version`, `organization_name`, `legal_address`, `inn`, `ogrn`)
VALUES (5, 0, 'Organization5', 'Penza, street 5, house 5', '5851206667', '5851266697890');


INSERT INTO `Currency` (`id`, `version`, `currency_name`, `currency_code`) VALUES (1, 0, 'rubles', '100a');
INSERT INTO `Currency` (`id`, `version`, `currency_name`, `currency_code`) VALUES (2, 0, 'dollars', '2b');
INSERT INTO `Currency` (`id`, `version`, `currency_name`, `currency_code`) VALUES (3, 0, 'euro', '3c');

INSERT INTO `Payments` (`id`, `version`, `name`, `price`) VALUES (1, 0, 'pomyit stekla', 1000.0);
INSERT INTO `Payments` (`id`, `version`, `name`, `price`) VALUES (2, 0, 'pomyit bumper', 2000.99);
