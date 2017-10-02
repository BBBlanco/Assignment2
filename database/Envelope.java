package database;

/**
	Child class of Package, specifically for envelopes.
	@author Bruno Blanco, Dillon Rowan.
	@version 10/04/2017
 */

public class Envelope extends Package
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
		@param height Envelope's height (int).
		@param width Envelope's width (int).
	*/

	public Envelope(String trackingNumber, String ptype, String spec, String mClass, int h, int w)
	{
		super(trackingNumber, ptype, spec, mClass);

		this.height = h;
		this.width = w;
	}

	/**
		Getter for private member height (h).
		@return package's specification as a String.
	*/
	public int getHeight()
	{
		return height;
	}

	/**
		Getter for private member width (w).
		@return Envelope's width as an integer.
	*/
	public int getWidth()
	{
		return width;
	}

	/**
		Displays formatted envelope information.
	*/
	public void showPackage()
	{
		System.out.format("|%10s|%8s|%13s|%11s|%14d|%13d|%n", this.getTrackingNumber(), this.getType(), this.getSpecification(), this.getMailingClass(), this.height, this.width);
	}

	private int height;
	private int width;
}
