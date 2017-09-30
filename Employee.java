package database;

/**
	Child class of User, specifically for employees.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Employee extends User
{
	/**
		@param	idNo Employee's ID number (int).
		@param	first_name Employee's first name (string).
		@param 	last_name Employee's last name (string).
	  @param	social Employee's social security number (int).
	  @param	mSalary Employee's monthly salary (float).
	  @param	DDBankNo Employee's direct deposit bank account number (int).
	*/
	public Employee(int idNo, String first_name, String last_name, int social, float mSalary, int DDBankNo)
	{
		super(idNo, first_name, last_name);
		this.SSN = social;
		this.salary = mSalary;
		this.bankNo = DDBankNo;
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

	private int SSN;
	private float salary;
	private int bankNo;
}
