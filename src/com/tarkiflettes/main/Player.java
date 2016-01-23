package com.tarkiflettes.main;

import java.awt.geom.Point2D;

public class Player
{
	private Point2D coords;
	private int angle;
	
	private final MoveCapacity moveCapacity;
	private Laser playerLaser;
	
	public Player(Point2D coords, MoveCapacity moveCapacity)
	{
		this.coords = coords;
		this.moveCapacity = moveCapacity;
	}
	
	public void launchLaser()
	{
		angle++;
		playerLaser = new Laser(LaserColor.GREEN, new Point2D.Double(coords.getX() + 16, coords.getY() + 16), angle);
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
	
	public Laser getPlayerLaser()
	{
		return playerLaser;
	}
}
