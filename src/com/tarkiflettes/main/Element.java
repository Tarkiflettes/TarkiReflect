package com.tarkiflettes.main;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.sound.sampled.Line;

public abstract class Element
{
	public static final ArrayList<Element> ELEMENT_LIST = new ArrayList<Element>();

	private final ArrayList<Laser> input = new ArrayList<Laser>();
	private final ArrayList<Laser> output = new ArrayList<Laser>();

	private final ArrayList<Line2D> lineList = new ArrayList<Line2D>();
	private Polygon polygon;
	private Polygon defPolygon;

	private int x;
	private int y;

	public Element(int x, int y, Polygon polygon)
	{
		this.x = x;
		this.y = y;
		this.defPolygon = polygon;
		this.polygon = polygon;
		createLineList();
		ELEMENT_LIST.add(this);
	}

	public void rotate(int angle)
	{
		angle = angle % 360;
		Polygon nPolygon = new Polygon();
		
		float nAngle = (float) Math.toRadians(angle);
		float cosAngle = (float) Math.cos(nAngle);
		float sinAngle = (float) Math.sin(nAngle);
		
		for (int i = 0; i < defPolygon.npoints; i++)
		{
			float centerX = x * 32 + 15.5F;
			float centerY = y * 32 + 15.5F;
			
			float oldX = (defPolygon.xpoints[i] - centerX);
			float oldY = (defPolygon.ypoints[i] - centerY);

			float nX = centerX + (float) (oldX * cosAngle - oldY * sinAngle);
			float nY = centerY + (float) (oldX * sinAngle + oldY * cosAngle);
			
			nPolygon.addPoint((int) nX, (int) nY);
		}
		
		polygon = nPolygon;
		createLineList();
	}

	public abstract void handleLaser(Line line, Point2D point);

	public ArrayList<Laser> getInput()
	{
		return input;
	}

	public ArrayList<Laser> getOutput()
	{
		return output;
	}

	public ArrayList<Line2D> getLineList()
	{
		return lineList;
	}

	public Polygon getPolygon()
	{
		return polygon;
	}

	private void createLineList()
	{
		lineList.clear();

		for (int i = 0; i < polygon.npoints; i++)
		{
			if (i == polygon.npoints - 1)
			{
				lineList.add(new Line2D.Float(polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[0], polygon.ypoints[0]));
			}
			else
			{
				lineList.add(new Line2D.Float(polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[i + 1], polygon.ypoints[i + 1]));
			}
		}
	}
}
