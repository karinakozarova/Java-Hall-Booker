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

	public Integer getMaxHallID() {
		ResultSet result;
		try {
			PreparedStatement query = 
					conn.prepareStatement("SELECT Id from Hall ORDER BY Id DESC LIMIT 1;\n");
			result = query.executeQuery();
			while(result.next()) {
				Integer id = result.getInt("Id");
				return id;
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}
		return null;
	}


	public void checkStatusOfHallByName(String name) { //TBT
		String queryString = 
				"SELECT StatusName FROM Status s INNER JOIN Hall ON s.Id = StatusId WHERE Name = '"
						+ name + "'";

		InsertingData.executeStatement(conn, queryString);
	}

	public void changeHallName(String currentHallName,String futureHallName) { //TBT
		String queryString = "UPDATE Hall SET Name = '" + futureHallName +
				"' WHERE Name = '" + currentHallName + "'";
		InsertingData.executeStatement(conn, queryString);

	}

	public void changeHallRentPrice(String currentHallName,Integer price) { //TBT
		String queryString = "UPDATE Hall SET RentPrice =" + price + " WHERE Name = '" 
				+ currentHallName + "'";
		InsertingData.executeStatement(conn, queryString);


	}

	public void changeHallBuyPrice(String currentHallName,Integer price) { //TBT
		String queryString = "UPDATE Hall SET BuyPrice = " + price + " WHERE Name = '"
				+ currentHallName + "'";
		InsertingData.executeStatement(conn, queryString);

	}

	public void changeHallLocation(String currentHallName,String location) {
		String queryString = "UPDATE Hall SET LocationId = (SELECT Id FROM Location WHERE Address = "
				+ location + ")WHERE Name = '" + currentHallName + "'";
		InsertingData.executeStatement(conn, queryString);

	}

	public Integer getLocationIdFromString(String location) {
		Integer locationID = 1;
		try {
			String str = "SELECT l.Id FROM Location l WHERE Address = '"
					+ location + "'";
			PreparedStatement query = conn.prepareStatement(str);
			ResultSet result = null;

			result = query.executeQuery();
			while( result.next() ) {
				locationID = result.getInt("Id");
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}
		return locationID;
	}

	public Integer getStateIdFromString(String state) {
		Integer stateId = 1;

		try {
			String str = "SELECT s.Id FROM States s WHERE StateName = '"
					+ state + "'";
			PreparedStatement query = conn.prepareStatement(str);
			ResultSet result = query.executeQuery();
			while( result.next() ) {
				stateId = result.getInt("Id");
			}
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}
		return stateId;
	}

	// CREATE
	public void createHall(String hallname,Double rentPrice,Double buyPrice,String location,String state) {
		Integer id = getMaxHallID();

		Integer locationID = getLocationIdFromString(location);
		Integer stateId = getStateIdFromString(state);

		String querystring = "INSERT INTO Hall VALUES (" 
				+ (id + 1) + ", '" + hallname+ " ', "
				+ rentPrice + ", " +buyPrice + ", "
				+ locationID + ", " + stateId + ");";
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


	public void showBoughtHalls() {
		HallsStatistics.showBoughtHalls(conn);		
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
		InsertingData.executeStatement(conn,"INSERT INTO HallUser VALUES\n" + 
				"(\n" + 
				"7, \n" + 
				"(SELECT Id FROM Hall WHERE Name = 'JUMBO'), \n" + 
				"(SELECT Id FROM User WHERE FirstName = 'Karina')\n" + 
				");");

		InsertingData.executeStatement(conn,"UPDATE Hall \n" + 
				"SET StateId = (SELECT Id FROM State WHERE StateName = 'Rented')\n" + 
				"WHERE Name = 'JUMBO';");	
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
		InsertingData.executeStatement(conn,"DELETE FROM Hall\n" + 
				"WHERE Name = 'Universiada';");
	}

	public void renameGMDimitrov() {
		InsertingData.executeStatement(conn,"UPDATE Location\n" + 
				"SET Address = 'Geo Milev'\n" + 
				"WHERE Address = 'GM Dimitrov';");
	}

	public void selectAllLocations() {
		ResultSet result;

		try {
			PreparedStatement query = conn.prepareStatement("Select * from Location");
			result = query.executeQuery();
			while( result.next() ) {
				String Address = result.getString("Address");
				System.out.print(Address + ", ");
			}
			System.out.println();
		} catch (SQLException ex) {
			OutputException.sqlErrorInfo(ex);
		}			
	}
}
