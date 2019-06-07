CREATE DATABASE HRM;

CREATE TABLE HRM.CONTRACT_TYPE(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME NVARCHAR(100),
    DESCRIPTION NVARCHAR(1000),
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME
);

CREATE TABLE HRM.CONTRACT(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    DESCRIPTION NVARCHAR(1000),
    START_DATE DATE,
    END_DATE DATE,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    TYPE_ID INT,
    FOREIGN KEY (TYPE_ID) REFERENCES CONTRACT_TYPE(ID)
);

CREATE TABLE HRM.DEPARTMENT(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    NAME NVARCHAR(100)
);

CREATE TABLE HRM.EMPLOYEE(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME NVARCHAR(100),
    LAST_NAME NVARCHAR(100),
    PHONE_NUMBER VARCHAR(100),
    SALARY DECIMAL,
    CREATE_BY INT,
    CREATE_TIME DATETIME,
    UPDATE_BY INT,
    UPDATE_TIME DATETIME,
    CONTRACT_ID INT,
    DEPARTMENT_ID INT,
    FOREIGN KEY (CONTRACT_ID) REFERENCES CONTRACT(ID),
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(ID)
);

CREATE TABLE HRM.ACCOUNT(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME NVARCHAR(100),
    PASSWORD NVARCHAR(100),
    ROLE NVARCHAR(100),
    CREATE_TIME DATETIME,
    UPDATE_TIME DATETIME,
    EMPLOYEE_ID INT,
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID)
);

CREATE TRIGGER HRM.CONTRACT_TYPE_CREATE_TIMESTAMP BEFORE INSERT ON HRM.CONTRACT_TYPE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER HRM.CONTRACT_CREATE_TIMESTAMP BEFORE INSERT ON HRM.CONTRACT
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER HRM.DEPARTMENT_CREATE_TIMESTAMP BEFORE INSERT ON HRM.DEPARTMENT
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER HRM.EMPLOYEE_CREATE_TIMESTAMP BEFORE INSERT ON HRM.EMPLOYEE
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER HRM.ACCOUNT_CREATE_TIMESTAMP BEFORE INSERT ON HRM.ACCOUNT
FOR EACH ROW
SET NEW.CREATE_TIME = NOW();

CREATE TRIGGER HRM.CONTRACT_TYPE_UPDATE_TIMESTAMP BEFORE UPDATE ON HRM.CONTRACT_TYPE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER HRM.CONTRACT_UPDATE_TIMESTAMP BEFORE UPDATE ON HRM.CONTRACT
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER HRM.DEPARTMENT_UPDATE_TIMESTAMP BEFORE UPDATE ON HRM.DEPARTMENT
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER HRM.EMPLOYEE_UPDATE_TIMESTAMP BEFORE UPDATE ON HRM.EMPLOYEE
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

CREATE TRIGGER HRM.ACCOUNT_UPDATE_TIMESTAMP BEFORE UPDATE ON HRM.ACCOUNT
FOR EACH ROW
SET NEW.UPDATE_TIME = NOW();

INSERT INTO HRM.ACCOUNT(USERNAME, PASSWORD, ROLE) VALUES ('admin', 'admin', 'ADMIN');
