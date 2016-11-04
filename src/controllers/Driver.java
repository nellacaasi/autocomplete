package controllers;
import java.util.Scanner;

/**
 * <h1>AutoComplete Assignment</h1><hr>
 * Algorithms - Assignment 1<br>
 * Second Year - BSc (Hons) in Applied Computing
 * 
 * <h3>Driver Class:</h3>
 * 
 * This class runs the application and user interface.
 * 
 *  
 * @author Isaac Allen - Student No: 20070915
 * @version 1.0 (04/11/2016)
 */

public class Driver {
	private Scanner input;
	
	public Driver(){
        input = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception { //Main Starting Method
		Driver driver = new Driver();
		driver.runMainMenu();
	}
	
	private void runMainMenu() throws Exception{ //Runs Main Menu
        int option = mainMenu();
        while (option != 0){
           
            switch (option){
               case 1:    runReturnMatches();
            	          	break;
               case 2:    runReturnListOfMatches();
                          	break;
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }
            option = mainMenu();
        }
        System.out.println("App Terminated...");
        
    }

	public void runReturnListOfMatches() {
		System.out.println("Type in a prefix: ");
        System.out.print("Enter Option ==>> ");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("How many matches would you like?: ");
        System.out.print("Enter Option ==>> ");
		int k = input.nextInt();
	}

	public void runReturnMatches() {
		String prefix = input.nextLine();
		//System.out.println(BruteAutoComplete.bestMatch(prefix));
	}

	private int mainMenu(){ //Main Menu
	    	System.out.println("**************************");
	        System.out.println("* AutoComplete Main Menu *");
	        System.out.println("* Isaac Allen            *");
	        System.out.println("* Student No: 20070915   *");
	        System.out.println("**************************");
	        System.out.println("----------------------------------");
	        System.out.println("- Brute Auto Complete Options");
	        System.out.println("");
	        System.out.println("  1) Return Best Match for a Prefix");
	        System.out.println("  2) Return a certain amount of Matches of a prefix");
	        System.out.println("----------------------------------");
	        System.out.println("- Quick AutoComplete Options");
	        System.out.println("");
	        System.out.println("     Not Yet Implemented");
	        System.out.println("----------------------------------");
	        System.out.println("  0) Exit");
	        System.out.println("");
	        System.out.print("Enter Option ==>> ");
	        int option = input.nextInt();
	        return option;
	    }
}
