package database;

/**
	Parent class for packages input into database.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

import java.util.*;

public class Package implements Comparable <Package>
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
	*/
	public Package(String trackingNumber, String ptype, String spec, String mClass)
	{
		this.trackingNo = trackingNumber;
		this.type = ptype;
		this.specification = spec;
		this.mailingClass = mClass;
	}

	/**
		Allows arrayList.contains(Package) to search for a string.
	*/
	@Override
	public boolean equals(Object o)
	{
		if (o == this) return true;
		if (!(o instanceof Package)) return false;
    Package object = (Package) o;
    return (this.trackingNo.equals(object.getTrackingNumber()));
	}

	/**
		Override in conjunction with equals.
	*/
	@Override
	public int hashCode()
	{
		return Objects.hash(trackingNo);
	}

	/**
		When sorted, will sort tracking number alphabetically.
	*/
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
	private String type;
	private String specification;
	private String mailingClass;
}
