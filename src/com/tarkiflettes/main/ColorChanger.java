package com.tarkiflettes.main;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class ColorChanger extends Element
{
	private LaserColor color;
	
	public ColorChanger(int x, int y, int defaultAngle, LaserColor color)
	{
		super(x, y, new Polygon(new int[]{x * 32, x * 32 + 32, x * 32 + 32, x * 32}, new int[]{y * 32 + 12, y * 32 + 12, y * 32 + 20, y * 32 + 20}, 4), defaultAngle);
		this.color = color;
	}

	@Override
	public void handleLaser(Laser laser, Line line, Point2D.Double point)
	{
		double angle = (laser.getAngle() + 2 * (line.getNormal() - laser.getAngle())) % 360;
		double radAngle = Math.toRadians(angle);
				
		laser.setNextLaser(new Laser(color, new Point2D.Double(point.getX() - Math.sin(radAngle) * 3, point.getY() - Math.cos(radAngle) * 3), 180 + angle));
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
	}
}
