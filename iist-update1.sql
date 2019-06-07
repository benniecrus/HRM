create database iist;

CREATE TABLE iist.POSITION(
	POSITION_ID INT PRIMARY KEY AUTO_INCREMENT,
	POSITION_NAME NVARCHAR(255),
	CREATE_TIME DATETIME,
   UPDATE_TIME DATETIME
);

CREATE TABLE iist.ETHENICITY(
	ETHENICITY_ID INT PRIMARY KEY AUTO_INCREMENT,
	ETHENICITY_NAME NVARCHAR(255),
	CREATE_TIME DATETIME,
   UPDATE_TIME DATETIME
);

CREATE TABLE iist.NATION(
	NATION_ID INT PRIMARY KEY AUTO_INCREMENT,
	NATION_NAME NVARCHAR(255),
	CREATE_TIME DATETIME,
   UPDATE_TIME DATETIME
);

CREATE TABLE iist.EMPLOYEE(
	EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME NVARCHAR(255),
    LAST_NAME NVARCHAR(255),
    PHONE_NUMBER VARCHAR(255),
    SALARY DECIMAL,
    DOB DATE,
    ADDRESS NVARCHAR(255),
    CREATE_BY INT,
    CREATE_TIME DATETIME,
    UPDATE_BY INT,
    UPDATE_TIME DATETIME,
    POSITION_ID INT,
    ETHENICITY_ID INT,
    NATION_ID INT,
    FOREIGN KEY (POSITION_ID) REFERENCES iist.POSITION(POSITION_ID),
    FOREIGN KEY (ETHENICITY_ID) REFERENCES iist.ETHENICITY(ETHENICITY_ID),
    FOREIGN KEY (NATION_ID) REFERENCES iist.NATION(NATION_ID)
);

CREATE TABLE iist.ROLE(
	ROLE_ID INT PRIMARY KEY AUTO_INCREMENT,
	ROLE_NAME NVARCHAR(255),
	CREATE_TIME DATETIME,
   UPDATE_TIME DATETIME
);

CREATE TABLE iist.ACCOUNT(
	ACCOUNT_ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME NVARCHAR(255) UNIQUE,
    PASSWORD NVARCHAR(255),
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    EMPLOYEE_ID INT UNIQUE,
    ROLE_ID INT,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES iist.EMPLOYEE(EMPLOYEE_ID),
    FOREIGN KEY (ROLE_ID) REFERENCES iist.ROLE(ROLE_ID)
);

CREATE TRIGGER iist.NATION_CREATE_TIMESTAMP BEFORE INSERT ON iist.NATION
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.POSITION_CREATE_TIMESTAMP BEFORE INSERT ON iist.POSITION
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ETHENICITY_CREATE_TIMESTAMP BEFORE INSERT ON iist.ETHENICITY
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.EMPLOYEE_CREATE_TIMESTAMP BEFORE INSERT ON iist.EMPLOYEE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_CREATE_TIMESTAMP BEFORE INSERT ON iist.ACCOUNT
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ROLE_CREATE_TIMESTAMP BEFORE INSERT ON iist.ROLE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.NATION_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.NATION
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.POSITION_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.POSITION
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ETHENICITY_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ETHENICITY
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.EMPLOYEE_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.EMPLOYEE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ACCOUNT
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ROLE_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ROLE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();


INSERT INTO iist.ROLE(ROLE_NAME) VALUES ("ADMIN");

INSERT INTO iist.ACCOUNT(USERNAME, PASSWORD, ROLE_ID) VALUES ('admin', 'admin', 1);