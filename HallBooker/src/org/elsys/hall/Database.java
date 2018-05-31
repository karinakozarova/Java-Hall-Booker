	package org.elsys.hall;
	

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	

	public class Database {
	

		/**creates all the tables for th db */
		public static void initializeDatabase() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Connection conn =
						DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=1303&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
	

				java.sql.Statement query = conn.createStatement();
	

				query.execute("	DROP DATABASE IF EXISTS HallBooker;\n" + 
						"\n");
				query.execute("CREATE DATABASE HallBooker");
	

				query.execute("DROP TABLE IF EXISTS Location\n");
				query.execute("	CREATE TABLE Location(\n" + 
						"		Id INTEGER NOT NULL,\n" + 
						"		Address VARCHAR(1000),\n" + 
						"	    PRIMARY KEY(Id)\n" + 
						"	);\n");
	

				query.execute("DROP TABLE IF EXISTS RentPeriod\n");
				query.execute("\n" + 
						"CREATE TABLE RentPeriod(\n" + 
						"	HallId INTEGER NOT NULL  PRIMARY KEY,\n" + 
						"	FromDate DATETIME NOT NULL,\n" + 
						"	UntilDate DATETIME NOT NULL\n" + 
						");");
	

				query.execute("DROP TABLE IF EXISTS Buyer\n");
				query.execute("CREATE TABLE Buyer(\n" + 
						"	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
						"	FirstName VARCHAR(35),\n" + 
						"	LastName VARCHAR(35)\n" + 
						");");
	

				query.execute("DROP TABLE IF EXISTS States\n");
				query.execute("Create table States(\n" + 
						"	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
						"	StateName VARCHAR(35)\n" + 
						");");
	

				States.addStates(conn);
	

				query.execute("DROP TABLE IF EXISTS State\n");
				query.execute("	CREATE TABLE State(\n" + 
						"		Id INTEGER AUTO_INCREMENT NOT NULL,\n" + 
						"		StateName VARCHAR(35),\n" + 
						"	    PRIMARY KEY(Id));\n");
	

				query.execute("DROP TABLE IF EXISTS HallState\n");
				query.execute("CREATE TABLE HallState(\n" + 
						"	HallId INTEGER NOT NULL,\n" + 
						"	StateId INTEGER NOT NULL\n" + 
						");");
	

				query.execute("DROP TABLE IF EXISTS Hall\n");
				query.execute("CREATE TABLE Hall(\n" + 
						"	Id INTEGER NOT NULL,\n" + 
						"	Name VARCHAR(250),\n" + 
						"	RentPrice DOUBLE,\n" + 
						"    BuyPrice DOUBLE,\n" + 
						"    LocationId INTEGER,\n" + 
						"    StateId INTEGER,\n" + 
						"    PRIMARY KEY(Id)\n" + 
						");\n");
				
				query.execute("DROP TABLE IF EXISTS HallUser\n");
				query.execute("	CREATE TABLE HallUser(\n" + 
						"		Id INTEGER NOT NULL,\n" + 
						"		HallId INTEGER NOT NULL,\n" + 
						"		UserId INTEGER NOT NULL,\n" + 
						"	    PRIMARY KEY(Id)\n" + 
						"	);");
				query.execute("DROP TABLE IF EXISTS User\n");
				query.execute("	CREATE TABLE User(\n" + 
						"		Id INTEGER NOT NULL,\n" + 
						"		FirstName VARCHAR(35),\n" + 
						"		LastName VARCHAR(35),\n" + 
						"	    PRIMARY KEY(Id)\n" + 
						"	);");
				
				query.execute("DROP TABLE IF EXISTS Rented\n");
				query.execute("	CREATE TABLE Rented(\n" + 
						"		Id INTEGER NOT NULL,\n" + 
						"		HallId INTEGER NOT NULL,\n" + 
						"		FromDate DATETIME NOT NULL,\n" + 
						"		UntilDate DATETIME NOT NULL,\n" + 
						"	    PRIMARY KEY (Id)\n" + 
						"	);");
			} catch (SQLException ex) {
				OutputException.sqlErrorInfo(ex);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	

		}
	

	}