package database;

/**
	Child class of Package, specifically for drums.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Drum extends Package
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
		@param mat Drum's material (Plastic/Fiber) (string).
		@param diam Drum's diameter (int).
	*/

	public Drum(String trackingNumber, String spec, String mClass, String mat, int diam)
	{
		super(trackingNumber, spec, mClass);
		this.material = mat;
		this.diameter = diam;
	}

	/**
		Getter for private member material.
		@return drum's material as a String.
	*/
	public String getMaterial()
	{
		return material;
	}

	/**
		Getter for private member diameter.
		@return drum's diameter as an integer.
	*/
	public int getDiameter()
	{
		return diameter;
	}

	private String material;
	private int diameter;
}
