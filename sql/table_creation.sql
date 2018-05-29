DROP DATABASE IF EXISTS HallBooker;
CREATE DATABASE HallBooker CHARSET 'utf8';
USE HallBooker;

# Hall
-- | Id | Name        | RentPrice | BuyPrice | LocationId | StateId |
-- |----|-------------|-----------|----------|------------|---------|
-- | 1  | Universiada | 120.00    | 1250.00  | 1          | 1       |
-- | 2  | JUMBO       | 30.99     | 3000.00  | 2          | 2       |
-- | 3  | METRO       | 9.49      | 5555.99  | 2          | 2       |
-- | 4  | HallOfHalls | 0.01      | 10000.00 | 3          | 3       |
-- | 5  | WC          | 1.00      | 100.00   | 4          | 1       |
-- | 6  | Taekwondo   | 29.99     | 3485.49  | 5          | 3       |

CREATE TABLE Hall(
	Id INTEGER NOT NULL,
	Name VARCHAR(250),
	RentPrice DOUBLE,
    BuyPrice DOUBLE,
    LocationId INTEGER,
    StateId INTEGER,
    PRIMARY KEY(Id)
);

INSERT INTO Hall VALUES (1, 'Universiada', 120.00, 1250.00, 1, 1);
INSERT INTO Hall VALUES (2, 'JUMBO', 30.99, 3000.00, 2, 2);
INSERT INTO Hall VALUES (3, 'METRO', 9.49, 5555.99, 2, 2);
INSERT INTO Hall VALUES (4, 'HallOfHalls', 0.01, 10000.00, 3, 3);
INSERT INTO Hall VALUES (5, 'WC', 1.00, 100.00, 4, 1);
INSERT INTO Hall VALUES (6, 'Taekwondo', 29.99, 3485.49, 5, 3);

# Location
-- | Id | Name        | 
-- |----|-------------|
-- | 1  | Serdika     |
-- | 2  | Mladost     |
-- | 3  | Kokalyne    |
-- | 4  | Suatina     |
-- | 5  | GM Dimitrov |

CREATE TABLE Location(
	Id INTEGER NOT NULL,
	Address VARCHAR(1000),
    PRIMARY KEY(Id)
);

INSERT INTO Location VALUES (1, 'Serdika');
INSERT INTO Location VALUES (2, 'Mladost');
INSERT INTO Location VALUES (3, 'Kokalyne');
INSERT INTO Location VALUES (4, 'Suatina');
INSERT INTO Location VALUES (5, 'GM Dimitrov');

# State
-- | Id | Name   |
-- |----|--------|
-- | 1  | Free   |
-- | 2  | Rented |
-- | 3  | Bought |

CREATE TABLE State(
	Id INTEGER NOT NULL,
	StateName VARCHAR(35),
    PRIMARY KEY(Id)
);

Insert Into State Values(1, 'Free');
Insert Into State Values(2, 'Rented');
Insert Into State Values(3, 'Bought');

# HallUser
-- | Id | HallId | UserId |
-- |----|--------|--------|
-- | 1  | 2      | 12     |
-- | 2  | 3      | 19     |
-- | 3  | 3      | 24     |
-- | 4  | 4      | 24     |
-- | 5  | 6      | 12     |

CREATE TABLE HallUser(
	Id INTEGER NOT NULL,
	HallId INTEGER NOT NULL,
	UserId INTEGER NOT NULL,
    PRIMARY KEY(Id)
);

INSERT INTO HallUser VALUES(1, 2, 12);
INSERT INTO HallUser VALUES(2, 3, 19);
INSERT INTO HallUser VALUES(3, 3, 24);
INSERT INTO HallUser VALUES(4, 4, 24);
INSERT INTO HallUser VALUES(5, 6, 12);

# User
-- | Id | FirstName | LastName |
-- |----|-----------|----------|
-- | 12 | Karina    | Kozarova |
-- | 19 | Momchil   | Todorov  |
-- | 24 | Stefan    | Angelov  |

CREATE TABLE User(
	Id INTEGER NOT NULL,
	FirstName VARCHAR(35),
	LastName VARCHAR(35),
    PRIMARY KEY(Id)
);

INSERT INTO User VALUES(12, 'Karina', 'Kozarova');
INSERT INTO User VALUES(19, 'Momchil', 'Todorov');
INSERT INTO User VALUES(24, 'Stefan', 'Angelov');

# Rented
-- | HallId | From       | Until      |
-- |--------|------------|------------|
-- | 2      | 2018-01-01 | 2018-12-25 |
-- | 3      | 2000-08-15 | 2000-10-06 |
-- | 3      | 2001-07-09 | 2018-05-31 |

CREATE TABLE Rented(
	Id INTEGER NOT NULL,
	HallId INTEGER NOT NULL,
	FromDate DATETIME NOT NULL,
	UntilDate DATETIME NOT NULL,
    PRIMARY KEY (Id)
);

INSERT INTO Rented VALUES(1, 3, '2000-08-15', '2000-10-06');
INSERT INTO Rented VALUES(2, 3, '2001-07-09', '2018-05-31');
INSERT INTO Rented VALUES(3, 2, '2018-01-01', '2018-12-25');
