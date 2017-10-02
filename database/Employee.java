package database;

/**
	Child class of User, specifically for employees.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

public class Employee extends User
{
	/**
		@param	idNo Employee's ID number (int).
		@param	firstName Employee's first name (string).
		@param 	lastName Employee's last name (string).
		@param	userType User's type (string).
	  @param	social Employee's social security number (int).
	  @param	mSalary Employee's monthly salary (float).
	  @param	DDBankNo Employee's direct deposit bank account number (int).
	*/
	public Employee(int idNo, String firstName, String lastName, String userType, int social, float mSalary, int ddBankNo)
	{
		super(idNo, firstName, lastName, userType);
		this.SSN = social;
		this.salary = mSalary;
		this.bankNo = ddBankNo;
	}

	/**
		Getter for private member SSN.
		@return Employee's SSN.
	*/
	public int getSSN()
	{
		return SSN;
	}

	/**
		Getter for private member salary.
		@return Employee's salary.
	*/
	public float getSalary()
	{
		return salary;
	}

	/**
		Getter for private member bank number.
		@return Employee's bank number.
	*/
	public int getBankNo()
	{
		return bankNo;
	}

	/**
		Displays formatted employee information.
	*/
	public void showUser()
	{
		System.out.format("|%7d|%10s|%10s|%4s|%12s|%14.2f|%11d|%n", this.getID(), this.getFirstName(), this.getLastName(), this.getType(), this.SSN, this.salary, this.bankNo);
	}

	private int SSN;
	private float salary;
	private int bankNo;
}
