package com.tarkiflettes.main;

import java.awt.geom.Point2D;

public class Laser
{
	private Point2D startCoords;
	private Point2D endCoords;
	private double angle;
	
	public Laser(Point2D startsCoords, double angle)
	{
		this.startCoords = startsCoords;
		this.endCoords = startsCoords;
		this.angle = angle;
	}
	
	public Point2D getStartsCoords()
	{
		return startCoords;
	}
	
	public Point2D getEndCoords()
	{
		return endCoords;
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	public void setEndCoords(Point2D coords)
	{
		endCoords = coords;
	}
}
