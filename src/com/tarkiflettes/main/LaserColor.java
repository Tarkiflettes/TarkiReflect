package com.tarkiflettes.main;

import java.awt.Color;

public enum LaserColor
{
	RED(255, 0, 0), BLUE(0, 0, 255), PURPLE(128, 0, 128), GREEN(0, 255, 0), YELLOW(128, 0, 128), ORANGE(255, 128, 0);

	private final int red;
	private final int green;
	private final int blue;

	private LaserColor(int red, int green, int blue)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public static LaserColor combineLaserColor(LaserColor c1, LaserColor c2)
	{
		if (c1 == RED && c2 == BLUE || c2 == RED && c1 == BLUE)
			return PURPLE;
		else if (c1 == RED && c2 == YELLOW || c2 == RED && c1 == YELLOW)
			return ORANGE;
		else if (c1 == BLUE && c2 == YELLOW || c2 == BLUE && c1 == YELLOW)
			return GREEN;

		return null;
	}

	public static Color getColor(LaserColor a)
	{
		Color res = new Color(a.getRed(), a.getGreen(), a.getBlue());
		return res;
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