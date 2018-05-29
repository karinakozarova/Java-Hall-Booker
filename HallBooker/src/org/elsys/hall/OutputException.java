package org.elsys.hall;

import java.sql.SQLException;

public class OutputException {

	public static void sqlErrorInfo(SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
	}

}
