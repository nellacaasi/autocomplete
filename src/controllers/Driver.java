package controllers;
import java.io.IOException;
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
	BruteAutoComplete brute;
	Data data;
	
	public Driver() throws IOException{
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
               case 1:    runBruteSubMenu();
            	          	break;
               case 2:    System.out.println("Not Yet Implemented");
                          	break;
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }
            option = mainMenu();
        }
        System.out.println("App Terminated...");
        
    }

	private void runBruteSubMenu() throws IOException {
		int option = bruteSubMenu();
		brute = new BruteAutoComplete();
		while (option != 0){
			
			switch (option){
			case 1: runBruteBestMatch();
					  break;
			case 2: runBruteKMatches();
					  break;
		   default: System.out.println("Invalid option entered: " + option);
           		      break;
			}
			option = bruteSubMenu();
		}
	}
	
	private int bruteSubMenu(){ //Main Menu
        System.out.println("----------------------------------");
        System.out.println("- BruteAutoComplete Sub Menu -");
        System.out.println("");
        System.out.println("  1) Show the best match for a prefix");
        System.out.println("  2) Show a certain amount of matches for a prefix");
        System.out.println("----------------------------------");
        System.out.println("  0) Exit");
        System.out.println("");
        System.out.print("Enter Option ==>> ");
        int option = input.nextInt();
        return option;
    }
	
	

	public void runBruteKMatches(){
		System.out.println("Type in a prefix: ");
        System.out.print("Enter Option ==>> ");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("How many matches would you like?: ");
        System.out.print("Enter Option ==>> ");
		int k = input.nextInt();
		System.out.println("Here first "+k+" matches for the prefix \""+prefix+"\"");
		System.out.println(brute.matches(prefix, k));
		}

	public void runBruteBestMatch(){
		System.out.println("Type in a prefix: ");
        System.out.print("Enter Option ==>> ");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("Here is the best match for the prefix \""+prefix+"\"");
		System.out.println(brute.bestMatch(prefix));
	}

	private int mainMenu(){ //Main Menu
    	System.out.println("**************************");
        System.out.println("* AutoComplete Main Menu *");
        System.out.println("* Isaac Allen            *");
        System.out.println("* Student No: 20070915   *");
        System.out.println("**************************");
        System.out.println("----------------------------------");
        System.out.println("- Main Menu -");
        System.out.println("");
        System.out.println("  1) Display Brute AutoComplete Options");
        System.out.println("  2) Display Quick AutoComplete Options (Not Implemented)");
        System.out.println("----------------------------------");
        System.out.println("  0) Exit");
        System.out.println("");
        System.out.print("Enter Option ==>> ");
        int option = input.nextInt();
        return option;
	    }
}
