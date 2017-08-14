CREATE TABLE IF NOT EXISTS `ReceiptForPayment` (
  `id`                    INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`               INTEGER     NOT NULL,
  `organization_id`       INTEGER,
  `receipt_number`        VARCHAR(64) NOT NULL,
  `customer_name`         VARCHAR(64) NOT NULL,
  `customer_phone_number` VARCHAR(32) NOT NULL,
  `payment_customer`      VARCHAR(64) NOT NULL,
  `payment_manager`       VARCHAR(64) NOT NULL,
  `payment_date`          DATE        NOT NULL,
  `payment_currency_id`   INTEGER
);

CREATE TABLE IF NOT EXISTS `Organizations` (
  `id`                INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`           INTEGER      NOT NULL,
  `organization_name` VARCHAR(256) NOT NULL,
  `legal_address`     VARCHAR(256) NOT NULL,
  `inn`               VARCHAR(10)  NOT NULL,
  `ogrn`              VARCHAR(13)  NOT NULL
);

CREATE TABLE IF NOT EXISTS `ServicePayment` (
  `id`           INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`      INTEGER NOT NULL,
  `service_name` INTEGER NOT NULL,
  `price`        REAL    NOT NULL
);

CREATE TABLE IF NOT EXISTS `Currency` (
  `id`            INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`       INTEGER     NOT NULL,
  `currency_code` VARCHAR(2)  NOT NULL,
  `currency_name` VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS `ReceiptServices` (
  `id`         INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`    INTEGER NOT NULL,
  `receipt_id` INTEGER NOT NULL,
  `service_id` INTEGER NOT NULL
);

ALTER TABLE `ReceiptForPayment`
  ADD FOREIGN KEY (`organization_id`) REFERENCES `Organizations` (`id`);
ALTER TABLE `ReceiptForPayment`
  ADD FOREIGN KEY (`payment_currency_id`) REFERENCES `Currency` (`id`);
ALTER TABLE `ReceiptServices`
  ADD FOREIGN KEY (`receipt_id`) REFERENCES `ReceiptForPayment` (`id`);
ALTER TABLE `ReceiptServices`
  ADD FOREIGN KEY (`service_id`) REFERENCES `ServicePayment` (`id`);
