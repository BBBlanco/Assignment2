package database;

/**
	A helper class to handle all menus and simplify String input from user.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Menu
{
		/**
			Prints menu for user to navigate program.
		*/
		public static void menu()
		{
			System.out.println("\nAvailable options:");
			System.out.println("1. Show all packages");
			System.out.println("2. Add package to database");
			System.out.println("3. Remove package from database");
			System.out.println("4. Search for a package by tracking number.");
			System.out.println("5. Show all users");
			System.out.println("6. Add new user");
			System.out.println("7. Update user info");
			System.out.println("8. Complete a shipping transaction");
			System.out.println("9. Show completed shipping transactions");
			System.out.println("0. Exit program");
		}

		/**
			Prints menu for user to choose a type.
		*/
		public static void typeMenu()
		{
			System.out.println("\nType of package:");
			System.out.println("1. Envelope");
			System.out.println("2. Box");
			System.out.println("3. Crate");
			System.out.println("4. Drum");
		}

		/**
			Prints menu for user to choose a specification.
		*/
		public static void specMenu()
		{
			System.out.println("\nSpecification of package:");
			System.out.println("1. Fragile");
			System.out.println("2. Books");
			System.out.println("3. Catalogs");
			System.out.println("4. Do-Not-bend");
			System.out.println("5. N/A");
		}

		/**
			Prints menu for user to choose a mailing class.
		*/
		public static void mailingClassMenu()
		{
			System.out.println("\nPackage's mailing class:");
			System.out.println("1. First-Class");
			System.out.println("2. Priority");
			System.out.println("3. Retail");
			System.out.println("4. Ground");
			System.out.println("5. Metro");
		}

		/**
			Prints header for package classes.
		*/
		public static void printPHeader()
		{
			printDashes();
			System.out.println("|TRACKING #|SPECIFICATION|      CLASS|ADDITIONAL 1|ADDITIONAL 2|");
			printDashes();
		}

		/**
			Prints header for user classes.
		*/
		public static void printUHeader()
		{
			printDashes();
			System.out.println("|TRACKING #|SPECIFICATION|      CLASS|ADDITIONAL 1|ADDITIONAL 2|");
			printDashes();
		}

		/**
			Prints dashes.
		*/
		public static void printDashes()
		{
			System.out.println(dashes);
		}

		/**
			Returns exact option chosen in specMenu, automatically accounts for the -1.
		*/
		public static String getSpecification(int i)
		{
			return specification[i-1];
		}

		/**
			Returns exact option chosen in specMenu, automatically accounts for the -1.
		*/
		public static String getMailingClass(int i)
		{
			return mailingClass[i-1];
		}

		private static String[] specification = {"Fragile", "Books", "Catalogs", "Do-Not-Bend", "N/A"};
		private static String[] mailingClass = {"First-Class", "Priority", "Retail", "Ground", "Metro"};
		private String dashes = new String(new char[63]).replace("\0", "-");
}
