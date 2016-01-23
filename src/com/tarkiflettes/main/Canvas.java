package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.tarkiflettes.menu.Menu;

public class Canvas extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Graphics g;
	private static Color colorButton = new Color(41, 128, 185);
	private static Color colorButtonMouseOver = new Color(46, 204, 113);
	
	private int width;
	private int height;
	
	private static String[] buttonsNames = {"Jouer", "Multijoueur", "Options", "Quitter"};
	private static Color[] buttonsColors = {colorButton, colorButton, colorButton,  colorButton};
	private static int[] buttonsX = {-1, -1, -1, -1};
	private static int[] buttonsY = {150, 350, 550, 750};
	private static int[] buttonsWidth = {500, 500, 500, 500};
	private static int[] buttonsHeight = {150, 150, 150, 150};
	
	public void paintComponent(Graphics g)
	{
		//new Menu(g, getWidth(), getHeight());

		this.g = g;
		
		this.height = getHeight();
		this.width = getWidth();
		
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
			buttonsColors[1] = colorButtonMouseOver;
			System.out.println("Mouse Clicked: (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mousePressed(MouseEvent e) {
			System.out.println("Mouse Clicked: (" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}
	
}
