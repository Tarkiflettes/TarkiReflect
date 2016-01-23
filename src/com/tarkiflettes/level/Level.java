package com.tarkiflettes.level;

import java.util.List;

import com.tarkiflettes.main.Element;

public class Level {

	private int sizeX;
	private int sizeY;
	private List<Element> elements;

	public Level(int sizeX, int sizeY, List<Element> elements) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.elements = elements;
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