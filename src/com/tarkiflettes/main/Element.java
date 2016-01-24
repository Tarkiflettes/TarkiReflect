package com.tarkiflettes.main;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class Element
{
	public static final ArrayList<Element> ELEMENT_LIST = new ArrayList<Element>();

	private final ArrayList<Laser> input = new ArrayList<Laser>();
	private final ArrayList<Laser> output = new ArrayList<Laser>();

	private final ArrayList<Line> lineList = new ArrayList<Line>();
	private Polygon polygon;
	private Polygon defPolygon;

	private int x;
	private int y;
	private int rotation;

	public Element(int x, int y, Polygon polygon, int rotation)
	{
		this.x = x;
		this.y = y;
		this.defPolygon = polygon;
		this.polygon = polygon;
		this.rotation = rotation;
		rotate(rotation);
		ELEMENT_LIST.add(this);
	}

	public void rotate(int angle)
	{
		angle = angle % 360;
		rotation = angle;
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

	public abstract void handleLaser(Laser laser, Line line, Point2D.Double point);

	public ArrayList<Laser> getInput()
	{
		return input;
	}

	public ArrayList<Laser> getOutput()
	{
		return output;
	}

	public ArrayList<Line> getLineList()
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
				Line line = new Line(polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[0], polygon.ypoints[0]);
				line.calculateNormal(polygon);
				lineList.add(line);
			}
			else
			{
				Line line = new Line(polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[i + 1], polygon.ypoints[i + 1]);
				line.calculateNormal(polygon);
				lineList.add(line);
			}
		}
	}

	public int getRotation()
	{
		return rotation;
	}
	
	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public abstract void draw(Graphics g);
}
