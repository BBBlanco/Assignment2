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
				Menu.printPHeader();
				store.showPackages();
				Menu.printDashes();
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
					System.out.print("Enter package specification (1-5): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 5)));
				string2 = Menu.getSpecification(choice);

				Menu.mailingClassMenu();
				do {
					System.out.print("Enter package mailing class (1-5): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 5)));
				string3 = Menu.getMailingClass(choice);

				Menu.pTypeMenu();
				do {
					System.out.print("Enter package type (1-9): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 9)));
				string4 = Menu.getPType(choice);

					switch(choice)
					{
						case 1: // Envelope (height/width)
						System.out.print("\nEnter envelope's height: ");
						int1 = Menu.getInt();
						System.out.print("\nEnter envelope's width: ");
						int2 = Menu.getInt();
						Envelope e = new Envelope(string1, string2, string3, string4, int1, int2);
						store.addPackage(e);
						break;

						case 2: // Crate (content/max load)
						System.out.print("\nEnter crate's content: ");
						string5 = sc.next();
						System.out.print("\nEnter crate's max load: ");
						float1 = Menu.getFloat();
						Crate c = new Crate(string1, string2, string3, string4, string5, float1);
						store.addPackage(c);
						break;

						case 3: // Drum (material/diameter)
						do
						{
							Menu.materialMenu();
							choice = Menu.getInt();
						} while (!(choice == 1 || choice == 2));
						string5 = Menu.getMaterial(choice);
						System.out.print("\nEnter crate's max load: ");
						int1 = Menu.getInt();
						Drum d = new Drum(string1, string2, string3, string4, string5, int1);
						store.addPackage(d);
						break;

						case 4: // Box (dimension/volume)
						System.out.print("\nEnter box's largest dimension: ");
						int1 = Menu.getInt();
						System.out.print("\nEnter box's volume: ");
						int2 = Menu.getInt();
						Box b = new Box(string1, string2, string3, string4, int1, int2);
						store.addPackage(b);
						break;

						default: // All others
						Package p = new Package(string1, string2, string3, string4);
						store.addPackage(p);
						break;
					}
				break;

				case 3:
				/* Remove package from database. */
					System.out.print("\nEnter tracking number to be removed: ");
					string1 = sc.next();
					if(store.hasPackage(string1))
					{
						store.removePackage(string1);
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
					Menu.printPHeader();
					store.displayPackage(string1);
					Menu.printDashes();
				}
				else
				{
					System.out.println("Tracking number not in database.");
				}
				break;

				case 5:
				/* Show list of all users in database. */
				Menu.printUHeader();
				store.showUsers();
				Menu.printDashes();
				break;

				case 6:
				/* Add new user to database. */
				int1 = store.getNextID();
				System.out.print("\nEnter user's first name: ");
				string1 = sc.next();
				System.out.print("\nEnter user's last name: ");
				string2 = sc.next();

				Menu.uTypeMenu();
				do {
					System.out.print("Enter user type (1-2): ");
					choice = Menu.getInt();
				}while (!(choice == 1 || choice == 2));
				string3 = Menu.getUType(choice);


				switch(choice)
				{
					case 1: // Customer
					System.out.print("\nEnter customer's phone number: ");
					string4 = sc.next();
					System.out.print("\nEnter customer's address: ");
					string5 = sc.next();
					Customer cust = new Customer(int1, string1, string2, string3, string4, string5);
					store.addUser(cust);
					break;

					case 2: // Employee
					System.out.print("\nEnter employee's social security number: ");
					int2 = Menu.getInt();
					System.out.print("\nEnter employee's salary: ");
					float1 = Menu.getFloat();
					System.out.print("\nEnter employee's direct deposit bank number: ");
					int3 = Menu.getInt();
					Employee empl = new Employee(int1, string1, string2, string3, int2, float1, int3);
					store.addUser(empl);
					break;
				}

				case 7:
				/* Update user. */
				Menu.showPackages();
				do {
					System.out.print("Enter tracking number of shipping transaction you want to complete. ");
					string1 = sc.next();
				}while (!hasPackage(string1));
				Package p = new Package();
				p = store.findPackage(string1); //found package, 
				string 1 = p.getTrackingNumber();
				store.getNextID
				store.completeTransaction(p);
				break;

				case 8:
				/* Complete a shipping transaction. */
				//Store.showPackages();
				//print("Enter tracking number of shipping transaction you want to complete.");
				//string1 = sc.next();
				//if(store.hasPackage(string1))
				//{
					//Store.completeTransaction();

				break;

				case 9:
				/*Show completed shipping transaction.*/
				Menu.printTHeader();
				store.showTransactions();
				Menu.printDashes();
				break;

				default: // 0 - Exit program, stops outer loop
					done = true;
					break;
			}
		} while (!done);
		store.serializeLists();
	}//end of main
} // End of main
