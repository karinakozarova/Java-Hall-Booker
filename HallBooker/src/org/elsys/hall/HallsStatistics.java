package org.elsys.hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HallsStatistics {

	public static void showFreeHalls(Connection conn) {
		ResultSet result;
		try {
			PreparedStatement query = conn.prepareStatement("SELECT Name FROM Hall\n" + 
					"WHERE StateId = 1;");
			result = query.executeQuery();
			while( result.next() ) {
				String name = result.getString("Name");
				System.out.println(name);
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
	
	public static void deleteHallByName(Connection conn,String hallName) {
		try {
			PreparedStatement query = conn.prepareStatement("Delete from Hall where Name = ?");
			query.setString(1, hallName);
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}

	public static void deleteAllStefanHalls(Connection conn) {
		try {
			PreparedStatement query =
					conn.prepareStatement("DELETE FROM Hall\n" + 
							"WHERE Id = "
							+ "(SELECT HallId FROM HallUser WHERE UserId = "
							+ "(SELECT Id FROM User WHERE FirstName = 'Stephan'));\n");
			query.executeUpdate();
			query =
					conn.prepareStatement("DELETE FROM User\n" + 
							"WHERE FirstName = 'Stephan';");
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}
	}

	public static void showAllInfo(Connection conn) {
		ResultSet result;
		try {
			System.out.println("SHOWING..");
			PreparedStatement query = conn.prepareStatement("SELECT h.Id, h.Name AS HallName, h.RentPrice, h.BuyPrice, \n" + 
					"l.Address, s.StateName AS State, u.FirstName, u.LastName\n" + 
					"FROM Hall h INNER JOIN Location l ON l.Id = h.LocationId\n" + 
					"INNER JOIN State s ON s.Id = h.StateId\n" + 
					"RIGHT JOIN HallUser hu ON h.Id = hu.HallId\n" + 
					"LEFT JOIN User u ON u.Id = hu.UserId;\n");
			result = query.executeQuery();
			while(result.next()) {
				String name = result.getString("HallName");
				Double RentPrice = result.getDouble("RentPrice");
				Double BuyPrice = result.getDouble("BuyPrice");

				System.out.println(name + " " + RentPrice + " " + BuyPrice);
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
}
