package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.tarkiflettes.menu.Menu;
import com.tarkiflettes.menu.Utils;

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

		final Canvas canvas = new Canvas();
		frame.setContentPane(canvas);
		frame.setVisible(true);
		
		frame.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				for (int a=0;a<Utils.getElemCount();a++)
						Utils.setButtonColor(Utils.getColorButton(), a);
				canvas.repaint();
			}
			
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				int index = Utils.whichButton(x, y);
				
				if (index!=-1) {
					switch (index) {
					case 0:
						System.out.println("koukou");
						break;
					case 1:
						System.out.println("koukou");
						break;
					case 2:
						System.out.println("koukou");
						break;
					case 3:
						System.exit(0);
						break;
					}
					Utils.setButtonColor(Utils.getColorButtonMouseOver(), index);
				}
				canvas.repaint();
				
			}
			
			public void mouseExited(MouseEvent e) {
				
			}
			
			public void mouseEntered(MouseEvent e) {
				
			}
			
			public void mouseClicked(MouseEvent e) {
				
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
