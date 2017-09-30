package database;

/**
	Parent class for packages input into database.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Package implements Comparable <Package>
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
	*/
	public Package(String trackingNumber, String spec, String mClass)
	{
		this.trackingNo = trackingNumber;
		this.specification = spec;
		this.mailingClass = mClass;
	}

	public int compareTo(Package other)
	{
		return this.trackingNo.compareTo(other.getTrackingNumber());
	}

	/**
		Getter for private member tracking number.
		@return package's tracking number as a String.
	*/
	public String getTrackingNumber()
	{
		return trackingNo;
	}

	/**
		Getter for private member specification.
		@return package's specification as a String.
	*/
	public String getSpecification()
	{
		return specification;
	}

	/**
		Getter for private member mailingClass.
		@return package's mailingClass as a String.
	*/
	public String getMailingClass()
	{
		return mailingClass;
	}

	private String trackingNo;
	private String specification;
	private String mailingClass;
}
