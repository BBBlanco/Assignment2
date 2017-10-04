package database;

/**
	Parent class for packages input into database.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

import java.util.*;
import java.io.*;

public class Package implements Serializable, Comparable <Package>
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
		@param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
		@param ptype Package's type.
	*/
	public Package(String trackingNumber, String spec, String mClass, String pType)
	{
		this.trackingNo = trackingNumber;
		this.specification = spec;
		this.mailingClass = mClass;
		this.type = pType;
	}

	/**
		Allows arrayList.contains(Package) to search for a string.
	*/
	@Override
	public boolean equals(Object object)
	{
		if (object == this) return true;
		if (!(object instanceof Package)) return false;
    Package o = (Package) object;
    return (this.trackingNo.equals(o.getTrackingNumber()));
	}

	/**
		Override in conjunction with equals.
	*/
	@Override
	public int hashCode()
	{
		return Objects.hash(this.trackingNo);
	}

	/**
		Displays formatted envelope information.
	*/
	public void showPackage()
	{
		System.out.format("|%10s|%8s|%13s|%11s|%14s|%13s|%n", this.trackingNo, this.type, this.specification, this.mailingClass, "N/A", "N/A");
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
		Getter for private member type.
		@return package's type as a String.
	*/
	public String getType()
	{
		return type;
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
