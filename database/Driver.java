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

			do
			{ // Shows menu and requests user input until 6 is entered.
				Menu.menu();
				do
				{ // Asks for user's input until input is valid.
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
					System.out.print("Enter tracking number: ");
					string1 = sc.nextLine();
					bool1 = store.hasPackage(string1);
					if(string1.length() != 5)
						System.out.println("Tracking number must be 5 characters.");
					if(bool1)
						System.out.println("Tracking number already in list, please choose another tracking number.");
				} while (string1.length() != 5 || bool1);

				Menu.specMenu();
				do
				{
					System.out.print("Enter package specification (1-5): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 5)));
				string2 = Menu.getSpecification(choice);

				Menu.mailingClassMenu();
				do
				{
					System.out.print("Enter package mailing class (1-5): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 5)));
				string3 = Menu.getMailingClass(choice);

				Menu.pTypeMenu();
				do
				{
					System.out.print("Enter package type (1-9): ");
					choice = Menu.getInt();
				}while (!((choice >= 1) && (choice <= 9)));
				string4 = Menu.getPType(choice);

				switch(choice)
				{
					case 1: // Envelope (height/width)
					System.out.print("Enter envelope's height: ");
					int1 = Menu.getInt();
					System.out.print("Enter envelope's width: ");
					int2 = Menu.getInt();
					Envelope e = new Envelope(string1, string2, string3, string4, int1, int2);
					store.addPackage(e);
					break;

					case 2: // Crate (content/max load)
					System.out.print("Enter crate's content: ");
					string5 = sc.nextLine();
					System.out.print("Enter crate's max load: ");
					float1 = Menu.getFloat();
					Crate c = new Crate(string1, string2, string3, string4, string5, float1);
					store.addPackage(c);
					break;

					case 3: // Drum (material/diameter)
					do
					{
						Menu.materialMenu();
						System.out.print("Enter drum's material: ");
						choice = Menu.getInt();
					} while (!(choice == 1 || choice == 2));

					string5 = Menu.getMaterial(choice);
					System.out.print("Enter drum's diameter: ");
					int1 = Menu.getInt();
					Drum d = new Drum(string1, string2, string3, string4, string5, int1);
					store.addPackage(d);
					break;

					case 4: // Box (dimension/volume)
					System.out.print("Enter box's largest dimension: ");
					int1 = Menu.getInt();
					System.out.print("Enter box's volume: ");
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
					System.out.print("Enter tracking number to be removed: ");
					string1 = sc.nextLine();
					if(store.hasPackage(string1))
					{
						store.removePackage(string1);
					}
					else
					{
						System.out.println("Tracking number not in database.\n");
					}
				break;

				case 4:
				/* Search for a package by tracking number, then display. */
				System.out.print("Enter tracking number to display: ");
				string1 = sc.nextLine();
				if(store.hasPackage(string1))
				{
					Menu.printPHeader();
					store.displayPackage(string1);
					Menu.printDashes();
				}
				else
				{
					System.out.println("Tracking number not in database.\n");
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
				System.out.print("Enter user's first name: ");
				string1 = sc.nextLine();
				System.out.print("Enter user's last name: ");
				string2 = sc.nextLine();

				Menu.uTypeMenu();
				do
				{
					System.out.print("Enter user type (1-2): ");
					choice = Menu.getInt();
				}while (!(choice == 1 || choice == 2));
				string3 = Menu.getUType(choice);


				switch(choice)
				{
					case 1: // Customer
					System.out.print("Enter customer's phone number: ");
					string4 = sc.nextLine();
					System.out.print("Enter customer's address: ");
					string5 = sc.nextLine();
					Customer cust = new Customer(int1, string1, string2, string3, string4, string5);
					store.addNewUser(cust);
					break;

					case 2: // Employee
					System.out.print("Enter employee's social security number: ");
					int2 = Menu.getInt();
					System.out.print("Enter employee's salary: ");
					float1 = Menu.getFloat();
					System.out.print("Enter employee's direct deposit bank number: ");
					int3 = Menu.getInt();
					Employee empl = new Employee(int1, string1, string2, string3, int2, float1, int3);
					store.addNewUser(empl);
					break;
				}
				break;

				case 7:
				/* Update user. */
				if(store.hasEmployees() || store.hasCustomers())
				{
					Menu.printUHeader();
					store.showUsers();
					Menu.printDashes();
					do
					{
						System.out.print("Enter user ID to update: ");
						int1 = Menu.getInt();
					}while (!(store.hasUser(int1)));

					System.out.print("Enter new first name: ");
					string1 = sc.nextLine();
					System.out.print("Enter new last name: ");
					string2 = sc.nextLine();

					User temp = store.getUser(int1);
					string3 = temp.getType();

					switch(string3)
					{
						case "Customer": // Customer
						System.out.print("Enter customer's new phone number: ");
						string4 = sc.nextLine();
						System.out.print("Enter customer's new address: ");
						string5 = sc.nextLine();
						Customer cust = new Customer(int1, string1, string2, string3, string4, string5);
						store.addUser(cust);
						break;

						case "Employee": // Employee
						System.out.print("Enter employee's new social security number: ");
						int2 = Menu.getInt();
						System.out.print("Enter employee's new salary: ");
						float1 = Menu.getFloat();
						System.out.print("Enter employee's new direct deposit bank number: ");
						int3 = Menu.getInt();
						Employee empl = new Employee(int1, string1, string2, string3, int2, float1, int3);
						store.addUser(empl);
						break;
					}
				}
				break;

				case 8:
				/* Complete a shipping transaction. */
				if(store.hasEmployees() && store.hasCustomers() && store.hasPackages())
				{
					Menu.printPHeader();
					store.showPackages();
					Menu.printDashes();
					do
					{
						System.out.print("Enter the tracking number of transaction you want to complete: ");
						string1 = sc.nextLine();
				  }while(!(store.hasPackage(string1)));

					Menu.printUHeader();
					store.showCustomers();
					Menu.printDashes();
					do
					{
						System.out.print("Enter customer ID for transaction: ");
						int1 = Menu.getInt();
					}while (!(store.isCustomer(int1)));

					Menu.printUHeader();
					store.showEmployees();
					Menu.printDashes();
					do
					{
						System.out.print("Enter employee ID for transaction: ");
						int2 = Menu.getInt();
					}while (!(store.isEmployee(int2)));

					System.out.print("Enter cost of transaction: ");
					float1 = Menu.getFloat();

					System.out.print("Enter shipping date: ");
					string2 = sc.nextLine();

					System.out.print("Enter delivery date: ");
					string3 = sc.nextLine();

					Transaction t = new Transaction(int1, string1, string2, string3, float1, int2);
					store.completeTransaction(t);
				}
				else
				{
					System.out.println("\nDatabase cannot process sale, no customer/employee/package.");
				}
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
	} // End of main
} // End of Driver
