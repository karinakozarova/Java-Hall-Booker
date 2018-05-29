package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Hall 
{
	Connection conn = null;
	public Hall() {
        try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=1303&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false");
            // TODO create db here
			java.sql.Statement query = conn.createStatement();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("Catching");
			e.printStackTrace();
		}
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
