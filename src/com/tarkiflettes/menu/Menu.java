package com.tarkiflettes.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Menu {

	private Graphics g;
	private Color colorButton = new Color(41, 128, 185);
	private Color colorButtonMouseOver = new Color(52, 152, 219);
	
	private int width;
	private int height;
	
	private String[] buttonsNames = {"Jouer", "Multijoueur", "Options", "Quitter"};
	private Color[] buttonsColors = {colorButton, colorButton, colorButton,  colorButton};
	private int[] buttonsX = {-1, -1, -1, -1};
	private int[] buttonsY = {150, 350, 550, 750};
	private int[] buttonsWidth = {500, 500, 500, 500};
	private int[] buttonsHeight = {150, 150, 150, 150};
	
	public Menu(Graphics g, int width, int height) {
		this.g = g;
		
		this.height = height;
		this.width = width;
		
		// background
		g.setColor(new Color(44, 62, 80));
		g.fillRect(0, 0, width, height);
		
		//createButton(0, 150, colorButton);
		
		for(int a=0;a<buttonsNames.length;a++) {
			if (buttonsX[a]==-1)
				buttonsX[a] = width/2-buttonsWidth[a]/2;
				//buttonsX[a] = width/2-buttonsWidth[a]*2;
			createButton(
					buttonsX[a],
					buttonsY[a],
					buttonsWidth[a],
					buttonsHeight[a],
					buttonsColors[a]);
		}
		
		
	}
	
	public void createButton(int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	private int whichButton(int x, int y) {
		for(int a = 0;a<buttonsNames.length;a++) {
			if (x>buttonsX[a] && y<buttonsY[a] && x<buttonsX[a]+buttonsWidth[a] && y>buttonsY[a]+buttonsHeight[a]) {
				return a;
			}
		}
		return -1;
	}
	
	class CustomMouseListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			buttonsColors[whichButton(e.getX(), e.getY())] = colorButtonMouseOver;
			//System.out.println("Mouse Clicked: (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}
	
}
