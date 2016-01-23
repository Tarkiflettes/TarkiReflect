package com.tarkiflettes.main;

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
