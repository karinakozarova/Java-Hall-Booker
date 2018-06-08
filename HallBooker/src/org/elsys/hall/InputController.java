package org.elsys.hall;

import java.util.Scanner;

public class InputController {
	/* problematic:
	 * 12
	 * 2
	 * 5
	 * tested and maybe working(no data to make sure working):
	 * 11
	 * 14
	 */
	static void inputController(Integer input,Scanner sc) 
	{				
		Hall h = new Hall();

		System.out.print("You selected: ");
		if(input == 1) 
		{
			System.out.println("Add your hall");	
			/*
			System.out.println("Hall name?");
			String hallname = sc.nextLine();

			System.out.println("Rent price?");
			Double rentPrice = sc.nextDouble();

			System.out.println("Buy price?");
			Double buyPrice = sc.nextDouble();

			System.out.println("Location?");
			String location = sc.nextLine();
			System.out.println("State?");
			String state = sc.nextLine();
			 */
			String hallname = "Test";
			Double rentPrice = 10.0d;
			Double buyPrice = 10.0d;
			String location = "Test";
			String state = "Free";

			h.createHall( hallname, rentPrice, buyPrice, location, state);
		} 
		else if(input == 2) 
		{
			System.out.println("Check the status of a hall");
			/*System.out.println("Hall name?");
			String hallname = sc.next();
			System.out.println(hallname);*/
			String hallname = "Universiada";
			System.out.println("Checking status of Universiada..");
			h.checkStatusOfHallByName(hallname);
		}
		else if(input == 3) 
		{
			System.out.println("Rent JUMBO hall");
			h.rentHall();
		} 
		else if(input == 4) 
		{
			System.out.println("Get halls and their location");
			h.getHallLocation();
		} 
		else if(input == 5) 
		{			
			System.out.println("Change hall details");
			System.out.print("You want to change: ");

			System.out.println("1 - Hall name?");
			System.out.println("2 - Rent price?");			
			System.out.println("3 - Buy price?");			
			System.out.println("4 - Location?");
			Integer choice = sc.nextInt();

			System.out.println("Enter current hall name:");
			String currentHallName = sc.nextLine();

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
		} 
		else if(input == 6) 
		{
			System.out.println("Delete hall");
			/*System.out.println("Enter current hall name:");
			String currentHallName = sc.nextLine();*/
			System.out.println("Deleting Test Hall");
			String currentHallName = "Test";
			h.deleteHallByName(currentHallName);
		} else if(input == 7) {
			System.out.println("Print possible states of a hall");
			h.printHallStates();
		} else if(input == 8) {
			System.out.println("Remove all data from the tables");
			h.createDatabaseTables();
		}else if(input == 9) {
			System.out.println("Show Free Halls");
			h.showFreeHalls();
		}else if(input == 10) {
			System.out.println("Delete Hall by name");
			/*
			System.out.println("Enter hall name that should be deleted!");
			String hallname = sc.nextLine();
			 */
			String hallname = "HallOfHalls";
			h.deleteHallByName(hallname); 
		} else if(input == 11) {
			System.out.println("Show all halls that have been bought and who bought them");
			h.showBoughtHalls(); 
		}else if(input == 12) {	
			System.out.println("Show all information");
			h.showAllInfo(); 
		} else if(input == 13) {
			System.out.println("Delete all halls connected to Stefan and Stefan himself");
			h.deleteAllStefanHalls(); 
		}else if(input == 14) {
			System.out.println("Create new Hall State");
			h.newHallState(); 
		}else if(input == 15) {
			System.out.println("Update Hall State");
			h.updateHallState(); 
		}else if(input == 16) {
			System.out.println("Delete Hall State");
			h.deleteHallState(); 
		}else if(input == 17) {
			System.out.println("Print all Hall names");
			h.allHallNames(); 
		}else if(input == 18) {
			System.out.println("Delete Universiada hall");
			h.deleteHallByName("Universiada");
		} else if(input == 19) {
			System.out.println("Change GM Dimitrov to Geo Milev");
			h.renameGMDimitrov();
		}else if(input == 20) {
			System.out.println("Print all locations");
			h.selectAllLocations();
		}else if(input == 21) {
			System.out.println("21 - Show all halls that have been bought");
			h.showBoughtHalls();
		}
	}

}
