package org.elsys.hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class States {

	/** deletes state from States table where certain Id*/
	public static void deleteStateById(Connection conn, Integer StateId) {
		try {
			PreparedStatement query = conn.prepareStatement("Delete from States where Id = ?");
			query.setInt(1, StateId);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
	
	public static void deleteStateByName(Connection conn,String StateName) {
		try {
			PreparedStatement query = conn.prepareStatement("Delete from States where StateName = ?");
			query.setString(1, StateName);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
	
	public static void updateStates(Connection conn, String is,String willbe) {
		try {
			PreparedStatement query = 
					conn.prepareStatement("Update States set StateName = ? where StateName = ?");
			query.setString(1, willbe);
			query.setString(2, is);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
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
			OutputException.sqlErrorInfo(ex);
		}		
	}
	

	/** adds new logical state to the States table **/
	public static void addState(Connection conn,String state) {

		try {
			PreparedStatement query = conn.prepareStatement("Insert Into States(StateName) Values('?');");
			query.setString(1, state);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}		
	}

	/** returns all states that were added at the States table **/
	public static void getAllStates(Connection conn) {
		ResultSet result;
		System.out.println("The states are:");
		try {
			PreparedStatement query = conn.prepareStatement("Select * from States");
			result = query.executeQuery();
			while( result.next() ) {
				String name = result.getString("StateName");
				System.out.println(name);
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}

}
