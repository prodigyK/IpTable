DROP INDEX ip_appresses_unique_ipaddress_idx ON ip_addresses;
DROP TABLE IF EXISTS log_changes_details;
DROP TABLE IF EXISTS log_changes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS ip_addresses;
DROP TABLE IF EXISTS device_types;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS subnets;

CREATE TABLE device_types
(
id            INT NOT NULL AUTO_INCREMENT,
  name          VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
)AUTO_INCREMENT = 1000;

CREATE TABLE departments
(
  id            INT NOT NULL AUTO_INCREMENT,
  name          VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
)AUTO_INCREMENT = 1000;

CREATE TABLE subnets
(
  id            INT NOT NULL AUTO_INCREMENT,
  net           VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
)AUTO_INCREMENT =1000;

CREATE TABLE ip_addresses
(
id            INT NOT NULL AUTO_INCREMENT,
ip_address    VARCHAR(20) NOT NULL,
mac_address   VARCHAR(30),
compname      VARCHAR(150),
username      VARCHAR(50),
type_id       INT NOT NULL,
dep_id        INT NOT NULL,
subnet_id     INT NOT NULL,
port_name     VARCHAR(50),
comments      VARCHAR(255),
device_login  VARCHAR(20),
device_pass   VARCHAR(20),
team_id       VARCHAR(20),
team_pass     VARCHAR(20),
PRIMARY KEY (id),
FOREIGN KEY (type_id) REFERENCES device_types (id) ON DELETE CASCADE,
FOREIGN KEY (dep_id) REFERENCES departments (id) ON DELETE CASCADE,
FOREIGN KEY (subnet_id) REFERENCES subnets (id) ON DELETE CASCADE
)AUTO_INCREMENT = 100000;

CREATE UNIQUE INDEX ip_appresses_unique_ipaddress_idx ON ip_addresses(ip_address);

CREATE TABLE users
(
  id            INT NOT NULL AUTO_INCREMENT,
  login         VARCHAR(20) NOT NULL,
  password      VARCHAR(20) NOT NULL,
  enabled       BOOLEAN NOT NULL DEFAULT TRUE,
  CONSTRAINT users_unique_idx UNIQUE (login),
  PRIMARY KEY (id)
)AUTO_INCREMENT = 1000;

CREATE TABLE log_changes
(
  id            INT NOT NULL AUTO_INCREMENT,
  ip_address_id INT NOT NULL,
  ip_address    VARCHAR(20) NOT NULL,
  username      VARCHAR(20) NOT NULL,
  datetime      DATETIME NOT NULL,
  PRIMARY KEY (id)
)AUTO_INCREMENT = 10000;

CREATE TABLE log_changes_details
(
  id              INT NOT NULL AUTO_INCREMENT,
  log_id          INT NOT NULL,
  field_name      VARCHAR(20) NOT NULL,
  previous_value  VARCHAR(255),
  new_value       VARCHAR(255),
  deleted         BOOLEAN NOT NULL DEFAULT FALSE,
  FOREIGN KEY (log_id) REFERENCES log_changes (id),
  PRIMARY KEY (id)
)AUTO_INCREMENT = 10000;

