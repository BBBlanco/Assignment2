package database;

/**
	A class for tracking completed shipping transactions.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

 import java.util.*;

public class Transaction implements Comparable <Transaction>
{
	/**
		@param custID Customer which received package.
		@param trackingNo Tracking number for package delivered.
		@param shipDate Date package was shipped.
		@param delDate Date package was delivered.
		@param cost Amount paid for package.
		@param empID Employee who completed transaction.
	*/

	public Transaction(int custID, String trackingNo, String shipDate, String delDate, float cost, int empID)
	{
		this.customerID = custID;
		this.trackingNumber = trackingNo;
		this.shippingDate = shipDate;
		this.deliveryDate = delDate;
		this.shippingCost = cost;
		this.employeeID = empID;
	}

	/**
		Allows arrayList.contains(User) to search for a string.
	*/
	@Override
	public boolean equals(Object o)
	{
		if (o == this) return true;
		if (!(o instanceof Transaction)) return false;
		Transaction object = (Transaction) o;
		return (this.customerID == object.getCustomerID() && this.trackingNumber == object.getTrackingNumber());
	}

	/**
		Override in conjunction with equals.
	*/
	@Override
	public int hashCode()
	{
		return Objects.hash(customerID, trackingNumber);
	}

	/**
		When sorted, will sort ID in ascending order.
	*/
	public int compareTo(Transaction o)
	{
		int diff = this.customerID - o.getCustomerID();
		if (diff != 0) return diff;

		diff = this.trackingNumber.compareToIgnoreCase(o.getTrackingNumber());
		return diff;
	}

	/**
		Getter for private member customerID.
		@return ID of customer who shipped package.
	*/
	public int getCustomerID()
	{
		return customerID;
	}

	/**
		Getter for private member trackingNumber.
		@return package's tracking number.
	*/
	public String getTrackingNumber()
	{
		return trackingNumber;
	}

	/**
		Getter for private member shippingDate.
		@return shipping date for package.
	*/
	public String getShipDate()
	{
		return shippingDate;
	}

	/**
		Getter for private member deliveryDate.
		@return delivery date for package.
	*/
	public String getDeliveryDate()
	{
		return deliveryDate;
	}

	/**
		Getter for private member shippingCost.
		@return Cost of shipping.
	*/
	public float getShippingCost()
	{
		return shippingCost;
	}

	/**
		Getter for private member employeeID.
		@return ID of employee who completed the sale.
	*/
	public int getEmployeeID()
	{
		return employeeID;
	}

  /**
    Displays formatted transaction information.
  */
  public void showTransaction()
  {
    System.out.format("|%11d|%10s|%13s|%13s|%11.2f|%11d|%n", this.customerID, this.trackingNumber, this.shippingDate, this.deliveryDate, this.shippingCost, this.employeeID);
  }

	private int customerID;
	private String trackingNumber;
	private String shippingDate;
	private String deliveryDate;
	private float shippingCost;
	private int employeeID;
}
