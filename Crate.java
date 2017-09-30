package database;

/**
	Child class of Package, specifically for crates.
	@author Bruno Blanco, Dillon Rowan
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

	public Crate(String trackingNumber, String spec, String mClass, float maxLoad, String content)
	{
		super(trackingNumber, spec, mClass);
		this.maxLoadWeight = maxLoad;
		this.contents = content;
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

	private float maxLoadWeight;
	private String contents;
}
