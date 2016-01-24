package com.tarkiflettes.menu;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import com.tarkiflettes.main.Mirror;
import com.tarkiflettes.main.MoveCapacity;
import com.tarkiflettes.main.Player;

public class CancelMenu {

	private Graphics g;
	private int height;
	private int width;
	
	public CancelMenu() {
		
	}
	
	public CancelMenu(Graphics g, int width, int height) {
		this.g = g;
		this.height = height;
		this.width = width;
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
	
}
