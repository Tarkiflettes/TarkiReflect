package com.tarkiflettes.main;

import java.awt.geom.Point2D;

public class Laser
{	
	private Point2D startCoords;
	private double angle;
	private Laser nextLaser;
	private LaserColor laserColor;
	private double coefX;
	private double coefY;
	private int lenght;
	
	public Laser(LaserColor color, Point2D startsCoords, double angle)
	{
		this.laserColor = color;
		this.startCoords = startsCoords;
		this.angle = angle;
		
		double radiangle = Math.toRadians(getAngle());
		this.coefX = Math.sin(radiangle);
		this.coefY = Math.cos(radiangle);
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	public void setNextLaser(Laser laser)
	{
		nextLaser = laser;
	}
	
	public Laser getNextLaser()
	{
		return nextLaser;
	}

	public Point2D getStartCoords()
	{
		return startCoords;
	}

	public LaserColor getLaserColor()
	{
		return laserColor;
	}

	public double getCoefX()
	{
		return coefX;
	}

	public double getCoefY()
	{
		return coefY;
	}
	
	public void setLenght(int lenght)
	{
		this.lenght = lenght;
	}
	
	public int getLenght()
	{
		return lenght;
	}
}
