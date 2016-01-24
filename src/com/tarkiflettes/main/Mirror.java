package com.tarkiflettes.main;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Mirror extends Element implements Serializable
{
	public Mirror(int x, int y, int defaultAngle)
	{
		super(x, y, new Polygon(new int[]{x * 32, x * 32 + 32, x * 32}, new int[]{y * 32, y * 32 + 32, y * 32 + 32}, 3));
		rotate(defaultAngle);
	}

	@Override
	public void handleLaser(Line2D line, Point2D.Double point)
	{
		
	}
}
