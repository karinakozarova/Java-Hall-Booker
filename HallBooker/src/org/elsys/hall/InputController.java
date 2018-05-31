package org.elsys.hall;

import java.util.Scanner;

public class InputController {
	/*
	 * tested and working:
	 * 3
	 * 4
	 * 7
	 * 8
	 * 9
	 * 13
	 * 17
	 * 18
	 * quit
	 * data
	 * tested and problematic:
	 * scanenr problems:
	 * 2
	 * 5
	 * 6
	 * 10
	 * 12
	 * 14
	 * 15
	 * 16
	 * tested and maybe working(no data to make sure working):
	 * 11
	 */
	static void inputController(Integer input) 
	{			
		System.out.print("You selected: ");
		if(input == 1) 
		{
			/*Scanner sc = new Scanner(System.in);

			System.out.println("Add your hall");	
			System.out.println("Hall name?");
			String hallname = sc.nextLine();

			System.out.println("Rent price?");
			Double rentPrice = sc.nextDouble();


			System.out.println("Buy price?");
			Double buyPrice = sc.nextDouble();

			System.out.println("Location?");
			String location = sc.nextLine();
			*/
			String hallname = "Test";
			Double rentPrice = 10.0d;
			Double buyPrice = 10.0d;
			String location = "Test";

			/*		
			System.out.println("State?");
			String state = sc.nextLine();
			 */
			String state = "Free";
			Hall h = new Hall();

			h.createHall( hallname, rentPrice, buyPrice, location, state);
			//sc.close();
		} 
		else if(input == 2) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Check the status of a hall");
			Hall h = new Hall();
			System.out.println("Hall name?");
			String hallname = sc.next();
			// String hallname = "Universiada";
			h.checkStatusOfHallByName(hallname);
			sc.close();
		}
		else if(input == 3) 
		{
			System.out.println("Rent JUMBO hall");
			Hall h = new Hall();
			h.rentHall();
		} 
		else if(input == 4) 
		{
			System.out.println("Get halls and their location");
			Hall h = new Hall();
			h.getHallLocation();
		} 
		else if(input == 5) 
		{			
			Scanner sc = new Scanner(System.in);

			System.out.println("Change hall details");
			System.out.print("You want to change: ");

			System.out.println("1 - Hall name?");
			System.out.println("2 - Rent price?");			
			System.out.println("3 - Buy price?");			
			System.out.println("4 - Location?");
			Integer choice = sc.nextInt();

			System.out.println("Enter current hall name:");
			String currentHallName = sc.nextLine();

			Hall h = new Hall();
			if(choice == 1) {
				String futureHallName = sc.nextLine();
				h.changeHallName(currentHallName,futureHallName);
			}else if(choice == 2) {
				Integer price = sc.nextInt();
				h.changeHallRentPrice(currentHallName,price);
			}else if(choice == 3) {
				Integer price = sc.nextInt();
				h.changeHallBuyPrice(currentHallName,price);
			}else if(choice == 4) {
				String location = sc.nextLine();
				h.changeHallLocation(currentHallName,location);
			}
			sc.close();

		} 
		else if(input == 6) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Delete hall");
			System.out.println("Enter current hall name:");
			String currentHallName = sc.nextLine();
			Hall h = new Hall();
			h.deleteHallByName(currentHallName);
			sc.close();
		} else if(input == 7) {
			System.out.println("Print possible states of a hall");
			Hall states = new Hall();
			states.printHallStates();
		} else if(input == 8) {
			System.out.println("Remove all data from the tables");
			Hall states = new Hall();
			states.createDatabaseTables();
		}else if(input == 9) {
			System.out.println("Show Free Halls");
			Hall freeHalls = new Hall();
			freeHalls.showFreeHalls();
		}else if(input == 10) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Delete Hall by name");
			System.out.println("Enter hall name that should be deleted!");
			Hall halls = new Hall();
			halls.deleteHallByName(sc.nextLine()); 
			sc.close();
		} else if(input == 11) {
			System.out.println("Show all halls that have been bought and who bought them");
			Hall halls = new Hall();
			halls.showBoughtHalls(); 
		}else if(input == 12) {	
			System.out.println("Show all information");
			Hall halls = new Hall();
			halls.showAllInfo(); 
		} else if(input == 13) {
			System.out.println("Delete all halls connected to Stefan and Stefan himself");
			Hall halls = new Hall();
			halls.deleteAllStefanHalls(); 
		}else if(input == 14) {
			System.out.println("Create new Hall State");
			Hall halls = new Hall();
			halls.newHallState(); 
		}else if(input == 15) {
			System.out.println("Update Hall State");
			Hall halls = new Hall();
			halls.updateHallState(); 
		}else if(input == 16) {
			System.out.println("Delete Hall State");
			Hall halls = new Hall();
			halls.deleteHallState(); 
		}else if(input == 17) {
			System.out.println("Print all Hall names");
			Hall halls = new Hall();
			halls.allHallNames(); 
		}else if(input == 18) {
			System.out.println("Delete Universiada hall");
			Hall halls = new Hall();
			halls.deleteUniversiada();
		} else if(input == 19) {
			System.out.println("Change GM Dimitrov to Geo Milev");
			Hall halls = new Hall();
			halls.renameGMDimitrov();
		}else if(input == 20) {
			System.out.println("20 - Print all locations");
			Hall halls = new Hall();
			halls.selectAllLocations();
		}
	}

}
