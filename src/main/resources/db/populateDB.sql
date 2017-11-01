SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE ip_addresses;
TRUNCATE departments;
TRUNCATE device_types;
TRUNCATE subnets;
TRUNCATE users;
TRUNCATE log_changes_details;
TRUNCATE log_changes;
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE ip_addresses AUTO_INCREMENT = 100000;
ALTER TABLE device_types AUTO_INCREMENT = 1000;
ALTER TABLE departments AUTO_INCREMENT = 1000;
ALTER TABLE subnets AUTO_INCREMENT = 1000;
ALTER TABLE users AUTO_INCREMENT = 1000;
ALTER TABLE log_changes AUTO_INCREMENT = 10000;
ALTER TABLE log_changes_details AUTO_INCREMENT = 10000;

INSERT INTO departments (name) VALUES ('Main Office');
INSERT INTO departments (name) VALUES ('Topolskogo');
INSERT INTO departments (name) VALUES ('Lermontovskiy');
INSERT INTO departments (name) VALUES ('Sudoremont');
INSERT INTO departments (name) VALUES ('Fond');
INSERT INTO departments (name) VALUES ('Varna');
INSERT INTO departments (name) VALUES ('Rostov');
INSERT INTO departments (name) VALUES ('Priemnaya Koroleva VS');
INSERT INTO departments (name) VALUES ('Bazarnaya 1');
INSERT INTO departments (name) VALUES ('Bazarnaya 2');
INSERT INTO departments (name) VALUES ('Shtab VN');

INSERT INTO device_types (name) VALUES ('Computer');
INSERT INTO device_types (name) VALUES ('Server');
INSERT INTO device_types (name) VALUES ('Printer');
INSERT INTO device_types (name) VALUES ('MFU');
INSERT INTO device_types (name) VALUES ('Router');
INSERT INTO device_types (name) VALUES ('Switch');
INSERT INTO device_types (name) VALUES ('IP Telephone');
INSERT INTO device_types (name) VALUES ('Video Registrator');
INSERT INTO device_types (name) VALUES ('IP Camera');
INSERT INTO device_types (name) VALUES ('IP Gateway');

INSERT INTO subnets(net) VALUES ('10.4.1.0');
INSERT INTO subnets(net) VALUES ('10.4.2.0');
INSERT INTO subnets(net) VALUES ('10.4.100.0');
INSERT INTO subnets(net) VALUES ('10.4.80.0');
INSERT INTO subnets(net) VALUES ('192.168.30.0');
INSERT INTO subnets(net) VALUES ('192.168.90.0');
INSERT INTO subnets(net) VALUES ('192.168.102.0');
INSERT INTO subnets(net) VALUES ('192.168.0.0');
INSERT INTO subnets(net) VALUES ('172.20.0.0');
INSERT INTO subnets(net) VALUES ('172.18.0.0');
INSERT INTO subnets(net) VALUES ('192.168.10.0');
INSERT INTO subnets(net) VALUES ('192.168.10.0');

INSERT INTO users(login, password, enabled) VALUES ('kostya', 'pass', true);
INSERT INTO users(login, password, enabled) VALUES ('gerts', 'pass', true);
INSERT INTO users(login, password, enabled) VALUES ('donchuk', 'pass', true);
INSERT INTO users(login, password, enabled) VALUES ('tkach', 'pass', true);
INSERT INTO users(login, password, enabled) VALUES ('smolyakov', 'pass', true);

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.1.10', '', 'prodigy', 'Петков', 1000, 1000, 1000, '', '', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.1.12', '', 'smolyakov', 'Смоляков', 1000, 1000, 1000, '', '', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.1.215', '', 'netlord', 'Герц', 1000, 1000, 1000, '', 'изъять компьютер у этого проходимца', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.1.2', '', 'valera', 'Дончук', 1000, 1000, 1000, '', '', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.2.10', '', 'vsdc02', 'DC', 1001, 1000, 1001, '', '', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('10.4.2.24', '', 'vsts24', 'Terminal Server', 1001, 1000, 1001, '', '', '', '', '', '');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('192.168.102.81', '', 'buh01', 'Соловьева', 1000, 1001, 1006, '', '', '', '', '123456789', '12345Abc');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('192.168.102.120', '', 'buh02', 'Кирова', 1000, 1001, 1006, '', '', '', '', '987654321', '12345Abc');

INSERT INTO ip_addresses(ip_address, mac_address, compname, username, type_id, dep_id, subnet_id, port_name, comments, device_login, device_pass, team_id, team_pass)
VALUES ('192.168.102.8', '', 'buh05', 'Досдогру', 1000, 1001, 1006, '', '', '', '', '123456123', '12345Abc');












