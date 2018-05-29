package org.elsys.hall;
import java.util.Scanner;

public class MainClass 
{

	private static void inputController(Integer input) 
	{
		System.out.print("You selected: ");
		if(input == 1) 
		{
			System.out.println("Add your hall");	
			Hall h = new Hall();
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
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Hall Booker!");
		System.out.println("What do you want to do?");
		

		Scanner sc = new Scanner(System.in);
		while(true) 
		{
			menu();
			String input = sc.next();
			if(input.equals("quit"))
			{
				break;
			}
			try
			{
				Integer inputInt = Integer.parseInt(input);
				if(inputInt > 0 && inputInt < 7) 
				{
					inputController(inputInt);
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Not a recognised command!");
			}
		}
		sc.close();
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

		System.out.println("quit - Exit app");
	}
}
