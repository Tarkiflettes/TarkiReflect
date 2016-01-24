package com.tarkiflettes.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

import com.tarkiflettes.game.Game;

public class Crystal extends Element
{
	private LaserColor color;
	private boolean isActive = false;
	
	public Crystal(int x, int y, int defaultAngle, LaserColor color)
	{
		super(x, y, new Polygon(new int[]{x * 32 + 6, x * 32 + 26, x * 32 + 26, x * 32 + 6}, new int[]{y * 32 + 6, y * 32 + 6, y * 32 + 26, y * 32 + 26}, 4), defaultAngle);
		this.color = color;
	}

	@Override
	public void handleLaser(Laser laser, Line line, Point2D.Double point)
	{
		if(color == laser.getLaserColor())
		{
			isActive = true;
		}
	}
	
	public LaserColor getColor()
	{
		return color;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(LaserColor.getColor(color));
		g.fillPolygon(getPolygon());
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(getRotation()), getX() * 32 + 16, getY() * 32 + 16);
		g.drawImage(Game.hexagon, getX() * 32, getY() * 32, null);
		g2d.rotate(-Math.toRadians(getRotation()), getX() * 32 + 16, getY() * 32 + 16);
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}
}
