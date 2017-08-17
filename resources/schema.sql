CREATE TABLE IF NOT EXISTS ORGANIZATION (
  id                INTEGER PRIMARY KEY AUTO_INCREMENT,
  version           INTEGER      NOT NULL,
  organization_name VARCHAR(256) NOT NULL,
  legal_address     VARCHAR(256) NOT NULL,
  inn               VARCHAR(10)  NOT NULL,
  ogrn              VARCHAR(13)  NOT NULL
);

CREATE TABLE IF NOT EXISTS CURRENCY (
  id            INTEGER PRIMARY KEY AUTO_INCREMENT,
  version       INTEGER     NOT NULL,
  currency_name VARCHAR(50) NOT NULL,
  currency_code VARCHAR(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS PAYMENTS (
  id      INTEGER PRIMARY KEY AUTO_INCREMENT,
  version INTEGER      NOT NULL,
  name    VARCHAR(256) NOT NULL,
  price   REAL         NOT NULL
);