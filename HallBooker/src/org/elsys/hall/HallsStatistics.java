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
}
