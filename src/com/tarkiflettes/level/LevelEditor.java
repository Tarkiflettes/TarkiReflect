package com.tarkiflettes.level;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
	private String[] nomsMenu = {"Revenir au menu principal", "Save", "Polygon", "Color changer", "Crystal", "Personnage"};
	private int[] xMenu = {0, 0, 0, 0, 0, 0};
	private int[] yMenu = {30, 30, 30, 30, 30, 30};
	private int[] widthMenu = {0, 0, 0, 0, 0, 0};
	private int[] heightMenu = {15, 15, 15, 15, 15, 15};
	private int marginTB = 30;
	private int marginRL = 30;
	private int selectElement = 0;
	
	
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
		
		int wid = 0;
		Font font = new Font("TimesRoman ",Font.BOLD,15);
	    FontMetrics metrics = g.getFontMetrics(font);
		g.setFont(font);
		
		for (int a = 0;a<nomsMenu.length;a++) {
			g.drawString(nomsMenu[a], marginRL+wid, marginTB);
			widthMenu[a] = metrics.stringWidth(nomsMenu[a]);
			xMenu[a] = marginRL+wid;
			wid += metrics.stringWidth(nomsMenu[a])+marginRL;
		}
		
		
	}
	
	public int whichButton(int x, int y) {
		for(int a = 0;a<nomsMenu.length;a++) {
			if (x>xMenu[a] && y>yMenu[a]-15 && x<xMenu[a]+widthMenu[a] && y<yMenu[a]+heightMenu[a]) {
				return a;
			}
		}
		return -1;
	}

	public void mouseReleased(MouseEvent e) {

	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int index = whichButton(x, y);
		switch(index) {
			case 0:
				Utils.setWindows(-1);
				break;
			case 1:
				System.out.println(nomsMenu[index]);
				break;
			case 2:
				selectElement = 0;
				break;
			case 3:
				selectElement = 1;
				break;
			case 4:
				selectElement = 2;
				break;
			case 5:
				selectElement = 3;
				break;
			default:
				if (selectElement==0) {
					CreateLevel.newLevel.addElement(new Mirror(x/32, y/32, 0));
				} else if (selectElement==1) {
					// CreateLevel.newLevel.addElement(new Mirror(x, y, 0));
				} else if (selectElement==2) {
					// CreateLevel.newLevel.setPlayer(new Point2D.Double(x, y), MoveCapacity.X);
				} else if (selectElement==3) {
					CreateLevel.newLevel.setPlayer(new Point2D.Double(x, y), MoveCapacity.X);
				}
				break;
		}
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
