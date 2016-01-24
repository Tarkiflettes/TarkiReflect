package com.tarkiflettes.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.tarkiflettes.main.Crystal;
import com.tarkiflettes.main.Element;
import com.tarkiflettes.main.Laser;
import com.tarkiflettes.main.LaserColor;
import com.tarkiflettes.main.Main;
import com.tarkiflettes.main.Mirror;
import com.tarkiflettes.main.MirrorType;
import com.tarkiflettes.main.MoveCapacity;
import com.tarkiflettes.main.Player;

public class Game implements MouseListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	private static Image background;
	private static Image player;
	public static Image rect;
	public static Image rect2;
	public static Image rect3;
	public static Image hexagon;
	private static Graphics g;
	private static int height;
	private static int width;

	public static void init()
	{
		try
		{
			background = ImageIO.read(Game.class.getResource("background.png"));
			player = ImageIO.read(Game.class.getResource("player.png"));
			rect = ImageIO.read(Game.class.getResource("rectangle.png"));
			rect2 = ImageIO.read(Game.class.getResource("rectangle_cheese.png"));
			rect3 = ImageIO.read(Game.class.getResource("rectangle_bacon.png"));
			hexagon = ImageIO.read(Game.class.getResource("hexagon.png"));
			
			System.out.println("ok");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Game(Graphics g, int width, int height)
	{
		this.g = g;
		this.height = height;
		this.width = width;
		g.clearRect(0, 0, width, height);
		g.drawImage(background, 0, 0, width, height, null);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(1.0F));
		g2d.rotate(-Math.toRadians(Main.player.getAngle() + 180), (int) Main.player.getCoords().getX() + 16, (int) Main.player.getCoords().getY() + 16);
		g.drawImage(player, (int) Main.player.getCoords().getX(), (int) Main.player.getCoords().getY(), null);
		g2d.rotate(Math.toRadians(Main.player.getAngle() + 180), (int) Main.player.getCoords().getX() + 16, (int) Main.player.getCoords().getY() + 16);

		System.out.println("OK");
		
		for (Element e : Element.ELEMENT_LIST)
		{
			e.draw(g);
			System.out.println("OK2");
		}

		System.out.println("3");
		Laser laser = Main.player.getPlayerLaser();
		while (laser != null)
		{
			double radiangle = Math.toRadians(laser.getAngle());
			int x2 = (int) (laser.getStartCoords().getX() + (Math.sin(radiangle) * laser.getLenght()));
			int y2 = (int) (laser.getStartCoords().getY() + (Math.cos(radiangle) * laser.getLenght()));

			Color c = LaserColor.getColor(laser.getLaserColor());
			Color c2 = new Color(c.getRed(), c.getGreen(), c.getBlue(), 128);
			Color c3 = new Color(c.getRed(), c.getGreen(), c.getBlue(), 64);
			g2d.setStroke(new BasicStroke(8.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g.setColor(c3);
			g.drawLine((int) laser.getStartCoords().getX(), (int) laser.getStartCoords().getY(), (int) x2, (int) y2);
			g2d.setStroke(new BasicStroke(5.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g.setColor(c2);
			g.drawLine((int) laser.getStartCoords().getX(), (int) laser.getStartCoords().getY(), (int) x2, (int) y2);
			g2d.setStroke(new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g.setColor(Color.WHITE);
			g.drawLine((int) laser.getStartCoords().getX(), (int) laser.getStartCoords().getY(), (int) x2, (int) y2);

			laser = laser.getNextLaser();
		}
		g2d.setStroke(new BasicStroke(1.0F));
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		for (Element el : Element.ELEMENT_LIST)
		{
			if (el.getPolygon().contains(e.getX(), e.getY()))
			{
				if (e.getButton() == MouseEvent.BUTTON1)
				{
					el.rotate(el.getRotation() + 45);
				}
				if (e.getButton() == MouseEvent.BUTTON3)
				{
					el.rotate(el.getRotation() - 45);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{}

	@Override
	public void mouseExited(MouseEvent arg0)
	{}

	@Override
	public void mousePressed(MouseEvent arg0)
	{}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{}

	@Override
	public void keyPressed(KeyEvent ke)
	{
		int keyCode = ke.getKeyCode();
		int agl = Main.player.getAngle();
		switch (keyCode)
		{
			case KeyEvent.VK_UP:
				double y1 = Main.player.getCoords().getY() - 4;
				Main.player.setCoords((double) (Main.player.getCoords().getX()), y1);
				break;
			case KeyEvent.VK_DOWN:
				double y2 = Main.player.getCoords().getY() + 4;
				Main.player.setCoords((double) (Main.player.getCoords().getX()), y2);
				break;
			case KeyEvent.VK_LEFT:
				Main.player.setAngle(agl += 1);
				break;
			case KeyEvent.VK_RIGHT:
				Main.player.setAngle(agl -= 1);
				break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{}

	@Override
	public void keyTyped(KeyEvent arg0)
	{}

	
	
	public static void construLevel1(int tailleX, int tailleY) {
		
		
		
		int debW = ((width/2)-((tailleX/2)*32))/32;
		int debH = ((height/2)-((tailleY/2)*32))/32;
		int alea = (int) Math.round((Math.random()*7));
		int map[][] = new int[tailleX][tailleY];
		//0 = vide ; 1 = bloc ; 2 = mirror ; 3 = crystal ; 4 = player
		
		map[0][0] = 1;
		map[0][1] = 1;
		map[0][2] = 2;
		map[0][3] = 0;
		map[0][4] = 4;
		map[1][0] = 1;
		map[1][1] = 0;
		map[1][2] = 0;
		map[1][3] = 0;
		map[1][4] = 0;
		map[2][0] = 2;
		map[2][1] = 0;
		map[2][2] = 2;
		map[2][3] = 0;
		map[2][4] = 5;
		map[3][0] = 0;
		map[3][1] = 0;
		map[3][2] = 0;
		map[3][3] = 0;
		map[3][4] = 0;
		map[4][0] = 3;
		map[4][1] = 0;
		map[4][2] = 0;
		map[4][3] = 0;
		map[4][4] = 2;
		System.out.println("debW " + debW + " debH " + debH);
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				switch(map[i][j]){
				case 0: // new Vide(debW + 0, debH + 0, alea);
					break;
				case 1: new Mirror(i + 8, j + 8, 0*45, MirrorType.WALL);
					break;
				case 2:  new Mirror(i + 8, j + 8, 0*45, MirrorType.MIRROR);
						//System.out.println("Ok" + (debW + (i*32)));
					break;
				case 3: new Crystal(i + 8, j + 8, alea, LaserColor.GREEN);
					break;
				case 4: Main.player = new Player(new Point2D.Double((i + 8) * 32, (j + 8) * 32), MoveCapacity.NONE);
				break;
				case 5:  new Mirror(i + 8, j + 8, 0*45, MirrorType.FIX);
				//System.out.println("Ok" + (debW + (i*32)));
				break;
				}
				
			}
			
		}
		System.out.println("Ok2");

	}
	
public void construLevel2(int tailleX, int tailleY) {
		
		int debW = (width/2)-((tailleX/2)*32);
		int debH = (height/2)-((tailleY/2)*32);
		int alea = (int) Math.round((Math.random()*7));
		int map[][] = new int[tailleX][tailleY];
		//0 = vide ; 1 = bloc ; 2 = mirror ; 3 = crystal ; 4 = player
		
		map[0][0] = 4;
		map[0][1] = 0;
		map[0][2] = 2;
		map[0][3] = 0;
		map[0][4] = 2;
		map[1][0] = 0;
		map[1][1] = 1;
		map[1][2] = 0;
		map[1][3] = 1;
		map[1][4] = 0;
		map[2][0] = 2;
		map[2][1] = 0;
		map[2][2] = 0;
		map[2][3] = 0;
		map[2][4] = 2;
		map[3][0] = 0;
		map[3][1] = 0;
		map[3][2] = 0;
		map[3][3] = 0;
		map[3][4] = 0;
		map[4][0] = 2;
		map[4][1] = 0;
		map[4][2] = 0;
		map[4][3] = 0;
		map[4][4] = 2;
		map[5][0] = 0;
		map[5][1] = 1;
		map[5][2] = 0;
		map[5][3] = 1;
		map[5][4] = 0;
		map[6][0] = 2;
		map[6][1] = 0;
		map[6][2] = 2;
		map[6][3] = 0;
		map[6][4] = 3;
		
		Element e;
		
		for(int i = 0; i < tailleX; i++){
			for(int j = 0; j < tailleY; j++){
				switch(map[i][j]){
				case 0: // new Vide(debW + 0, debH + 0, alea);
					break;
				case 1: // new Bloc(debW + 0, debH + 0, alea);
					break;
				case 2:  new Mirror(debW + (i), debH + (j), 0*45, MirrorType.MIRROR);
						System.out.println("Ok" + (debW + (i*32)));
					break;
				case 3: // new Crystal(debW + 0, debH + 0, alea);
					break;
				}
				
			}
			
		}
		System.out.println("Ok2");
	}


}
