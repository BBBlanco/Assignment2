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
		@param pType Package's type.
		@param lDim Box's largest dimension (int).
		@param vol Box's volume (int).
	*/
	public Box(String trackingNumber, String spec, String mClass, String pType, int lDim, int vol)
	{
		super(trackingNumber, spec, mClass, pType);
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

	/**
		Displays formatted box information.
	*/
	public void showPackage()
	{
		System.out.printf("|%10s|%8s|%13s|%11s|%14d|%13d|%n", this.getTrackingNumber(), this.getType(), this.getSpecification(), this.getMailingClass(), this.lDimension, this.volume);
	}

	private int lDimension;
	private int volume;
}
