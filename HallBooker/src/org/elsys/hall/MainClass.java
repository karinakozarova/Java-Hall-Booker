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
			System.out.println("Check the status of a hall");
		}
		else if(input == 3) 
		{
			System.out.println("Rent a hall");
		} 
		else if(input == 4) 
		{
			System.out.println("Get hall location");
		} 
		else if(input == 5) 
		{
			System.out.println("Change hall details");
		} 
		else if(input == 6) 
		{
			System.out.println("Delete hall");
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
			if(input.equals("quit"))
			{
				break;
			}
			try
			{
				Integer inputInt = Integer.parseInt(input);
				if(inputInt > 0) 
				{
					inputController(inputInt);
				}
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
		System.out.println("quit - Exit app");
	}
}
