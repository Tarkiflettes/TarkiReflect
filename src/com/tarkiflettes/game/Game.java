package com.tarkiflettes.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import com.tarkiflettes.main.Element;
import com.tarkiflettes.main.Laser;
import com.tarkiflettes.main.LaserColor;
import com.tarkiflettes.main.Main;

public class Game {

	private Graphics g;
	private int height;
	private int width;
	private int i = 0;
	
	public Game() {
		
	}
	
	public Game(Graphics g, int width, int height) {
		
		this.g = g;
		this.height = height;
		this.width = width;
		
		//LaunchGame();
		
	}
	
	public void LaunchGame() {
		g.clearRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.fillRect((int) Main.player.getCoords().getX(), (int) Main.player.getCoords().getY(), 16, 16);

		for (Element e : Element.ELEMENT_LIST) {
			// e.rotate(i++);
			g.fillPolygon(e.getPolygon());
		}

		Laser laser = Main.player.getPlayerLaser();
		while (laser != null) {
			double radiangle = Math.toRadians(laser.getAngle());
			int x2 = (int) (laser.getStartCoords().getX() + (Math.sin(radiangle) * 80F));
			int y2 = (int) (laser.getStartCoords().getY() + (Math.cos(radiangle) * 80F));

			g.setColor(LaserColor.getColor(laser.getLaserColor()));
			g.drawLine((int) laser.getStartCoords().getX(), (int) laser.getStartCoords().getY(), (int) x2, (int) y2);
			laser = laser.getNextLaser();
		}

		Laser las = new Laser(LaserColor.BLUE, new Point2D.Double(10 * 32, 4 * 32), 275);

		int len = calcLongLaser(las);

		drawLaser(las, g, len);
	}
	
	public void drawLaser(Laser laser, Graphics g, int len) {
		double radiangle = Math.toRadians(laser.getAngle());
		int x = (int) (laser.getStartCoords().getX() + (Math.sin(radiangle) * len));
		int y = (int) (laser.getStartCoords().getY() + (Math.cos(radiangle) * len));
		g.setColor(LaserColor.getColor(laser.getLaserColor()));
		g.drawLine((int) laser.getStartCoords().getX(), (int) laser.getStartCoords().getY(), (int) x, (int) y);
	}

	public int calcLongLaser(Laser laser) {
		int x1 = 0;
		int y1 = 0;
		int res = 0;
		double radiangle = Math.toRadians(laser.getAngle());
		int len = -1;
		int secu = 0;
		while (len == -1 && secu <= 800) {
			for (Element el : Element.ELEMENT_LIST) {
				x1 = (int) (laser.getStartCoords().getX() + (Math.sin(radiangle) * i));
				y1 = (int) (laser.getStartCoords().getY() + (Math.cos(radiangle) * i));
				res = (int) Math.sqrt(Math.pow(laser.getStartCoords().getX() - x1, 2)
						+ Math.pow(laser.getStartCoords().getY() - y1, 2));
				if (el.getPolygon().contains(x1, y1)) {
					return res;
				}
				i++;
				secu++;

			}
		}

		return 1;
	}

	
	
	
	
	public void mouseClicked(MouseEvent e) {
		for (Element el : Element.ELEMENT_LIST) {
			if (el.getPolygon().contains(e.getX(), e.getY())) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					el.rotate(i += 45);
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					el.rotate(i -= 45);
				}
			}
		}

	}	
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
