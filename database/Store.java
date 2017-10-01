package database;

/**
	Class to add/remove/update/display arrayLists of other classes.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

public class Store
{
  /**
  Displays all packages stored in package arrayList.
  */
  public void showPackages()
  {

  }

  /**
  Adds package information to package arrayList (uses upcasting).
  @param p Package (upcasted from subclasses) to be added to arrayList.
  */
  public void addPackage(Package p)
  {

  }

  /**
  Removes specific package from package arrayList (uses upcasting).
  @param s Tracking number for package to be removed.
  */
  public void removePackage(String s)
  {

  }

  /**
  Displays specific package information from package arrayList (uses upcasting).
  @param s Tracking number for package to be displayed.
  */
  public void showPackage(String s)
  {

  }

  /**
  Checks if tracking number is already in package arrayList.
  @param s Tracking number for package to be searched.
  @return True if tracking number is already present, false if otherwise.
  */
  public boolean hasPackage(String s)
  {
    return packageList.contains(s);
  }

  /**
  Displays all users stored in user arrayList.
  */
  public void showUsers()
  {

  }

  /**
  Displays user information stored in user arrayList (uses upcasting).
  */
  public void addUser(User u)
  {

  }

  /**
  Updates user information stored in user arrayList.
  */
  public void updateUser()
  {

  }

  /**
  Checks if user ID is already in user arrayList.
  @param s User ID for user to be searched.
  @return True if user ID is already present, false if otherwise.
  */
  public boolean hasPackage(int s)
  {
    return userList.contains(s);
  }

  /**
  Displays all completed transactions stored in transaction arrayList.
  */
  public void showTransactions()
  {

  }

  /**
  Completes transaction: creates new record in transaction arrayList and removes package from package arrayList.
  @param t Transaction to be added to be completed.
  */
  public void completeTransaction(Transaction t)
  {

  }

  private ArrayList<Package> packageList = new ArrayList<Package>();
  private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
  private ArrayList<User> userList = new ArrayList<User>();
}
