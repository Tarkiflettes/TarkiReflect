package com.tarkiflettes.main;

import java.awt.Polygon;
import java.awt.geom.Line2D;

public class Line extends Line2D.Double
{
	private static final long serialVersionUID = 1L;

	private int normalAngle;
	
	public Line(double x1, double y1, double x2, double y2)
	{
		super(x1, y1, x2, y2);
	}
	
	public void calculateNormal(Polygon polygon)
	{
        double deltaX = getX2() - getX1();
        double deltaY = getY2() - getY1();

        double angle = Math.atan2(deltaX, deltaY) * 180 / Math.PI; // Calculate the angle from x, y
        
		double radiangle = Math.toRadians(angle + 90);
		double cX = Math.sin(radiangle) * 3;
		double cY = Math.cos(radiangle) * 3;
		
		if(polygon.contains((getX2() + getX1()) / 2D * cX, (getY2() + getY1()) / 2D * cY))
		{
			normalAngle = (int) (angle - 90);
		}
		else
		{
			normalAngle = (int) (angle + 90);
		}
		
		if(normalAngle < 0)
		{
			normalAngle += 360;
		}
	}
	
	public int getNormal()
	{
		return normalAngle;
	}
}
