package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hall 
{
	Connection conn = null;

	public void connectToDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=1303&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException  e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
	public Hall() {
		connectToDatabase();
	}
	
	public void createDatabaseTables() {
		Database.initializeDatabase(); // creates all the tables
	}

	public void printHallStates() {
		 States.getAllStates(conn); // outputs the states table
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
