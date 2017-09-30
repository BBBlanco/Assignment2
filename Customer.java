package database;

/**
	Child class of User, specifically for customers.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Customer extends User
{
	/**
		@param	idNo Customer's ID number (int).
		@param	first_name Customer's first name (string).
		@param 	last_name Customer's last name (string).
	  @param	phoneNo Customer's phone number (string).
	  @param	add Customer's address (string).
	*/
	public Customer(int idNo, String first_name, String last_name, String phoneNo, String add)
	{
		super(idNo, first_name, last_name);
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

	private String phone;
	private String address;
}
