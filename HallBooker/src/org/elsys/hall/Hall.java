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
	
	public void createHall(String hallname,Double rentPrice,Double buyPrice,String location,String state) {
		//TODO implement this
	}
	public void createDatabaseTables() {
		Database.initializeDatabase(); // creates all the tables
	}

	public void printHallStates() {
		 States.getAllStates(conn); // outputs the states table
	}
	public void showFreeHalls() {
		HallsStatistics.showFreeHalls(conn);
	}
	
	public void deleteHallByName(String hallName) {
		HallsStatistics.deleteHallByName(conn,hallName);
	}

}
