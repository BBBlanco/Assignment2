package database;

/**
	A driver class for the assignment.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

import java.util.*;
import java.io.*;

public class Driver
{
	public static void main(String[] args) throws Exception
	{
		/*Varibles:
		boolean done - control to continue program until 0 is input for top menu.
		boolean contains - checks if tracking numbers and user IDs are already present in arrayLists.

		int1, 2, 3
		float1
		string1, 2, 3, 4, 5
		Maximum required variables to create classes, will be alternated per argument in each class constructor

		Package:			4 String	0 int	0 float
		Box:					4 String	2 int	0 float
		Crate:				5 String	0 int	1 float
		Drum:					5 String	1 int	0 float
		Envelope:			4 String	2 int	0 float

		User:					2 String	1 int	0 float
		Customer:			4 String	1 int	0 float
		Employee:			2 String	3 int	1 float

		transaction:	3 String	2 int	1 float
		=====================================
		MAX:					5 String	3 int	1 float
		*/

		Store st;
		ListIterator<Package> itP;
		ListIterator<User> itU;
		ListIterator<Store> itS;
		File file = new File("packages.txt");
		Scanner sc = new Scanner(System.in);
		boolean done = false, contains = false;
		int int1, int2, int3;
		float float1;
		String string1, string2, string3, string4, string5;

/************COMMENTED OUT TO TEST REMAINDER OF DRIVER*************
		try{
			FileInputStream fis = new FileInputStream("packages.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			st = (Store) ois.readObject(); //read object from stream, restoring contents of each field in Store object
			fis.close();
		}catch (FileNotFoundException fnfe) {
			first time running program
			Store st = new Store();
		}catch (IOException ioe) {
			System.out.println(ioe);
			return; //leave main
		}catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
			return; //leave main
		}
*********************END OF COMMENTED SECTION*********************/


		do // Shows menu and requests user input until 6 is entered.
		{
			Menu.menu();
			do // Asks for user's input until input is valid.
			{
				System.out.print("Value must be between 0 - 9: ");
				int1 = getInt();
			}while (!((int1 >= 0) && (int1 <= 9)));

			switch(int1)
			{
				case 1:
				// Show all packages in database, ordered by tracking ID.

				break;

				case 2:
				/* Add package to database, firsts requests all Package information from user, then creates a new Package. */

					do
					{
						System.out.print("\nEnter tracking number: ");
						string1 = sc.next();
						contains = st.hasPackage(string1);
						if(string1.length() != 5)
							System.out.println("Tracking number not long enough.");
						if(contains)
							System.out.println("Tracking number already in list, please choose another tracking number.");
					} while (string1.length() != 5 || contains);

				break;

				case 3:
				/* Remove package from database and echoes number removed. */

					System.out.print("Enter tracking number to be removed: ");
					string1 = sc.next();

					st.removePackage(string1);

				break;

				case 4:
				// Search for a package by tracking number, then display.
					System.out.print("Enter tracking number to be searched: ");
					trackingNo = sc.next();

					// Only checks packageList if tracking number is valid.
					if (trackingNo.length() == 5)
					{
						/* Adds all packages which match the tracking number are added to list2, as there is no check for duplicates within the list.
						*/
						for (Package tempPackage : st.packageList)
							if (trackingNo.equals(tempPackage.getTrackingNumber()))
								list2.add(tempPackage);

						// Same as case 1 above, prints all values in list2.
						itP = list2.listIterator();
						if (itP.hasNext())
						{
							printHeader();
							while (itP.hasNext())
							{
								Package tempPackage = itP.next();
							}
							Menu.printDashes();
							list2.clear(); // Resets list2 for future use.
						}
						else // No packages matching tracking number found.
							System.out.println("No packages match this tracking number.");
					}
					else // User input not correct length.
						System.out.println("Tracking number input invalid.");
				break;

				case 5:
					// Show list of all users in database.
				break;

				case 6:
					// Add new user to database.
				break;

				case 7:
					// Update user.
				break;

				case 8:
					// Complete a shipping transaction.
				break;

				case 9:
					// Show completed shipping transaction.
				break;

				default: // 0 - Exit program, stops outer loop
					done = true;
					break;
			}
		} while (!done);

		// Write object st to file.
		try{
			FileOutputStream fos = FileOutputStream("packages.dat");
			Object.OutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(st);
			fos.close();
		}catch (IOException ieo) {
			system.out.println(ioe);
		}
		//PrintWriter outFile = new PrintWriter("packages.txt");
		//outFile.close();
	}//end of main


	/**
		Prints header for console output.
	*/


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
			System.out.println("Input not an integer.");
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
			System.out.println("Input not an decimal number.");
			sc.next();
		}
		decimal = sc.nextFloat();
		return decimal;
	}
}
