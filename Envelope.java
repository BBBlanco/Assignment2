package database;

/**
	Child class of Package, specifically for envelopes.
	@author Bruno Blanco, Dillon Rowan
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

	public Envelope(String trackingNumber, String spec, String mClass, int height, int width)
	{
		super(trackingNumber, spec, mClass);
		this.h = height;
		this.w = width;
	}

	/**
		Getter for private member height (h).
		@return package's specification as a String.
	*/
	public int getHeight()
	{
		return h;
	}

	/**
		Getter for private member width (w).
		@return Envelope's width as an integer.
	*/
	public int getWidth()
	{
		return w;
	}

	private int h;
	private int w;
}
