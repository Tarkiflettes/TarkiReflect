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
		for(int a=0;a<Utils.getElemCount();a++) {
			if (Utils.getButtonX(a)==-1)
				Utils.setButtonX(this.getWidth()/2-Utils.getButtonWidth(a)/2, a);
			createButton(
					Utils.getButtonName(a),
					Utils.getButtonX(a),
					Utils.getButtonY(a),
					Utils.getButtonWidth(a),
					Utils.getButtonHeight(a),
					Utils.getButtonColor(a),
					Utils.getButtonColorText(a)
					);
		}
	}
	
	public void createButton(String name, int x, int y, int width, int height, Color color, Color colorText) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(colorText);

		Font font = new Font("TimesRoman ",Font.BOLD,30);
	    FontMetrics metrics = g.getFontMetrics(font);
		g.setFont(font);
		g.drawString(name, x+width/2-metrics.stringWidth(name)/2, y+height/2+30/2);
	}
	
}
