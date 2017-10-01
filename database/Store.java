package database;
import java.util.*;
/**
	A class for tracking completed shipping transactions.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Store
{
	ArrayList<Package> packageList = new ArrayList<Package>();
	/**
		@param custID Customer which received package.
		@param trackingNo Tracking number for package delivered.
		@param shipDate Date package was shipped.
		@param delDate Date package was delivered.
		@param cost Amount paid for package.
		@param empID Employee who completed transaction.
	*/

	public Store(int custID, String trackingNo, String shipDate, String delDate, float cost, int empID)
	{

		this.customerID = custID;
		this.trackingNumber = trackingNo;
		this.shippingDate = shipDate;
		this.deliveryDate = delDate;
		this.shippingCost = cost;
		this.employeeID = empID;
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

	private int customerID;
	private String trackingNumber;
	private String shippingDate;
	private String deliveryDate;
	private float shippingCost;
	private int employeeID;
}
