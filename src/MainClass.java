import java.util.Scanner;

public class MainClass {

	private final static int exitNumber = 7;

	private static void inputController(Integer input) {
		if(input == 1) {
			System.out.println("You selected: Add your hall");			
		}else if(input == 2) {
			System.out.println("You selected: Check the status of a hall");
		}else if(input == 3) {
			System.out.println("You selected: Rent a hall");
		}else if(input == 4) {
			System.out.println("You selected: Get hall location");
		} else if(input == 5) {
			System.out.println("You selected: Change hall details");
		} else if(input == 6) {
			System.out.println("You selected: Delete hall");
		} 
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Hall Booker!");
		System.out.println("What do you want to do?");
		menu();

		Scanner sc = new Scanner(System.in);
		while(true) {
			Integer input = sc.nextInt();
			if(input == exitNumber) {
				break;
			}else if(input < exitNumber && input > 0) {
				inputController(input);
			}
		}
		sc.close();
	}

	private static void menu() {
		System.out.println("1 - Add your hall");
		System.out.println("2 - Check the status of a hall");
		System.out.println("3 - Rent a hall");
		System.out.println("4 - Get hall location");
		System.out.println("5 - Change hall details");
		System.out.println("6 - Delete hall");
		System.out.println(exitNumber + " - Exit app");
	}
}
