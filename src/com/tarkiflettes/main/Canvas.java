package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.tarkiflettes.menu.Menu;
import com.tarkiflettes.menu.Utils;

public class Canvas extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	
	public void paintComponent(Graphics g)
	{
		this.g = g;
		g.setColor(new Color(44, 62, 80));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		new Menu(g, this.getWidth(), this.getHeight());
		
	}
	
}
