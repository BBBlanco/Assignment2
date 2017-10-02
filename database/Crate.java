package database;

/**
	Child class of Package, specifically for crates.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

public class Crate extends Package
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
		@param maxLoad Crate's max load weight (float).
		@param content Crate's content (string).
	*/

	public Crate(String trackingNumber, String ptype, String spec, String mClass, String content, float maxLoad)
	{
		super(trackingNumber, ptype, spec, mClass);
		this.contents = content;
		this.maxLoadWeight = maxLoad;
	}

	/**
		Getter for private member max load weight.
		@return crate's mac load weight as a float.
	*/
	public float getMaxLoad()
	{
		return maxLoadWeight;
	}

	/**
		Getter for private member contents.
		@return crate's content as a String.
	*/
	public String getContents()
	{
		return contents;
	}

	/**
		Displays formatted crate information.
	*/
	public void showPackage()
	{
		System.out.format("|%10s|%8s|%13s|%11s|%14s|%13.2f|%n", this.getTrackingNumber(), this.getType(), this.getSpecification(), this.getMailingClass(), this.contents, this.maxLoadWeight);
	}

	private String contents;
	private float maxLoadWeight;
}
