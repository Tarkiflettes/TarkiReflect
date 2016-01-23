package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.tarkiflettes.menu.Menu;

public class Main
{
	
	private static JFrame frame;
	private static Menu menu;
	
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

		Canvas canvas = new Canvas();
		frame.setContentPane(canvas);
		frame.setVisible(true);
		
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
