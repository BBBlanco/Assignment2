package database;

/**
	Parent class for users input into database.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

import java.util.*;

public class User implements Serializable, Comparable <User>
{
	/**
		@param	idNo User's ID number (int).
		@param	firstName User's first name (string).
		@param 	lastName User's last name (string).
		@param	userType User's type (string).
	*/

	public User(int idNo, String firstName, String lastName, String userType)
	{
		this.ID = idNo;
		this.fName = firstName;
		this.lName = lastName;
		this.type = userType;
	}

	/**
		Allows arrayList.contains(User) to search for a string.
	*/
	@Override
	public boolean equals(Object object)
	{
		if (object == this) return true;
		if (!(object instanceof User)) return false;
		User o = (User) object;
		return (this.ID == o.getID());
	}

	/**
		Override in conjunction with equals.
	*/
	@Override
	public int hashCode()
	{
		return Objects.hash(ID);
	}

	/**
		When sorted, will sort ID in ascending order.
	*/
	public int compareTo(User other)
	{
		return this.ID - other.getID();
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

	/**
		Getter for private member type.
		@return User's last name.
	*/
	public String getType()
	{
		return type;
	}

	private int ID;
	private String fName;
	private String lName;
	private String type;
}
