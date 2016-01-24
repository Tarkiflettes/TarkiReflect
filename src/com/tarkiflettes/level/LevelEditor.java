package com.tarkiflettes.level;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.RepaintManager;

import com.tarkiflettes.main.Element;
import com.tarkiflettes.main.Main;
import com.tarkiflettes.main.Mirror;
import com.tarkiflettes.main.MoveCapacity;
import com.tarkiflettes.main.Player;
import com.tarkiflettes.menu.Menu;
import com.tarkiflettes.menu.Utils;

public class LevelEditor {
	
	private Graphics g;
	private int height;
	private int width;
	
	public LevelEditor() {
		
	}
	
	public LevelEditor(Graphics g, int width, int height) {
		this.g = g;
		this.height = height;
		this.width = width;

		g.setColor(new Color(236, 240, 241));
		
		for (Element e : Element.ELEMENT_LIST) {
			g.fillPolygon(e.getPolygon());
		}
		
	}

	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		new Mirror(1, 1, 90);
		new Player(new Point2D.Double(1, 1), MoveCapacity.Y);
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void mouseReleased(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
	}
	
}
