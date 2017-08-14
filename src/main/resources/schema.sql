CREATE TABLE IF NOT EXISTS `Organizations` (
  `id`                INTEGER PRIMARY KEY AUTO_INCREMENT,
  `version`           INTEGER      NOT NULL,
  `organization_name` VARCHAR(256) NOT NULL,
  `legal_address`     VARCHAR(256) NOT NULL,
  `inn`               VARCHAR(10)  NOT NULL,
  `ogrn`              VARCHAR(13)  NOT NULL
);
