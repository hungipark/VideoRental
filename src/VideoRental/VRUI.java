package VideoRental;

import java.util.Scanner;

public class VRUI {
	private static Scanner scanner = new Scanner(System.in) ;
	public static void main(String[] args) {
		VRManager vrManager = new VRManager(scanner) ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: vrManager.listCustomers() ; break ;
				case 2: vrManager.listVideos() ; break ;
				case 3: vrManager.registerCustomer() ; break ;
				case 4: vrManager.registerVideo() ; break ;
				case 5: vrManager.rentVideo() ; break ;
				case 6: vrManager.returnVideo() ; break ;
				case 7: vrManager.getCustomerReport() ; break;
				case 8: vrManager.clearRentals() ; break ;
				case -1: vrManager.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public static int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = scanner.nextInt() ;

		return command ;

	}
}
