package view;

import java.util.List;
import java.util.Scanner;
import controller.PaintHelper;
import model.Paint;

/**
 * @author Jeremy Brannen - jrbrannen CIS175 Feb 7, 2021
 */
public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static PaintHelper ph = new PaintHelper();

	private static void addAPaint() {

		// method is to add an item by store and item input
		System.out.println("Enter the brand name: ");
		String brand = in.nextLine();
		System.out.println("Enter the color: ");
		String color = in.nextLine();
		System.out.println("Enter the type of medium:");
		String medium = in.nextLine();

		// creates a toAdd object based off of input
		Paint toAdd = new Paint(brand, color, medium);
		ph.insertPaint(toAdd);
	}

	private static void deleteAPaint() {

		// ask for user input for a store and item to delete
		System.out.print("Enter the brand name: ");
		String brand = in.nextLine();
		System.out.print("Enter the color: ");
		String color = in.nextLine();
		System.out.print("Enter the type of medium: ");
		String medium = in.nextLine();
		// creates a new listItem using users input and calls deleteItem method
		// from helper class to delete and update the database
		Paint toDelete = new Paint(brand, color, medium);
		ph.deletePaint(toDelete);
	}

	private static void viewAllPaints() {

		// creates a list from the Painthelper class by calling the ShowAllPaints method
		// and use a loop to output the list
		List<Paint> allPaints = ph.showAllItems();
		for (Paint singlePaint : allPaints) {
			System.out.println(singlePaint.returnPaintDetails());
		}
	}

	private static void editAPaint() {

		// ask for user input on how to search for an item
		System.out.println("Choose a search option? ");
		System.out.println("1 : Search by brand");
		System.out.println("2 : Search by color");
		System.out.println("3 : Search by medium");

		// stores input in a variable
		int searchBy = in.nextInt();
		in.nextLine();

		// creates a list for items that are found
		List<Paint> foundPaints;

		// asks for user input of search criteria based off of how users
		// want to search and calls searchFor method from helper class
		if (searchBy == 1) {
			System.out.print("Enter the brand name: ");
			String brandName = in.nextLine();
			foundPaints = ph.searchForPaintByBrand(brandName);
		} else if (searchBy == 2) {
			System.out.print("Enter the color name: ");
			String colorName = in.nextLine();
			foundPaints = ph.searchForPaintByColor(colorName);
		} else {
			System.out.print("Enter the medium type: ");
			String mediumType = in.nextLine();
			foundPaints = ph.searchForPaintByMedium(mediumType);
		}

		// displays search results unless variable is empty then it
		// displays "no results found"
		if (!foundPaints.isEmpty()) {
			System.out.println("Found Results.");

			// for loop to display each result found by calling getID and returnPaintDetails
			// methods from Paint class
			for (Paint l : foundPaints) {
				System.out.println(l.getId() + " : " + l.returnPaintDetails());
			}

			// ask user which item they would like to edit by id and stores in a variable
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			// uses searchForPaintById method to get item information from database
			// and outputs options for user to update
			Paint toEdit = ph.searchForPaintById(idToEdit);
			System.out.println("Retrieved " + toEdit.getBrand() + " of " + toEdit.getColor() + " color with a "
					+ toEdit.getMedium() + " medium.");
			System.out.println("Choose which option you would like to update.");
			System.out.println("1 : Update Brand");
			System.out.println("2 : Update Color");
			System.out.println("3 : Update Medium");

			// stores users input in a variable for which update they want to perform
			int update = in.nextInt();
			in.nextLine();

			// decides which input the user decided to update
			// the brand, color, or medium
			if (update == 1) {
				System.out.print("New Brand: ");
				String newBrand = in.nextLine();
				toEdit.setBrand(newBrand);
			} else if (update == 2) {
				System.out.print("New Color: ");
				String newColor = in.nextLine();
				toEdit.setColor(newColor);
			} else if (update == 3) {
				System.out.print("New Medium: ");
				String newMedium = in.nextLine();
				toEdit.setMedium(newMedium);
			}

			// method call to helper class to update item in the database
			ph.updateItem(toEdit);

		} else {
			System.out.println("~Those results were not found.~"); // output for invalid results
		}

	}

	public static void main(String[] args) {
		// method to run the menu starting up the program
		runMenu();
	}

	private static void runMenu() {

		// uses boolean to run a while loop and ask for user input on what they
		// would like to do in the program
		boolean goAgain = true;
		System.out.println("~~~~~~ Minitures Paint Collection ~~~~~~");
		while (goAgain) {
			System.out.println("~  Select an item:");
			System.out.println("~  1 ~~ Add a paint to your collection");
			System.out.println("~  2 ~~ Edit paints in your collection");
			System.out.println("~  3 ~~ Delete paints from your collection");
			System.out.println("~  4 ~~ View your collection of paints");
			System.out.println("~  5 ~~ Exit the program and start PAINTING!!");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			// selection based off of users input
			if (selection == 1) {
				addAPaint();
			} else if (selection == 2) {
				editAPaint();
			} else if (selection == 3) {
				deleteAPaint();
			} else if (selection == 4) {
				viewAllPaints();
			} else {
				ph.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

}
