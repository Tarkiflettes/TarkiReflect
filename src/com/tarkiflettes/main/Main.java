package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import com.tarkiflettes.level.Level;
import com.tarkiflettes.level.LevelEditor;
import com.tarkiflettes.level.LevelStorage;
import com.tarkiflettes.menu.Menu;
import com.tarkiflettes.menu.Utils;

public class Main
{
	
	private static JFrame frame;
	private static Menu menu;
	public static Canvas canvas; 
	public static Player player;
	
	public static void main(String[] args)
	{
		System.out.println("Starting laser game...");

		frame = new JFrame("Laser Game");
		frame.setSize(1000, 800);

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice dev = env.getDefaultScreenDevice();
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setBackground(Color.BLACK);
		dev.setFullScreenWindow(frame);
		dev.setDisplayMode(getResolutionForSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//final Canvas canvas = new Canvas();
		canvas = new Canvas();
		frame.setContentPane(canvas);
		frame.setVisible(true);
		
		canvas.repaint();
		/*player = new Player(new Point2D.Double(50, 50), MoveCapacity.Y);
		
		Element e = new Mirror(4, 4, 90);
		new Mirror(8, 4, 90);
		new Mirror(20, 4, 90);
		new Mirror(4, 8, 90);*/
		
		//GameThread gameThread = new GameThread(canvas);
		//gameThread.start();
		
		Level koukou = new Level(1, 1);
		//koukou.addElement(new Mirror(10, 20, 90));
		LevelStorage lapin = new LevelStorage();
		lapin.addLevel(koukou);
		
		frame.addMouseListener(canvas);
		frame.addMouseMotionListener(canvas);
		frame.addKeyListener(canvas);
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				e.getKeyCode();
			}
		});
		
	}

	public static DisplayMode getResolutionForSize(int width, int height)
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice dev = env.getDefaultScreenDevice();
		for (DisplayMode mode : dev.getDisplayModes())
		{
			if ((mode.getWidth() == width) && (mode.getHeight() == height))
			{
				return mode;
			}
		}
		return dev.getDisplayMode();
	}

}
