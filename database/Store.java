package database;

/**
	Class to add/remove/update/display arrayLists of other classes.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

import java.util.*;
import java.io.*;

public class Store
{
  public Store()
  {
    packageList = new ArrayList<Package>();
    userList = new ArrayList<User>();
    transactionList = new ArrayList<Transaction>();
    nextUserID = 1;

    try{
      //deserialize into packageList and userList
      FileInputStream packageIO= new FileInputStream("packages.dat");
      ObjectInputStream pIO = new ObjectInputStream(packageIO);
      packageList = (ArrayList) pIO.readObject();
      packageIO.close();
      pIO.close();

    }catch(FileNotFoundException fnfe){
      System.out.println("Transaction file not found.");
      packageList = new ArrayList<Package>();
    }catch(IOException ieo){
      System.out.println("Error with user import.");
      packageList = new ArrayList<Package>();
    }catch(ClassNotFoundException c){
      System.out.println("Package class not found.");
      packageList = new ArrayList<Package>();
    }

    try{
      //deserialize into packageList and userList
      FileInputStream userIO = new FileInputStream("users.dat");
      ObjectInputStream uIO = new ObjectInputStream(userIO);
      userList = (ArrayList) uIO.readObject();
      User temp = userList.get(userList.size()-1);
      nextUserID = temp.getID()+1;
      userIO.close();
      uIO.close();

    }catch(FileNotFoundException fnfe){
      System.out.println("User file not found.");
      userList = new ArrayList<User>();
      nextUserID = 1;
    }catch(IOException ieo){
      System.out.println("Error with user import.");
      userList = new ArrayList<User>();
      nextUserID = 1;
    }catch(ClassNotFoundException c){
      System.out.println("User class not found.");
      userList = new ArrayList<User>();
      nextUserID = 1;
    }

    try{
      //deserialize into packageList and userList
      FileInputStream transactionIO = new FileInputStream("transactions.dat");
      ObjectInputStream tIO = new ObjectInputStream(transactionIO);
      transactionList = (ArrayList) tIO.readObject();
      transactionIO.close();
      tIO.close();

    }catch(FileNotFoundException fnfe){
      System.out.println("Transaction file not found.");
      transactionList = new ArrayList<Transaction>();
    }catch(IOException ieo){
      System.out.println("Error with transaction import.");
      transactionList = new ArrayList<Transaction>();
    }catch(ClassNotFoundException c){
      System.out.println("Class not found");
      transactionList = new ArrayList<Transaction>();
    }
  }

  /**
  Displays all packages stored in package arrayList by iterating over the list and displaying the package based on its type.
  */

  public void serializeLists()
  {
    try{
      FileOutputStream packageIO= new FileOutputStream("packages.dat");
      ObjectOutputStream pIO = new ObjectOutputStream(packageIO);
      pIO.writeObject(packageList);
      packageIO.close();
      pIO.close();

      FileOutputStream userIO = new FileOutputStream("users.dat");
      ObjectOutputStream uIO = new ObjectOutputStream(userIO);
      uIO.writeObject(userList);
      userIO.close();
      uIO.close();

      FileOutputStream transactionIO = new FileOutputStream("transactions.dat");
      ObjectOutputStream tIO = new ObjectOutputStream(transactionIO);
      tIO.writeObject(transactionList);
      transactionIO.close();
      tIO.close();
    }catch(IOException ioe){
    	ioe.printStackTrace();
    }
  }

  /**
  Getter for specific user with ID i.
  @param t Tracking number for package being searched.
  @return Package with corresponding tracking number, if in list, null otherwise.
  */
  public Package getPackage(String t)
	{
		for(Package p : packageList)
    {
			if(p.getTrackingNumber().equals(t))
      {
        return p;
      }
		}
		return null;
	}

  /**
  Displays all packages currently in package list.
  */
  public void showPackages()
  {
    Iterator<Package> it = packageList.iterator();
    if(!it.hasNext())
    {
      System.out.println("No packages to show.");
    }
    while(it.hasNext())
    {
      Package temp = it.next();
      if (temp.getType().equals("Box"))
      {
        Box pack1 = (Box) temp;
        pack1.showPackage();
      }
      else if (temp.getType().equals("Crate"))
      {
        Crate pack1 = (Crate) temp;
        pack1.showPackage();
      }
      else if (temp.getType().equals("Drum"))
      {
        Drum pack1 = (Drum) temp;
        pack1.showPackage();
      }
      else if (temp.getType().equals("Envelope"))
      {
        Envelope pack1 = (Envelope) temp;
        pack1.showPackage();
      }
      else
      {
        Package pack1 = (Package) temp;
        pack1.showPackage();
      }
    }
  }

  /**
  Adds package to package arrayList (uses upcasting) and sorts package array.
  @param p Package (upcasted from subclasses) to be added to arrayList.
  */
  public void addPackage(Package p)
  {
    packageList.add(p);
    Collections.sort(packageList);
  }

  /**
  Removes specific package from package arrayList (uses upcasting) by first creating a dummy package from the string passed, then removing newly created dummy because of overriden Package.equals().
  @param s Tracking number for package to be removed.
  */
  public void removePackage(String s)
  {
    Package p = new Package(s,"","","");
    packageList.remove(p);
  }

  /**
  Displays specific package information from package arrayList by creating a dummy package from the string passed to be used for searching.
  @param s Tracking number for package to be displayed.
  */
  public void displayPackage(String s)
  {
    Package p = new Package(s,"","","");
    int index = packageList.indexOf(p);
    Package temp = packageList.get(index);
    if (temp.getType().equals("Box"))
    {
      Box pack1 = (Box) temp;
      pack1.showPackage();
    }
    else if (temp.getType().equals("Crate"))
    {
      Crate pack1 = (Crate) temp;
      pack1.showPackage();
    }
    else if (temp.getType().equals("Drum"))
    {
      Drum pack1 = (Drum) temp;
      pack1.showPackage();
    }
    else if (temp.getType().equals("Envelope"))
    {
      Envelope pack1 = (Envelope) temp;
      pack1.showPackage();
    }
    else
    {
      Package pack1 = (Package) temp;
      pack1.showPackage();
    }
  }

  /**
  Checks if tracking number is already in package arrayList by creatig a dummy package then using list.contains().
  @param s Tracking number for package to be searched.
  @return True if tracking number is already present, false if otherwise.
  */
  public boolean hasPackage(String s)
  {
    Package p = new Package(s,"","","");
    return packageList.contains(p);
  }

  /**
  Checks if database has packages.
  @return True if tracking number is already present, false if otherwise.
  */
  public boolean hasPackages()
  {
    Iterator<Package> it = packageList.iterator();
    if (it.hasNext())
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
  Displays all users stored in user arrayList, using the same logic as showPackages().
  */
  public void showUsers()
  {
    Iterator<User> it = userList.iterator();
    if(!it.hasNext())
    {
      System.out.println("No users to show.");
    }
    while(it.hasNext())
    {
      User temp = it.next();
      if (temp.getType().equals("Customer"))
      {
        Customer user1 = (Customer) temp;
        user1.showUser();
      }
      if (temp.getType().equals("Employee"))
      {
        Employee user1 = (Employee) temp;
        user1.showUser();
      }
    }
  }

  /**
  Adds user to user arrayList (uses upcasting), keeps track of user ID, and sorts user array.
  @param u User to be added to list.
  */
  public void addNewUser(User u)
  {
    userList.add(u);
    Collections.sort(userList);
    this.nextUserID++;
  }

  /**
  Adds user to user arrayList (uses upcasting) and sorts user array, does not alter next user ID to be inserted.
  @param u User to be added to list.
  */
  public void addUser(User u)
  {
    userList.add(u);
    Collections.sort(userList);
  }

  /**
  Updates user information stored in user arrayList, removes previous user then readds updated user.
  */
  public void updateUser(User u)
  {

    userList.remove(u);
    Collections.sort(userList);
  }

  /**
  Checks if user ID is already in user arrayList, same logic as hasPackage().
  @param s User ID for user to be searched.
  @return True if user ID is already present, false if otherwise.
  */
  public boolean hasUser(int s)
  {
    User u = new User(s, "", "","");
    return userList.contains(u);
  }

  /**
  Checks if user list has at least 1 customer.
  @return True if arrayList has at least 1 customer.
  */
  public boolean hasCustomers()
  {
    Iterator<User> it = userList.iterator();
    while (it.hasNext())
    {
      User temp = it.next();
      if(temp.getType().equals("Customer"))
      {
        return true;
      }
    }
    return false;
  }

  /**
  Checks if user list has at least 1 employee.
  @return True if arrayList has at least 1 employee.
  */
  public boolean hasEmployees()
  {
    Iterator<User> it = userList.iterator();
    while (it.hasNext())
    {
      User temp = it.next();
      if(temp.getType().equals("Employee"))
      {
        return true;
      }
    }
    return false;
  }

  /**
  Checks if user is a customer.
  @param i user ID to test if type is customer
  @return True if ID in argument belongs to an customer.
  */
  public boolean isCustomer(int i)
  {
    Iterator<User> it = userList.iterator();
    while (it.hasNext())
    {
      User temp = it.next();
      if((temp.getType().equals("Customer")) && (temp.getID() == i))
      {
        return true;
      }
    }
    return false;
  }

  /**
  Checks if user is an employee.
  @param i user ID to test if type is employee
  @return True if ID in argument belongs to an employee.
  */
  public boolean isEmployee(int i)
  {
    Iterator<User> it = userList.iterator();
    while (it.hasNext())
    {
      User temp = it.next();
      if((temp.getType().equals("Employee")) && (temp.getID() == i))
      {
        return true;
      }
    }
    return false;
  }

  /**
  Displays only customer records in user list.
  */
  public void showCustomers()
  {
    Iterator<User> it = userList.iterator();
    if(this.hasCustomers())
    {
      while (it.hasNext())
      {
        User temp = it.next();
        if(temp.getType().equals("Customer"))
        {
          Customer temp2 = (Customer) temp;
          temp2.showUser();
        }
      }
    }
    else
    {
      System.out.println("List has no customers.");
    }
  }

  /**
  Displays only employee records in user list.
  */
  public void showEmployees()
  {
    Iterator<User> it = userList.iterator();
    if(this.hasEmployees())
    {
      while (it.hasNext())
      {
        User temp = it.next();
        if(temp.getType().equals("Employee"))
        {
          Employee temp2 = (Employee) temp;
          temp2.showUser();
        }
      }
    }
    else
    {
      System.out.println("List has no employee.");
    }
  }

  /**
  Getter for specific user with ID i.
  @param i ID for user to be returned.
  @return User with corresponding ID, if in list, null otherwise.
  */
  public User getUser(int i)
  {
    for(User u : userList)
    {
      if(u.getID() == i)
      {
        return u;
      }
    }
    return null;
  }

  /**
  Displays all completed transactions stored in transaction arrayList.
  */
  public void showTransactions()
  {
    Iterator<Transaction> it = transactionList.iterator();
    if(!it.hasNext())
    {
      System.out.println("No completed transactions to show.");
    }
    while(it.hasNext())
    {
      Transaction temp = it.next();
      temp.showTransaction();
    }
  }

  /**
  Completes transaction: creates new record in transaction arrayList, removes package from package arrayList, and sorts transaction array.
  @param s Transaction to be added to be completed.
  */
  public void completeTransaction(Transaction s)
  {
    this.removePackage(s.getTrackingNumber());
    transactionList.add(s);
    Collections.sort(transactionList);
  }

  /**
  Variable userID holds the ID to be used for the next user input into database.
  @return Next user ID to be used when creating a new user.
  */
  public int getNextID()
  {
    return nextUserID;
  }

  private ArrayList<Package> packageList;
  private ArrayList<Transaction> transactionList;
  private ArrayList<User> userList;
  private int nextUserID;
}
