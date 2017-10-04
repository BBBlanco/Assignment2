package database;

/**
	A helper class to handle all menus and simplify String input from user.
	@author Bruno Blanco, Dillon Rowan.
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
			Prints menu for user to choose a package type.
		*/
		public static void pTypeMenu()
		{
			System.out.println("\nType of package:");
			System.out.println("1. Envelope");
			System.out.println("2. Crate");
			System.out.println("3. Drum");
			System.out.println("4. Box");
			System.out.println("5. Postcard");
			System.out.println("6. Letter");
			System.out.println("7. Packet");
			System.out.println("8. Roll");
			System.out.println("9. Tube");
		}

		/**
			Prints menu for user to choose a user type.
		*/
		public static void uTypeMenu()
		{
			System.out.println("\nType of user:");
			System.out.println("1. Customer");
			System.out.println("2. Employee");
		}

		/**
			Prints menu for user to choose a material for the drum.
		*/
		public static void materialMenu()
		{
			System.out.println("\nType of material:");
			System.out.println("1. Plastic");
			System.out.println("2. Fiber");
		}

		/**
			Prints header for package classes.
		*/
		public static void printPHeader()
		{
			printDashes();
			System.out.println("|TRACKING #|    TYPE|SPECIFICATION|      CLASS|   ADDITIONAL1|  ADDITIONAL2|");
			printDashes();
		}

		/**
			Prints header for user classes.
		*/
		public static void printUHeader()
		{
			printDashes();
			System.out.println("|USER ID|FIRST NAME| LAST NAME|TYPE|PHONE/SOCIAL|ADDRESS/SALARY|BANK NUMBER|");
			printDashes();
		}

		/**
			Prints header for user classes.
		*/
		public static void printTHeader()
		{
			printDashes();
			System.out.println("|CUSTOMER ID|TRACKING #|SHIPPING DATE|DELIVERY DATE|  SHIP COST|EMPLOYEE ID|");
			printDashes();
		}

		/**
			Prints dashes.
		*/
		public static void printDashes(){System.out.println(dashes);}

		/**
			Getter for specification array, simplifying user input.
			@return Option in specMenu, automatically accounts for the -1.
		*/
		public static String getSpecification(int i) {return specification[i-1];}

		/**
			Getter for mailingClass array, simplifying user input.
			@return Option in mailingClassMenu, automatically accounts for the -1.
		*/
		public static String getMailingClass(int i) {return mailingClass[i-1];}

		/**
			Getter for package type array, simplifying user input.
			@return Option in pTypeMenu, automatically accounts for the -1.
		*/
		public static String getPType(int i) {return pType[i-1];}

		/**
			Getter for user type array, simplifying user input.
			@return Option in uTypeMenu, automatically accounts for the -1.
		*/
		public static String getUType(int i) {return uType[i-1];}

		/**
			Getter for material array, simplifying user input.
			@return Option in materialMenu, automatically accounts for the -1.
		*/
		public static String getMaterial(int i) {return material[i-1];}

		/**
			Validates user's input to int.
			@return Integer received from user.
		*/
		public static int getInt()
		{
			int integer;
			Scanner sc = new Scanner(System.in);

			while (!sc.hasNextInt())
			{
				System.out.print("Input not an integer: ");
				sc.next();
			}
			integer = sc.nextInt();
			return integer;
		}

		/**
			Validates user's input to float.
			@return Float received from user.
		*/
		public static float getFloat()
		{
			float decimal;
			Scanner sc = new Scanner(System.in);

			while (!sc.hasNextFloat())
			{
				System.out.print("Input not an decimal number: ");
				sc.next();
			}
			decimal = sc.nextFloat();
			return decimal;
		}

		private static String[] specification = {"Fragile", "Books", "Catalogs", "Do-Not-Bend", "N/A"};
		private static String[] mailingClass = {"First-Class", "Priority", "Retail", "Ground", "Metro"};
		private static String[] pType = {"Envelope, Box, Crate, Drum"};
		private static String[] uType = {"Cust", "Empl"};
		private static String[] material = {"Plastic", "Fiber"};
		private static String dashes = new String(new char[76]).replace("\0", "-");
}
