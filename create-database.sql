create database iist;

CREATE TABLE iist.POSITIONS(
	POSITION_ID INT PRIMARY KEY AUTO_INCREMENT,
	POSITION_NAME NVARCHAR(255) NOT NULL,
	POSITION_DESCRIPTION NVARCHAR(255),
	CREATE_TIME DATETIME,
   	UPDATE_TIME DATETIME
);

CREATE TABLE iist.EMPLOYEE(
	EMPLOYEE_ID INT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME NVARCHAR(255) NOT NULL,
    LAST_NAME NVARCHAR(255) NOT NULL,
    PHONE_NUMBER VARCHAR(255) NOT NULL,
    SALARY DECIMAL NOT NULL,
    DOB DATE NOT NULL,
    ADDRESS NVARCHAR(255) NOT NULL,
    COUNTRY_CODE VARCHAR(10) NOT NULL,
    CREATE_BY INT,
    CREATE_TIME DATETIME,
    UPDATE_BY INT,
    UPDATE_TIME DATETIME,
    status SMALLINT NOT NULL,
    POSITION_ID INT NOT NULL,
    FOREIGN KEY (POSITION_ID) REFERENCES iist.POSITIONS(POSITION_ID)
);

CREATE TABLE iist.ROLES(
	ROLE_ID INT PRIMARY KEY AUTO_INCREMENT,
	ROLE_NAME NVARCHAR(255) UNIQUE NOT NULL,
	ROLE_DESCRIPTION NVARCHAR(255),
	CREATE_TIME DATETIME,
   UPDATE_TIME DATETIME
);

CREATE TABLE iist.ACCOUNT(
	ACCOUNT_ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME NVARCHAR(255) UNIQUE NOT NULL,
    PASSWORD NVARCHAR(255) NOT NULL,
    STATUS SMALLINT NOT NULL,
    ACCOUNT_NAME NVARCHAR(255),
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    EMPLOYEE_ID INT UNIQUE,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES iist.EMPLOYEE(EMPLOYEE_ID)
);

CREATE TABLE iist.ACCOUNT_ROLE(
	ACCOUNT_ID INT NOT NULL,
	ROLE_ID INT NOT NULL,
	CREATE_TIME DATETIME,
   	UPDATE_TIME DATETIME,
   	CREATE_BY INT,
   	UPDATE_BY INT,
   	FOREIGN KEY(ACCOUNT_ID) REFERENCES iist.ACCOUNT(ACCOUNT_ID),
   	FOREIGN KEY(ROLE_ID) REFERENCES iist.ROLES(ROLE_ID),
	PRIMARY KEY (ACCOUNT_ID, ROLE_ID)
);

CREATE TRIGGER iist.POSITION_CREATE_TIMESTAMP BEFORE INSERT ON iist.POSITIONS
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.EMPLOYEE_CREATE_TIMESTAMP BEFORE INSERT ON iist.EMPLOYEE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_CREATE_TIMESTAMP BEFORE INSERT ON iist.ACCOUNT
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ROLE_CREATE_TIMESTAMP BEFORE INSERT ON iist.ROLES
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_ROLE_CREATE_TIMESTAMP BEFORE INSERT ON iist.ACCOUNT_ROLE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER iist.POSITION_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.POSITIONS
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.EMPLOYEE_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.EMPLOYEE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ACCOUNT
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ROLE_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ROLES
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER iist.ACCOUNT_ROLE_UPDATE_TIMESTAMP BEFORE UPDATE ON iist.ACCOUNT_ROLE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();