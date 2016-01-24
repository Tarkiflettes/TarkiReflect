package com.tarkiflettes.main;

import java.awt.geom.Point2D;

public class GameThread extends Thread
{
	private Canvas canvas;
	
	public GameThread(Canvas canvas)
	{
		this.canvas = canvas;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(16);
				if(Main.player == null)
				{
					Main.player = new Player(new Point2D.Double(50, 50), MoveCapacity.Y);
				}
				Main.player.launchLaser();
				canvas.repaint();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
