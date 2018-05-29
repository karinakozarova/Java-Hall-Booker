package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Hall 
{
	Connection conn = null;
	public Hall() {
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                                           "user=root&password=root");
            // TODO create db here
			java.sql.Statement query = conn.createStatement();
	        //query.execute( “ALTER TABLE Subjects ADD COLUMN Code VARCHAR(10)” );
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
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
