package com.tarkiflettes.level;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tarkiflettes.main.Element;
import com.tarkiflettes.main.MoveCapacity;
import com.tarkiflettes.main.Player;

public class Level implements Serializable {

	public List<Element> getElements() {
		return elements;
	}

	private int sizeX;
	private int sizeY;
	private ArrayList<Element> elements = new ArrayList<>();
	private Player player;
	
	public Level(int sizeX, int sizeY, List<Element> elements) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.elements.addAll(elements);
	}
	
	public Level(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		elements = new ArrayList<>();
	}
	
	public Element getElement(int index) {
		if (index<getElementCount()) 
			return elements.get(index);
		else
			return elements.get(0);
	}
	
	public void addElement(Element element) {
		elements.add(element);
	}
	public void modifyElement(int index, Element element) {
		elements.set(index, element);
	}
	public void removeElement(int index) {
		if (index<getElementCount()) 
			elements.remove(index);
	}
	
	public void setPlayer(Point2D coords, MoveCapacity moveCapacity) {
		player = new Player(coords, moveCapacity);
	}
	
	public int getElementCount() {
		return elements.size();
	}
	
	public void chargeLevel(Level level){
		Element.ELEMENT_LIST.clear();
		Element.ELEMENT_LIST.addAll(getElements());
		
	}

	
}