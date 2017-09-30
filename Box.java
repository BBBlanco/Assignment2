package database;

/**
	Child class of Package, specifically for boxes.
	@author Bruno Blanco, Dillon Rowan
	@version 10/04/2017
 */

public class Box extends Package
{
	/**
		@param	trackingNumber Package's tracking number (string).
		@param 	spec Package's specification: Fragile, Books, Catalogs, Do-not-Bend, N/A (string).
	  @param	mClass Package's mailing class: First-Class, Priority, Retail, Ground, Metro (string).
		@param lDimension Box's largest dimension (int).
		@param vol Box's volume (int).
	*/
	public Box(String trackingNumber, String spec, String mClass, int lDim, int vol)
	{
		super(trackingNumber, spec, mClass);
		this.lDimension = lDim;
		this.volume = vol;
	}

	/**
		Getter for private member largest dimension.
		@return box's largest dimension.
	*/
	public int getDimension()
	{
		return lDimension;
	}

	/**
		Getter for private member volume.
		@return box's volume.
	*/
	public int getVolume()
	{
		return volume;
	}

	private int lDimension;
	private int volume;
}
