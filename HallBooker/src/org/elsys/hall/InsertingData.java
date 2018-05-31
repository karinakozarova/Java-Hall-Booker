package org.elsys.hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertingData {

	public static void insertAll(Connection conn) {
		insertHalls(conn);
		insertLocations(conn);
		insertHallUsers(conn);
		insertUsers(conn);
		insertRented(conn);
	}

	public static void insertRented(Connection conn) {
		executeStatement(conn,"INSERT INTO Rented VALUES(1, 3, '2000-08-15', '2000-10-06');");
		executeStatement(conn,"INSERT INTO Rented VALUES(2, 3, '2001-07-09', '2018-05-31');");
		executeStatement(conn,"INSERT INTO Rented VALUES(3, 2, '2018-01-01', '2018-12-25');");
	}
	public static void insertUsers(Connection conn) {
		executeStatement(conn,"INSERT INTO User VALUES(12, 'Karina', 'Kozarova');");
		executeStatement(conn,"INSERT INTO User VALUES(19, 'Momchil', 'Todorov');");
		executeStatement(conn,"INSERT INTO User VALUES(24, 'Stefan', 'Angelov');");
	}

	public static void insertHallUsers(Connection conn) {
		executeStatement(conn,"INSERT INTO HallUser VALUES(1, 2, 12);");
		executeStatement(conn,"INSERT INTO HallUser VALUES(2, 3, 19);");
		executeStatement(conn,"INSERT INTO HallUser VALUES(3, 3, 24);");
		executeStatement(conn,"INSERT INTO HallUser VALUES(4, 4, 24);");
		executeStatement(conn,"INSERT INTO HallUser VALUES(5, 6, 12);");
	}

	public static void insertLocations(Connection conn) {
		executeStatement(conn,"INSERT INTO Location VALUES (1, 'Serdika');");
		executeStatement(conn,"INSERT INTO Location VALUES (2, 'Mladost');");
		executeStatement(conn,"INSERT INTO Location VALUES (3, 'Kokalyne');");
		executeStatement(conn,"INSERT INTO Location VALUES (4, 'Suatina');");
		executeStatement(conn,"INSERT INTO Location VALUES (5, 'GM Dimitrov');");
	}

	public static void insertHalls(Connection conn) {
		executeStatement(conn,"INSERT INTO Hall VALUES (1, 'Universiada', 120.00, 1250.00, 1, 1);\n");
		executeStatement(conn,"INSERT INTO Hall VALUES (2, 'JUMBO', 30.99, 3000.00, 2, 2);\n");
		executeStatement(conn,"INSERT INTO Hall VALUES (3, 'METRO', 9.49, 5555.99, 2, 2);");
		executeStatement(conn,"INSERT INTO Hall VALUES (4, 'HallOfHalls', 0.01, 10000.00, 3, 3);");

	}

	public static void insertHallData(Connection conn,String querystring) {
		executeStatement(conn,querystring);
	}

	public static void executeStatement(Connection conn,String queryString) {
		try {
			PreparedStatement query = conn.prepareStatement(queryString);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
}
