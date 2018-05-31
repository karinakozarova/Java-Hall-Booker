#--------------------------------------------------------------
# READ
#--------------------------------------------------------------

# 1.Show Halls and their RentPrice
SELECT Name, RentPrice
FROM Hall;

# 2.Show Free Halls
SELECT Name FROM Hall
WHERE StateId = 1;

# 3.Show Halls with BuyPrice > 3000
SELECT Name, BuyPrice FROM Hall
WHERE BuyPrice > 3000;

# 4.Show Halls and their Location
SELECT h.Name, l.Address FROM Hall h
INNER JOIN Location l ON h.LocationId = l.Id;

# 5.Show average RentPice of Halls in Mladost
SELECT AVG(RentPrice) FROM Hall h
INNER JOIN Location l ON h.LocationId = l.Id
WHERE l.Address = 'Mladost';

# 6.Show all Hall information
SELECT h.Name, h.RentPrice, h.BuyPrice, l.Address, s.StateName FROM Hall h
INNER JOIN Location l ON h.LocationId = l.Id
INNER JOIN State s ON h.StateId = s.Id;

# 7.Show all Halls that have been boughtS
SELECT h.Name FROM Hall h
INNER JOIN State s ON h.StateId = s.Id
WHERE s.StateName = 'Bought';

# 8.Show count of all Halls that have been rented
SELECT COUNT(h.Id) FROM Hall h
INNER JOIN State s ON h.StateID = s.Id
WHERE s.StateName = 'Rented';

# 9.Show Location of all Free Halls
SELECT l.Address FROM Hall h
INNER JOIN Location l ON h.LocationId = l.Id
INNER JOIN State s ON h.StateId = s.Id
WHERE s.StateName = 'Free';

# 10.Show count of all Users for each Hall
SELECT h.Name, COUNT(hu.UserId) FROM Hall h
RIGHT JOIN HallUser hu ON h.Id = hu.HallId
GROUP BY h.Name;

# 11.Show count of all Halls for each User
SELECT u.FirstName, COUNT(hu.HallId) FROM User u
RIGHT JOIN HallUser hu ON u.Id = hu.UserId
GROUP BY u.FirstName;

# 12.Show Hall and Owner(s)
SELECT h.Name, u.FirstName FROM Hall h
RIGHT JOIN HallUser hu ON h.Id = hu.HallId
LEFT JOIN User u ON u.Id = hu.UserId;

# 13.Show all Halls rented by Momchil
SELECT h.Name, u.FirstName FROM Hall h
RIGHT JOIN HallUser hu ON h.Id = hu.HallId
LEFT JOIN User u ON u.Id = hu.UserId
WHERE u.FirstName = 'Momchil';

# 14.Show all halls that have been bought and who bought them
SELECT h.Name, u.FirstName FROM Hall h
RIGHT JOIN HallUser hu ON h.Id = hu.HallId
LEFT JOIN User u ON u.Id = hu.UserId
INNER JOIN State s ON s.Id = h.StateId
WHERE s.StateName = 'Bought';

# 15.Show all rented Halls and when they were rented
SELECT h.Name, r.FromDate FROM Hall h
INNER JOIN State s ON s.Id = h.StateId
INNER JOIN Rented r ON r.HallId = h.Id
WHERE s.StateName = 'Rented';

# 16.Show all Halls rented until after 2018-05-31
SELECT h.Name, r.UntilDate FROM Hall h
INNER JOIN State s ON s.Id = h.StateId
INNER JOIN Rented r ON r.HallId = h.Id
WHERE r.UntilDate > '2018-05-31';

# 17.Show count of rented Halls for each User
SELECT u.FirstName, COUNT(hu.HallId) FROM User u
RIGHT JOIN HallUser hu ON u.Id = hu.UserId
LEFT JOIN Hall h ON h.Id = hu.HallId
INNER JOIN State s ON s.Id = h.StateId
WHERE s.StateName = 'Rented'
GROUP BY u.FirstName;

# 18.Show all information from all tables
SELECT h.Id, h.Name AS HallName, h.RentPrice, h.BuyPrice, 
l.Address, s.StateName AS State, u.FirstName, u.LastName
FROM Hall h INNER JOIN Location l ON l.Id = h.LocationId
INNER JOIN State s ON s.Id = h.StateId
RIGHT JOIN HallUser hu ON h.Id = hu.HallId
LEFT JOIN User u ON u.Id = hu.UserId;

#--------------------------------------------------------------
# UPDATE
#--------------------------------------------------------------

# 1.Universiada now has a RentPrice of 150.00
UPDATE Hall
SET RentPrice = 150.00
WHERE Name = 'Universiada';

# 2.Stefan becomes Stephan
UPDATE User
SET FirstName = 'Stephan'
WHERE FirstName = 'Stefan';

# 3.GM Dimitrov is now called Geo Milev
UPDATE Location
SET Address = 'Geo Milev'
WHERE Address = 'GM Dimitrov';

# 4.Change HallId for Rented From 2000-08-15 to 2
UPDATE Rented
SET HallId = 2
WHERE FromDate = '2000-08-15';

# 5.All of Karina's bought property become Momcil's
UPDATE HallUser
INNER JOIN Hall h ON h.Id = HallId
INNER JOIN User u ON u.Id = UserId
INNER JOIN State s ON s.Id = h.StateId
SET UserId = (SELECT Id FROM User WHERE FirstName = 'Momchil')
WHERE UserId = (SELECT Id FROM User WHERE FirstName = 'Karina') AND StateName = 'Bought';

# 6.JUMBO moves to Suatina
UPDATE Hall
INNER JOIN Location l ON l.Id = LocationId
SET LocationId = (SELECT l.Id FROM Location l WHERE Address = 'Suatina')
WHERE Name = 'JUMBO'; 

# 7.Momchil buys WC
INSERT INTO HallUser VALUES
(
  6, 
  (SELECT Id FROM Hall WHERE Name = 'WC'), 
    (SELECT Id FROM User WHERE FirstName = 'Momchil')
);
UPDATE Hall 
SET StateId = (SELECT Id FROM State WHERE StateName = 'Bought')
WHERE Name = 'WC';

# 8.Karina rents Universiada
INSERT INTO HallUser VALUES
(
  7, 
  (SELECT Id FROM Hall WHERE Name = 'Universiada'), 
    (SELECT Id FROM User WHERE FirstName = 'Karina')
);

UPDATE Hall 
SET StateId = (SELECT Id FROM State WHERE StateName = 'Rented')
WHERE Name = 'Universiada';

# 9.Stefan frees METRO
DELETE FROM HallUser
WHERE HallId = (SELECT Id FROM Hall WHERE Name = 'METRO')
AND UserId = (SELECT Id FROM User WHERE FirstName = 'Stephan');

UPDATE Hall 
SET StateId = (SELECT Id FROM State WHERE StateName = 'Free')
WHERE Name = 'METRO';

#--------------------------------------------------------------
# DELETE
#--------------------------------------------------------------

# 1.Delete Karina as a user
DELETE FROM User
WHERE FirstName = 'Karina';

# 2.Delete Universiada
DELETE FROM Hall
WHERE Name = 'Universiada';


# 3.Delete all halls connected to Stefan and Stefan himself
DELETE FROM Hall
WHERE Id = (SELECT HallId FROM HallUser WHERE UserId = (SELECT Id FROM User WHERE FirstName = 'Stephan'));

DELETE FROM User
WHERE FirstName = 'Stephan';