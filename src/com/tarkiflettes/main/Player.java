package com.tarkiflettes.main;

import java.awt.geom.Point2D;

public class Player
{
	private Point2D coords;
	private int angle;
	
	private final MoveCapacity moveCapacity;
	
	public Player(Point2D coords, MoveCapacity moveCapacity)
	{
		this.coords = coords;
		this.moveCapacity = moveCapacity;
	}
	
	public Point2D getCoords()
	{
		return coords;
	}
	
	public void setCoords(Point2D newCoords)
	{
		coords = newCoords;
	}
	
	public int getAngle()
	{
		return angle;
	}
	
	public void setAngle(int newAngle)
	{
		angle = newAngle;
	}
	
	public MoveCapacity getMoveCapacity()
	{
		return moveCapacity;
	}
}
