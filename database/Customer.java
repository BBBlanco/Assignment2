package database;

/**
	Child class of User, specifically for customers.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

public class Customer extends User
{
	/**
		@param	idNo Customer's ID number (int).
		@param	firstName Customer's first name (string).
		@param 	lastName Customer's last name (string).
		@param	userType User's type (string).
	  @param	phoneNo Customer's phone number (string).
	  @param	add Customer's address (string).
	*/
	public Customer(int idNo, String firstName, String lastName, String userType, String phoneNo, String add)
	{
		super(idNo, firstName, lastName, userType);
		this.phone = phoneNo;
		this.address = add;
	}

	/**
		Getter for private member phone.
		@return Customer's phone number.
	*/
	public String getPhone()
	{
		return phone;
	}

	/**
		Getter for private member address.
		@return Customer's address.
	*/
	public String getAddress()
	{
		return address;
	}

	/**
		Displays formatted customer information.
	*/
	public void showUser()
	{
		System.out.format("|%7d|%10s|%10s|%4s|%12s|%14s|%11d|%n", this.getID(), this.getFirstName(), this.getLastName(), this.getType(), this.phone, this.address,00000000000);
	}

	private String phone;
	private String address;
}
