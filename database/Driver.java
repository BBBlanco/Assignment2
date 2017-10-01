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
		ArrayList<Package> list1 - List to hold packages imported and created by user.
		ArrayList<Package> list2 - List to hold packages when searching.
		ListIterator it - Iterator to traverse list1.
		File file - file for initial import.
		Scanner sc - reads input from user.
		boolean done - program loop control variable, becomes true if user
						enter 6 in menu option.
		int choice - variable to hold user's input choice from menu.
		int location - variable to hold position to be deleted from array.
		int volume - variable to hold package's volume for package construction.
		float weight - same as volume, additionally holds one boundary for search for weight.
		float weight2 - holds second boundary for search for weight.
		float tempWeight - value used for comparison of weight for search.
		String trackingNo, type, spec, mClass - see volume.
		*/
		//ArrayList<Package> packageList = new ArrayList<Package>();
		ArrayList<Package> list1 = new ArrayList<Package>();
		ArrayList<Package> list2 = new ArrayList<Package>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Store> storeList = new ArrayList<Store>();
		Store st;
		ListIterator<Package> itP;
		ListIterator<User> itU;
		ListIterator<Store> itS;
		File file = new File("packages.txt");
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		int choice, location, volume;
		float weight, weight2, tempWeight;
		String trackingNo, type, spec, mClass;

		//Checks if file for initial database values exists, then imports records.
		//if(file.exists())
		//{
		try{
			//FileReader fr = new FileReader("packages.txt");
			FileInputStream fis = new FileInputStream("packages.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			st = (Store) ois.readObject(); //read object from stream, restoring contents of each field in Store object
			fis.close();
		}catch (FileNotFoundException fnfe) {
			//first time running program
			//Store st = new Store();
		}catch (IOException ioe) {
			System.out.println(ioe);
			return; //leave main
		}catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe);
			return; //leave main
		}

			//Scanner inFile = new Scanner(fr);
			//while (inFile.hasNextLine())
			//{
				// Grabs next line from file, breaks the long string into an array.
				//String line = inFile.nextLine();
				//String[] words = line.split(" ");

				//if (words.length == 6)
				//{
					// Assigns values to variables to import.
					//trackingNo = words[0];
					//type = words[1];
					//spec = words[2];
					//mClass = words[3];
					//weight = Float.parseFloat(words[4]);
					//volume = Integer.parseInt(words[5]);
					//Package package1 = new Package(trackingNo, type, spec, mClass, weight, volume);
					//list1.add(package1);
			//inFile.close();
		//}


		do // Shows menu and requests user input until 6 is entered.
		{
			Menu.menu();
			do // Asks for user's input until input is valid.
			{
				System.out.print("Value must be between 0 - 9: ");
				choice = getInt();
			}while (!((choice >= 0) && (choice <= 9)));

			switch(choice)
			{
				case 1:
				// Show all packages in database, ordered by tracking ID.
					Collections.sort(st.packageList);
					itP = st.packageList.listIterator();
					if (itP.hasNext())
					{
						Menu.printPHeader();
						while (itP.hasNext())
						{
							Package tempPackage = itP.next();
						}

						Menu.printDashes();
					}
					else
						System.out.println("No packages to display.");
				break;

				case 2:
				/* Add package to database, firsts requests all Package information from user, then creates a new Package, then adds it to st.packageList */

					// Asks for tracking number verifying string has valid length.
					do
					{
						System.out.print("Enter tracking number: ");
						trackingNo = sc.next();
					} while (trackingNo.length() != 5);

					// Asks user for type from menu until valid input is received.
					do
					{
						Menu.typeMenu();
						choice = getInt();
					} while (!(0 < choice && choice < 10));
					type = Menu.getType(choice);

					// Asks user for specification from menu until valid input is received.
					do
					{
						Menu.specMenu();
						choice = getInt();
					} while (!(0 < choice && choice < 6));
					spec = Menu.getSpecification(choice);

					// Asks user for mailing class from menu until valid input is received.
					do
					{
						Menu.mailingClassMenu();
						choice = getInt();
					} while (!(0 < choice && choice < 6));
					mClass = Menu.getMailingClass(choice);

					Package package1 = new Package(trackingNo, type, spec, mClass);
					st.packageList.add(package1);
					//list1.add(package1);
				break;

				case 3:
				/* Remove package from database and echoes number removed.
				*/
					System.out.print("Enter tracking number to be removed: ");
					trackingNo = sc.next();

					int numRemoved = 0;

					for (int i = 0; i < st.packageList.size(); i++)
						if (trackingNo.equals(st.packageList.get(i).getTrackingNumber()))
						{
							numRemoved++;
							System.out.println("Removing package.");
							st.packageList.remove(i);
						}

					System.out.println(numRemoved+" pacakages removed.");
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
