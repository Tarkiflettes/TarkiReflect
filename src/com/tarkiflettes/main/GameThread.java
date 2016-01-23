package com.tarkiflettes.main;

public class GameThread extends Thread
{
	private Canvas canvas;
	
	public GameThread(Canvas canvas)
	{
		this.canvas = canvas;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(16);
				canvas.repaint();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
