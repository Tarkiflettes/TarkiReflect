package com.tarkiflettes.main;

import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.sound.sampled.Line;

public abstract class Element
{
	private final ArrayList<Laser> input = new ArrayList<Laser>();
	private final ArrayList<Laser> output = new ArrayList<Laser>();
	
	private final ArrayList<Line> lineList = new ArrayList<Line>();
	private Polygon polygon;
	
	public Element(Polygon polygon)
	{
		this.polygon = polygon;
	}
	
	public void rotate(int angle)
	{
		//TODO
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

	public ArrayList<Line> getLineList()
	{
		return lineList;
	}

	public Polygon getPolygon()
	{
		return polygon;
	}
}
