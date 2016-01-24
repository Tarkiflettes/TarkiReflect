package com.tarkiflettes.main;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Player
{
	private Point2D coords;
	private double angle;
	
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
		
		Laser currentLaser = playerLaser;
		while(currentLaser != null)
		{
			currentLaser.setLenght(calcLongLaser(currentLaser));
			
			currentLaser = currentLaser.getNextLaser();
		}
		
	}

	public int calcLongLaser(Laser laser)
	{
		int x1 = 0;
		int y1 = 0;
		int res = 0;
		double radiangle = Math.toRadians(laser.getAngle());
		int len = -1;
		int secu = 0;
		while (len == -1 && secu <= 1200)
		{
			for (Element el : Element.ELEMENT_LIST)
			{
				x1 = (int) (laser.getStartCoords().getX() + (Math.sin(radiangle) * secu));
				y1 = (int) (laser.getStartCoords().getY() + (Math.cos(radiangle) * secu));
				res = (int) Math.sqrt(Math.pow(laser.getStartCoords().getX() - x1, 2) + Math.pow(laser.getStartCoords().getY() - y1, 2));
				if (el.getPolygon().contains(x1, y1))
				{
					for(Line2D l : el.getLineList())
					{
						if(l.intersects(new Rectangle(x1 - 1, y1 - 1, x1 + 1, y1 + 1)))
						{
							el.handleLaser(l, new Point2D.Double((int) x1,  (int) y1));
							break;
						}
					}
					return res;
				}
				secu++;

			}
		}

		return 20000;
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
		return (int) angle;
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
