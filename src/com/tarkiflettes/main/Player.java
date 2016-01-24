package com.tarkiflettes.main;

import java.awt.geom.Point2D;

import com.tarkiflettes.game.Game;
import com.tarkiflettes.menu.Utils;

public class Player
{
	private Point2D coords;
	private double angle;

	private final MoveCapacity moveCapacity;
	private Laser playerLaser;

	double j = 0;

	public Player(Point2D coords, MoveCapacity moveCapacity)
	{
		this.coords = coords;
		this.moveCapacity = moveCapacity;
	}

	public void launchLaser()
	{
		for(Element e : Element.ELEMENT_LIST)
		{
			if(e instanceof Crystal)
			{
				((Crystal) e).setActive(false);
			}
		}
		
		double radAngle = Math.toRadians(angle);
		playerLaser = new Laser(LaserColor.GREEN, new Point2D.Double(coords.getX() + 16 + Math.sin(radAngle) * 18, coords.getY() + 16 + Math.cos(radAngle) * 18), angle);

		int i = 0;
		Laser currentLaser = playerLaser;

		while (currentLaser != null && i < 20)
		{
			currentLaser.setLenght(calcLongLaser(currentLaser));

			currentLaser = currentLaser.getNextLaser();
			i++;
		}

		boolean won = true;
		for(Element e : Element.ELEMENT_LIST)
		{
			if(e instanceof Crystal && !((Crystal) e).isActive())
			{
				won = false;
				break;
			}
		}
		
		if(won)
		{
			Element.ELEMENT_LIST.clear();
			Main.player = null;
			Utils.setWindows(-1);
		}
	}

	public int calcLongLaser(Laser laser)
	{
		double x1 = laser.getStartCoords().getX();
		double y1 = laser.getStartCoords().getY();
		int res = 0;
		int len = -1;
		int secu = 0;
		while (len == -1 && secu <= 2400)
		{
			for (Element el : Element.ELEMENT_LIST)
			{
				x1 += (laser.getCoefX() * 0.5D);
				y1 += (laser.getCoefY() * 0.5D);

				if (el.getPolygon().contains(x1, y1))
				{
					res = (int) Math.sqrt(Math.pow(laser.getStartCoords().getX() - x1, 2) + Math.pow(laser.getStartCoords().getY() - y1, 2));
					
					for (Line l : el.getLineList())
					{
						if (l.intersects(x1 - 3, y1 - 3, 3, 3))
						{
							System.out.println("OK");
							Point2D.Double p = intersect(laser.getStartCoords().getX(), laser.getStartCoords().getY(), x1, y1, l.x1, l.y1, l.x2, l.y2);
							el.handleLaser(laser, l, p);
							res = (int) Math.sqrt(Math.pow(laser.getStartCoords().getX() - p.getX(), 2) + Math.pow(laser.getStartCoords().getY() - p.getY(), 2));
							break;
						}
					}
					if(!(el instanceof Crystal))
					{
						return res;
					}
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

	public void setCoords(double d, double e)
	{
		coords = new Point2D.Double(d, e);
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

	public Point2D.Double intersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
	{
		double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
		if (d == 0)
			return null;

		double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
		double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

		return new Point2D.Double(xi, yi);
	}
}
