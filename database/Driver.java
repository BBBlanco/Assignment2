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

		Scanner sc = new Scanner(System.in);
		Store store = new Store();
		boolean done = false, bool1 = false;
		int int1, int2, int3, choice;
		float float1;
		String string1, string2, string3, string4, string5;

	do // Shows menu and requests user input until 6 is entered.
		{
			Menu.menu();
			do // Asks for user's input until input is valid.
			{
				System.out.print("Value must be between 0 - 9: ");
				choice = Menu.getInt();
			}while (!((choice >= 0) && (choice <= 9)));

			switch(choice)
			{
				case 1:
				// Show all packages in database, ordered by tracking ID.
				store.showPackages();
				break;

				case 2:
				/* Add package to database, firsts requests all Package information from user, then creates a new Package. */
					do
					{
						System.out.print("\nEnter tracking number: ");
						string1 = sc.next();
						bool1 = store.hasPackage(string1);
						if(string1.length() != 5)
							System.out.println("Tracking number not long enough.");
						if(bool1)
							System.out.println("Tracking number already in list, please choose another tracking number.");
					} while (string1.length() != 5 || bool1);

					Menu.specMenu();
					do {
						System.out.print("\nEnter package specification (1-5): ");
						int1 = Menu.getInt();
						string2 = Menu.getSpecification(int1);
					}while (!((int1 >= 1) && (int1 <= 5)));

					Menu.mailingClassMenu();
					do {
						System.out.print("\nEnter package mailing class (1-5): ");
						int1 = Menu.getInt();
						string3 = Menu.getMailingClass(int1);
					}while (!((int1 >= 1) && (int1 <= 5)));

					Menu.pTypeMenu();
					do {
						System.out.print("\nEnter package type (1-9): ");
						int1 = Menu.getInt();
						string4 = Menu.getpType(int1);
					}while (!((int1 >= 1) && (int1 <= 9)));

					switch(int1)
					{
						case 1: // Envelope (height/width)
							System.out.print("\nEnter envelope's height: ");
							int2 = Menu.getInt();
							System.out.print("\nEnter envelope's width: ");
							int3 = Menu.getInt();
							Envelope p = new Envelope(string1, string2, string3, string4, int2, int3);
							store.addPackage(p);
						break;

						case 2: // Crate (content/max load)
							System.out.print("\nEnter crate's content: ");
							string5 = sc.next();
							System.out.print("\nEnter crate's max load: ");
							float1 = Menu.getFloat();
							Crate p = new Crate(string1, string2, string3, string4, string5, float1);
							store.addPackage(p);
						break;

						case 3: // Drum (material/diameter)
							do
							{
								Menu.materialMenu();
								int1 = Menu.getInt();
							} while (!(int2 == 1 || int2 == 2));
							string5 = Menu.getMaterial(int2);
							System.out.print("\nEnter crate's max load: ");
							int2 = Menu.getInt();
							Drum p = new Drum(string1, string2, string3, string4, string5, int2);
							store.addPackage(p);
						break;

						case 4; // Box (dimension/volume)
							System.out.print("\nEnter box's largest dimension: ");
							int2 = Menu.getInt();
							System.out.print("\nEnter box's volume: ");
							int3 = Menu.getInt();
							Crate p = new Crate(string1, string2, string3, string4, int2, int3);
							store.addPackage(p);
						break;

						default: // All others
							Package p = new Package(string1, string2, string3, string4);
						break;
					}
				break;

				case 3:
				/* Remove package from database. */
					System.out.print("\nEnter tracking number to be removed: ");
					string1 = sc.next();
					if(store.hasPackage(string1))
					{
						store.remove(string1);
					}
					else
					{
						System.out.println("Tracking number not in database.");
					}
				break;

				case 4:
				/* Search for a package by tracking number, then display. */
				System.out.print("\nEnter tracking number to display: ");
				string1 = sc.next();
				if(store.hasPackage(string1))
				{
					store.displayPackage(string1);
				}
				else
				{
					System.out.println("Tracking number not in database.");
				}
				break;

				case 5:
				/* Show list of all users in database. */
				break;

				case 6:
				/* Add new user to database. */
				break;

				case 7:
				/* Update user. */
				break;

				case 8:
				/* Complete a shipping transaction. */
				break;

				case 9:
				/*Show completed shipping transaction.*/
				store.showTransactions();
				break;

				default: // 0 - Exit program, stops outer loop
					done = true;
					break;
			}
		} while (!done);
		store.serializeLists();
	}//end of main
} // End of main
