package com.tarkiflettes.main;

public enum LaserColor
{
	RED(255, 0, 0),
	BLUE(0, 0, 255),
	PURPLE(128, 0, 128);
	
	private final int red;
	private final int green;
	private final int blue;
	
	private LaserColor(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public LaserColor combineLaserColor(LaserColor c1, LaserColor c2)
	{
		if(c1 == RED && c2 == BLUE)
		{
			return PURPLE;
		}
		
		return null;
	}

	public int getRed()
	{
		return red;
	}

	public int getGreen()
	{
		return green;
	}

	public int getBlue()
	{
		return blue;
	}
}
