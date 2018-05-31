package org.elsys.hall;
import java.util.Scanner;

public class MainClass {
	
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
				if(inputInt > 0) InputController.inputController(inputInt);	
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
		System.out.println("11 - Show all halls that have been bought and who bought them");
		System.out.println("12 - Show all information");
		System.out.println("13 - Delete all halls connected to Stefan and Stefan himself");
		System.out.println("14 - Create new Hall State");
		System.out.println("15 - Update Hall State");
		System.out.println("16 - Delete Hall State");
		System.out.println("quit - Exit app");
	}
}
