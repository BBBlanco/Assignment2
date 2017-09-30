package database;

/**
	Parent class for users input into database.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class User implements Comparable <User>
{
	/**
		@param	idNo Employee's ID number (int).
		@param	first_name Employee's first name (string).
		@param 	last_name Employee's last name (string).
	*/

	public User(int idNo, String first_name, String last_name)
	{
		this.ID = idNo;
		this.fName = first_name;
		this.lName = last_name;
	}

	public int compareTo(User other)
	{
		int compareID = ((User) other).getID();
		return this.ID - compareID;
	}

	/**
		Getter for private member ID.
		@return User's ID.
	*/
	public int getID()
	{
		return ID;
	}

	/**
		Getter for private member fname.
		@return User's first name.
	*/
	public String getFirstName()
	{
		return fName;
	}

	/**
		Getter for private member lname.
		@return User's last name.
	*/
	public String getLastName()
	{
		return lName;
	}

	private int ID;
	private String fName;
	private String lName;
}
