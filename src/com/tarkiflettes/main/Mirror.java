package com.tarkiflettes.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class Mirror extends Element
{
	private MirrorType type;
	
	public Mirror(int x, int y, int defaultAngle, MirrorType type)
	{
		super(x, y, new Polygon(new int[]{x * 32, x * 32 + 32, x * 32}, new int[]{y * 32, y * 32 + 32, y * 32 + 32}, 3), defaultAngle);
		rotate(defaultAngle);
		this.type = type;
	}
	
	@Override
	public void rotate(int angle)
	{
		if(type == MirrorType.MIRROR || type == null)
		{
			super.rotate(angle);
		}
	}

	@Override
	public void handleLaser(Laser laser, Line line, Point2D.Double point)
	{
		if(type == MirrorType.WALL)
		{
			return;
		}
		
		double angle = (laser.getAngle() + 2 * (line.getNormal() - laser.getAngle())) % 360;
		double radAngle = Math.toRadians(angle);
				
		laser.setNextLaser(new Laser(laser.getLaserColor(), new Point2D.Double(point.getX() - Math.sin(radAngle) * 3, point.getY() - Math.cos(radAngle) * 3), 180 + angle));
	}

	@Override
	public void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(Math.toRadians(getRotation()), getX() * 32 + 16, getY() * 32 + 16);
		g.drawImage(type == MirrorType.WALL ? Canvas.rect3 : type == MirrorType.FIX ? Canvas.rect2 : Canvas.rect, getX() * 32, getY() * 32, null);
		g2d.rotate(-Math.toRadians(getRotation()), getX() * 32 + 16, getY() * 32 + 16);
	}
	
	public MirrorType getType()
	{
		return getType();
	}
}
