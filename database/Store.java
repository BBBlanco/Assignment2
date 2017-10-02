package database;

/**
	Class to add/remove/update/display arrayLists of other classes.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

import java.util.*;

public class Store
{
  public Store()
  {
    packageList = new ArrayList<Package>();
    transactionList = new ArrayList<Transaction>();
    userList = new ArrayList<User>();
  }

  /**
  Displays all packages stored in package arrayList by iterating over the list and displaying the package based on its type.
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
      if (temp.getType().equals("Crate"))
      {
        Crate pack1 = (Crate) temp;
        pack1.showPackage();
      }
      if (temp.getType().equals("Drum"))
      {
        Drum pack1 = (Drum) temp;
        pack1.showPackage();
      }
      if (temp.getType().equals("Envelope"))
      {
        Envelope pack1 = (Envelope) temp;
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
    if (temp.getType().equals("Crate"))
    {
      Crate pack1 = (Crate) temp;
      pack1.showPackage();
    }
    if (temp.getType().equals("Drum"))
    {
      Drum pack1 = (Drum) temp;
      pack1.showPackage();
    }
    if (temp.getType().equals("Envelope"))
    {
      Envelope pack1 = (Envelope) temp;
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
      if (temp.getType().equals("Cust"))
      {
        Customer user1 = (Customer) temp;
        user1.showUser();
      }
      if (temp.getType().equals("Empl"))
      {
        Customer user1 = (Customer) temp;
        user1.showUser();
      }
    }
  }

  /**
  Adds user to user arrayList (uses upcasting) and sorts user array.
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
  @param t Transaction to be added to be completed.
  */
  public void completeTransaction(Transaction t)
  {
    transactionList.add(t);
    Collections.sort(transactionList);
  }

  private ArrayList<Package> packageList;
  private ArrayList<Transaction> transactionList;
  private ArrayList<User> userList;
}
