DROP DATABASE IF EXISTS halls;
CREATE DATABASE halls CHARSET 'utf8';
USE halls;


CREATE TABLE HallLocation(
	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	LocationAdress VARCHAR(1000)
);

CREATE TABLE RentPeriod(
	HallId INTEGER NOT NULL  PRIMARY KEY,
	FromDate DATETIME NOT NULL,
	UntilDate DATETIME NOT NULL
);

/*
http://webarchive.nationalarchives.gov.uk/20100407173424/http://www.cabinetoffice.gov.uk/govtalk/schemasstandards/e-gif/datastandards.aspx
suggests 35 characters for each of Given Name and Family Name
*/
CREATE TABLE Buyer(
	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	FirstName VARCHAR(35),
	LastName VARCHAR(35)
);


Create table States(
	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	StateName VARCHAR(35)
);

Insert Into States(StateName) Values('Free');
Insert Into States(StateName) Values('Rented');
Insert Into States(StateName) Values('Bought');

CREATE TABLE State(
	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	StatesId INTEGER NOT NULL,
    BuyerId INTEGER
);

CREATE TABLE HallState(
	HallId INTEGER NOT NULL,
	StateId INTEGER NOT NULL
);

CREATE TABLE Halls(
	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	FirstName VARCHAR(250),
	RentPrice Double,
    BuyPrice Double,
    LocationId Integer
);
