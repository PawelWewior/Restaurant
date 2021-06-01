
import java.util.Scanner;


public class Menu {
	
	private static Scanner input= new Scanner(System.in);
	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		Menu app = new Menu();
		app.runMenu();
		
		try {			
			app.runMenu();
			
		} catch (Exception e) {
			app = new Menu();
			app.runMenu();
		}

	}

	private int mainMenu() {

		System.out.println("Table Menu");
		System.out.println("---------");
		System.out.println("  1) Add a Table");
		System.out.println("  2) View Table");
		System.out.println("  3) Delete Table");
		System.out.println("  4) Add a Booking");
		System.out.println("  5) View Booking");
		System.out.println("  6) Delete Booking");
		System.out.println("  7) View All Tables & Bookings");
		System.out.println("  0) Exit");
		System.out.print("==>> ");
		int option = input.nextInt();
		return option;
	}
	
	private void runMenu() {
		int option = mainMenu();
		while (option != 0) {
			TableService newTableService = new TableService();
			BookingService newBookingService = new BookingService();
			switch (option) {
			case 1:		
				
				System.out.print("Please Enter the number of seats: ");
				newTableService.addTable(input.nextInt());
				break;
			case 2:
				
				newTableService.viewTables();
				break;
			case 3:
				System.out.print("Please Enter the number of table to delete: ");
				newTableService.deleteTable(input.nextInt());
				break;
			case 4 :
				
				System.out.print("Please Enter your Name: ");
				String name = scanner.nextLine();			
				System.out.print("Number of People booking: ");
				int numberofpplbooking = scanner.nextInt(); 
				System.out.print("Table Number being booked: ");
				int tableNumberBooked = scanner.nextInt();
				System.out.print("Time of Booking: ");
				int bookingTime = scanner.nextInt();
				System.out.print("The Amount of time (in hours) the booking is for: ");
				int amountoftime = scanner.nextInt();
				newBookingService.addBooking(name, numberofpplbooking, tableNumberBooked, bookingTime, amountoftime);				
				break;
			case 5:
				newBookingService.viewBooking();
				break;
			case 6:			
				 System.out.print("Please Enter the number of booking to delete: ");
				newBookingService.deleteBooking(input.nextInt());
				break;
				
			case 7:
				
				newTableService.viewTables();
				newBookingService.viewBooking();
				break;
			default:
				System.out.println("Invalid option entered: " + option);
				break;
			}
				System.out.println("\nPress any key to continue...");
				input.nextLine();
				input.nextLine();
				option = mainMenu();
			}			
		}		
	
	

	
	
	
	
	
	
	
	
	

}
	





