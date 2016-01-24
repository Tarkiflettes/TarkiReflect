package com.tarkiflettes.level;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tarkiflettes.main.Element;

public class Level implements Serializable {

	private int sizeX;
	private int sizeY;
	private List<Element> elements = new ArrayList<>();

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
	
	public int getElementCount() {
		return elements.size();
	}

	
}