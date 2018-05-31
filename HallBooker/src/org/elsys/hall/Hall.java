package org.elsys.hall;

import java.sql.Connection;
import java.sql.DriverManager;
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
		//TODO implement this 
	}
	
	public void createDatabaseTables() {
		Database.initializeDatabase(); // creates all the tables
	}
	
	// READ
	public void checkStatusOfHallByName(String name) {
		//TODO implement this
	}
	
	public void getHallLocation(String name)  {
		//TODO implement this
	}

	public void showBoughtHalls() {
		//TODO implement this
	}
	
	public void showAllInfo() {
		//TODO implement this
	}
	
	public void printHallStates() {
		States.getAllStates(conn); // outputs the states table
	}
	
	public void showFreeHalls() {
		HallsStatistics.showFreeHalls(conn);
	}

	// UPDATE
	public void rentHall(String name)  {
		//TODO implement this
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

	// DELETE
	public void deleteHallByName(String hallName) {
		HallsStatistics.deleteHallByName(conn,hallName);
	}

	public void deleteAllStefanHalls() {
		HallsStatistics.deleteAllStefanHalls(conn);
		// TODO Auto-generated method stub
	}

	public void newHallState() {
		Scanner sc = new Scanner(System.in);
		String stateInput = sc.next();
		States.addState(conn,stateInput);
		sc.close();
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

	public void deleteHallState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter state that you want to delete");
		String StateName = sc.next();
		States.deleteStateByName(conn, StateName);
		sc.close();
	}

}
