package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hall 
{
	Connection conn = null;

	/**creates all the tables for th db */
	static void init_db() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=1303&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");

			java.sql.Statement query = conn.createStatement();

			query.execute("DROP DATABASE IF EXISTS halls\n");
			query.execute("CREATE DATABASE halls");

			query.execute("DROP TABLE IF EXISTS HallLocation\n");
			query.execute("CREATE TABLE HallLocation(\n" + 
					"	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
					"	LocationAdress VARCHAR(1000)\n" + 
					");");

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

			addStates(conn);

			query.execute("DROP TABLE IF EXISTS State\n");
			query.execute("CREATE TABLE State(\n" + 
					"	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
					"	StatesId INTEGER NOT NULL,\n" + 
					"    BuyerId INTEGER\n" + 
					");\n");

			query.execute("DROP TABLE IF EXISTS HallState\n");
			query.execute("CREATE TABLE HallState(\n" + 
					"	HallId INTEGER NOT NULL,\n" + 
					"	StateId INTEGER NOT NULL\n" + 
					");");

			query.execute("DROP TABLE IF EXISTS Halls\n");
			query.execute("CREATE TABLE Halls(\n" + 
					"	Id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
					"	FirstName VARCHAR(250),\n" + 
					"	RentPrice Double,\n" + 
					"    BuyPrice Double,\n" + 
					"    LocationId Integer\n" + 
					");");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/** adds all logical states to the States table **/
	public static void addStates(Connection conn) {

		try {
			PreparedStatement query = conn.prepareStatement("Insert Into States(StateName) Values('Free');");
			query.executeUpdate();

			query = conn.prepareStatement("Insert Into States(StateName) Values('Rented');");
			query.executeUpdate();

			query = conn.prepareStatement("Insert Into States(StateName) Values('Bought');");
			query.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}		
	}
	/** returns all states that were added at the States table **/
	public void getAllStates() {
		ResultSet result;
		try {
			PreparedStatement query = conn.prepareStatement("Select * from States");
			result = query.executeQuery();
			while( result.next() ) {
				int id = result.getInt("Id");
				String name = result.getString("StateName");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	public Hall() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=1303&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	

		init_db(); // creates all the tables
		getAllStates();
	}

	/*
	// read 
	private Integer getId() {
		return null;
	}

	private String getName() {
		return null;

	}

	private Integer getLocationId() {
		return null;

	}
	private double getRentPrice() {
		double res = 0.0d;
		return res;

	}

	private double getBuyPrice() {
		double res = 0.0d;
		return res;

	}
	private Integer getHallState(){
		Integer res = 0;
		return res;

	}

	// create,update
	private void setId(Integer Id) {

	}

	private void setName(String name) {

	}

	private void setLocationId(Integer Id) {

	}
	private void setRentPrice(Double price) {


	}

	private void setBuyPrice(Double price) {


	}
	private void setHallState(Integer state){


	}

	// delete hall
	private void deleteHall(Integer hallId){


	}
	 */

}
