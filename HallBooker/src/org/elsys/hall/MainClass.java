package org.elsys.hall;
import java.util.Scanner;

public class MainClass 
{
	private static void inputController(Integer input) 
	{			

		System.out.print("You selected: ");
		if(input == 1) 
		{
			Scanner sc = new Scanner(System.in);

			System.out.println("Add your hall");	
			Hall h = new Hall();
			System.out.println("Hall name?");
			String hallname = sc.nextLine();

			System.out.println("Rent price?");
			Double rentPrice = sc.nextDouble();


			System.out.println("Buy price?");
			Double buyPrice = sc.nextDouble();

			System.out.println("Location?");
			String location = sc.nextLine();
			/*		
			System.out.println("State?");
			String state = sc.nextLine();
			 */
			String state = "Free";
			h.createHall( hallname, rentPrice, buyPrice, location, state);
			sc.close();
		} 
		else if(input == 2) 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Check the status of a hall");
			Hall h = new Hall();
			System.out.println("Hall name?");
			String hallname = sc.nextLine();
			h.checkStatusOfHallByName(hallname);
			sc.close();
		}
		else if(input == 3) 
		{
			System.out.println("Rent a hall");
			Scanner sc = new Scanner(System.in);
			Hall h = new Hall();
			System.out.println("Hall name?");
			String hallname = sc.nextLine();
			h.rentHall(hallname);
			sc.close();
		} 
		else if(input == 4) 
		{
			System.out.println("Get hall location");
			Scanner sc = new Scanner(System.in);
			Hall h = new Hall();
			System.out.println("Hall name?");
			String hallname = sc.nextLine();
			h.getHallLocation(hallname);
			sc.close();
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
			System.out.println("Create database tables");
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

		}else if(input == 11) {
			System.out.println("Show Halls with BuyPrice > 3000");
			Hall halls = new Hall();
			halls.showHallsWithHighBuyPrice(); 
		}else if(input == 12) {
			System.out.println("Show average RentPice of Halls in Mladost");
			Hall halls = new Hall();
			halls.showAverageRentInMladost(); 
		}else if(input == 13) {
			System.out.println("Show all halls that have been bought and who bought them");
			Hall halls = new Hall();
			halls.showBoughtHalls(); 
		}else if(input == 14) {	
			System.out.println("Show all information");
			Hall halls = new Hall();
			halls.showAllInfo(); 
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Hall Booker!");
		System.out.println("What do you want to do?");


		Scanner scan = new Scanner(System.in);
		while(true) 
		{
			menu();
			String input = scan.nextLine();
			if(input.equals("quit")) break;
			try{
				Integer inputInt = Integer.parseInt(input);
				if(inputInt > 0) inputController(inputInt);	
			}
			catch(NumberFormatException e)
			{
				System.out.println("Not a recognised command!");
			}
		}
		scan.close();
	}

	private static void menu() 
	{
		System.out.println("1 - Add your hall");
		System.out.println("2 - Check the status of a hall");
		System.out.println("3 - Rent a hall");
		System.out.println("4 - Get hall location");
		System.out.println("5 - Change hall details");
		System.out.println("6 - Delete hall");
		System.out.println("7 - Print possible states of a hall");
		System.out.println("8 - Create database tables");
		System.out.println("9 - Show Free Halls");
		System.out.println("10 - Delete Hall by name");
		System.out.println("11 - Show Halls with BuyPrice > 3000");
		System.out.println("12 - Show average RentPice of Halls in Mladost");
		System.out.println("13 - Show all halls that have been bought and who bought them");
		System.out.println("14 - Show all information");
		System.out.println("quit - Exit app");
	}
}
