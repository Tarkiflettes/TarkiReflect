package com.tarkiflettes.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tarkiflettes.game.Game;
import com.tarkiflettes.main.Main;
import com.tarkiflettes.main.MoveCapacity;
import com.tarkiflettes.main.Player;

public class Menu {

	private Graphics g;
	private int height;
	private int width;
	
	public Menu() {
		
	}
	
	public Menu(Graphics g, int width, int height) {
		this.g = g;
		this.height = height;
		this.width = width;
		g.setColor(Color.WHITE);
		
		for(int a=0;a<Utils.getElemCount();a++) {
			if (Utils.getButtonX(a)==-1)
				Utils.setButtonX(width/2-Utils.getButtonWidth(a)/2, a);
			createButton(
					Utils.getButtonName(a),
					Utils.getButtonX(a),
					Utils.getButtonY(a),
					Utils.getButtonWidth(a),
					Utils.getButtonHeight(a),
					Utils.getButtonColor(a),
					Utils.getButtonColorText(a),
					Utils.getImgCurrent(a)
					);
		}

        try {
			final BufferedImage image = ImageIO.read(new File("src/com/tarkiflettes/menu/logo.png"));
            g.drawImage(image, width/2-Utils.getButtonWidth(0)/2, 10, 200, 100, null);
    		Font font = new Font("TimesRoman ",Font.BOLD,60);
    		g.setFont(font);
    		g.drawString("TarkiReflect", width/2-Utils.getButtonWidth(0)/2+200, 75);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createButton(String name, int x, int y, int width, int height, Color color, Color colorText, String imgCurrent) {
		//g.setColor(color);
		//g.fillRect(x, y, width, height);
		//g.setColor(colorText);


        try {
			final BufferedImage image = ImageIO.read(new File(imgCurrent));
            g.drawImage(image, x, y, width, height, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Font font = new Font("TimesRoman ",Font.BOLD,30);
	    FontMetrics metrics = g.getFontMetrics(font);
		g.setFont(font);
		g.drawString(name, x+width/2-metrics.stringWidth(name)/2, y+height/2+30/2);
	}
	
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int index = Utils.whichButton(x, y);
		if (index!=-1) {
			switch (index) {
			case 0:
				Utils.setWindows(index);
				break;
			case 1:
				Utils.setWindows(index);
				new Game(g, width, height);
				break;
			case 2:
				Utils.setWindows(index);
				break;
			case 3:
				Utils.setWindows(index);
				break;
			case 4:
				System.exit(0);
				break;
			}
			Utils.setButtonColor(Utils.getColorButtonMouseOver(), index);
			Utils.setImg(Utils.getImgOver(index), index);
		}
		
	}

	public static void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for (int a=0;a<Utils.getElemCount();a++) {
			Utils.setButtonColor(Utils.getColorButton(), a);
			Utils.setImg(Utils.getImg(a), a);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int index = Utils.whichButton(x, y);

		if (index!=-1) {
			Utils.setImgCurrent(Utils.getImgOver(index), index);
		} else {
			for (int a=0;a<Utils.getElemCount();a++) {
				Utils.setButtonColor(Utils.getColorButton(), a);
				Utils.setImgCurrent(Utils.getImg(a), a);
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
		
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
