package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Hall {
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

	// CREATE
	public void createHall(String hallname,Double rentPrice,Double buyPrice,String location,String state) {
		// TODO create query string from params 
		String querystring = null;
		InsertingData.insertHallData(conn, querystring);
	}

	public void createDatabaseTables() {
		Database.initializeDatabase(); // creates all the tables
	}

	public void newHallState() {
		Scanner sc = new Scanner(System.in);
		String stateInput = sc.nextLine();
		States.addState(conn,stateInput);
		sc.close();
	}

	// READ
	public void allHallNames() {
		ResultSet result;
		System.out.println("The HALL NAMES are:");
		try {
			PreparedStatement query = conn.prepareStatement("Select * from Hall");
			result = query.executeQuery();
			while( result.next() ) {
				String name = result.getString("Name");
				System.out.println(name);
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}
	}

	public void checkStatusOfHallByName(String name) {
		//TODO implement this
	}

	public void getHallLocation()  {
		ResultSet result;
		try {
			PreparedStatement query = 
					conn.prepareStatement("SELECT h.Name, l.Address FROM Hall h\n" + 
							"INNER JOIN Location l ON h.LocationId = l.Id;");
			result = query.executeQuery();
			while( result.next() ) {
				String name = result.getString("Name");
				String Address = result.getString("Address");

				System.out.println(name + " is located at " + Address);
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}

	}

	public void showBoughtHalls() {
		//TODO implement this
	}

	public void showAllInfo() {
		HallsStatistics.showAllInfo(conn);
	}

	public void printHallStates() {
		States.getAllStates(conn); // outputs the states table
	}

	public void showFreeHalls() {
		HallsStatistics.showFreeHalls(conn);
	}

	// UPDATE
	public void rentHall()  {
		//TODO implement this
		InsertingData.executeStatement(conn,"INSERT INTO HallUser VALUES\n" + 
				"(\n" + 
				"7, \n" + 
				"(SELECT Id FROM Hall WHERE Name = 'JUMBO'), \n" + 
				"(SELECT Id FROM User WHERE FirstName = 'Karina')\n" + 
				");");

		try {
			PreparedStatement query = 
					conn.prepareStatement("UPDATE Hall \n" + 
							"SET StateId = (SELECT Id FROM State WHERE StateName = 'Rented')\n" + 
							"WHERE Name = 'JUMBO';");
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	


	}

	public void changeHallName(String currentHallName,String futureHallName) {
		//TODO implement this
	}

	public void changeHallRentPrice(String currentHallName,Integer price) {
		//TODO implement this
	}

	public void changeHallBuyPrice(String currentHallName,Integer price) {
		//TODO implement this
	}

	public void changeHallLocation(String currentHallName,String location) {
		//TODO implement this
	}

	public void updateHallState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter current state of the state that you want to change!");
		String current = sc.next();
		System.out.println("Enter how you want to change it");
		String future = sc.next();
		States.updateStates(conn,current,future);
		sc.close();
	}

	// DELETE
	public void deleteHallByName(String hallName) {
		HallsStatistics.deleteHallByName(conn,hallName);
	}

	public void deleteAllStefanHalls() {
		HallsStatistics.deleteAllStefanHalls(conn);
	}

	public void deleteHallState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter state that you want to delete");
		if(sc.hasNextLine()) {
			String StateName = sc.nextLine();
			System.out.println(StateName);
			States.deleteStateByName(conn, StateName);
			System.out.println("DELETED");
		}else {
			System.out.println("scanner doesnt have next line");
		}
		sc.close();
	}
	public void insertData() {
		InsertingData.insertAll(conn);
	}

	public void deleteUniversiada() {
		try {
			PreparedStatement query =
					conn.prepareStatement("DELETE FROM Hall\n" + 
							"WHERE Name = 'Universiada';");
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}

	public void renameGMDimitrov() {
		try {
			PreparedStatement query = 
					conn.prepareStatement("UPDATE Location\n" + 
							"SET Address = 'Geo Milev'\n" + 
							"WHERE Address = 'GM Dimitrov';");
			query.executeUpdate();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}	
	}
}
