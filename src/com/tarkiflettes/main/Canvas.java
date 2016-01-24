package com.tarkiflettes.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import com.tarkiflettes.game.Game;
import com.tarkiflettes.level.LevelEditor;
import com.tarkiflettes.menu.Menu;
import com.tarkiflettes.menu.Utils;
import com.tarkiflettes.multiplayer.Multiplayer;
import com.tarkiflettes.option.Option;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	private static final long serialVersionUID = 1L;
	
	private Graphics g;
	private Menu menu = new Menu();
	private Game game = new Game();
	private Multiplayer multiplayer = new Multiplayer();
	private LevelEditor levelEditor = new LevelEditor();
	private Option option = new Option();
	public static Image rect;
	public static Image rect2;
	public static Image rect3;
	
	public void paintComponent(Graphics g)
	{
		this.g = g;
		g.setColor(new Color(44, 62, 80));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		switch (Utils.getWindows()) {
		case -1:
			menu = new Menu(g, this.getWidth(), this.getHeight());
			break;
		case 0:
			game = new Game(g, this.getWidth(), this.getHeight());
			break;
		case 1:
			multiplayer = new Multiplayer(g, this.getWidth(), this.getHeight());
			break;
		case 2:
			levelEditor = new LevelEditor(g, this.getWidth(), this.getHeight());
			break;
		case 3:
			option = new Option(g, this.getWidth(), this.getHeight());
			break;
		case 4:
			new LevelEditor(g, this.getWidth(), this.getHeight());
			break;
		}
		switch (Utils.getCancelWindow()) {
		case 0:
			
			break;
		case 1:
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseClicked(e);
			break;
		case 0:
			game.mouseClicked(e);
			break;
		case 1:
			multiplayer.mouseClicked(e);
			break;
		case 2:
			levelEditor.mouseClicked(e);
			break;
		case 3:
			option.mouseClicked(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseEntered(e);
			break;
		case 0:
			game.mouseEntered(e);
			break;
		case 1:
			multiplayer.mouseEntered(e);
			break;
		case 2:
			levelEditor.mouseEntered(e);
			break;
		case 3:
			option.mouseEntered(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseExited(e);
			break;
		case 0:
			game.mouseExited(e);
			break;
		case 1:
			multiplayer.mouseExited(e);
			break;
		case 2:
			levelEditor.mouseExited(e);
			break;
		case 3:
			option.mouseExited(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mousePressed(e);
			break;
		case 0:
			game.mousePressed(e);
			break;
		case 1:
			multiplayer.mousePressed(e);
			break;
		case 2:
			levelEditor.mousePressed(e);
			break;
		case 3:
			option.mousePressed(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseReleased(e);
			break;
		case 0:
			game.mouseReleased(e);
			break;
		case 1:
			multiplayer.mouseReleased(e);
			break;
		case 2:
			levelEditor.mouseReleased(e);
			break;
		case 3:
			option.mouseReleased(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}
	
	public void mouseMoved(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseMoved(e);
			break;
		case 0:
			game.mouseMoved(e);
			break;
		case 1:
			multiplayer.mouseMoved(e);
			break;
		case 2:
			levelEditor.mouseMoved(e);
			break;
		case 3:
			option.mouseMoved(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseDragged(e);
			break;
		case 0:
			game.mouseDragged(e);
			break;
		case 1:
			multiplayer.mouseDragged(e);
			break;
		case 2:
			levelEditor.mouseDragged(e);
			break;
		case 3:
			option.mouseDragged(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}

	public void keyTyped(KeyEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.keyTyped(e);
			break;
		case 0:
			game.keyTyped(e);
			break;
		case 1:
			multiplayer.keyTyped(e);
			break;
		case 2:
			levelEditor.keyTyped(e);
			break;
		case 3:
			option.keyTyped(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
	}
	
	public void keyReleased(KeyEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.mouseReleased(e);
			break;
		case 0:
			game.mouseReleased(e);
			break;
		case 1:
			multiplayer.mouseReleased(e);
			break;
		case 2:
			levelEditor.mouseReleased(e);
			break;
		case 3:
			option.mouseReleased(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch (Utils.getWindows()) {
		case -1:
			menu.keyPressed(e);
			break;
		case 0:
			game.keyPressed(e);
			break;
		case 1:
			multiplayer.keyPressed(e);
			break;
		case 2:
			levelEditor.keyPressed(e);
			break;
		case 3:
			option.keyPressed(e);
			break;
		case 4:
			break;
		}
		Main.canvas.repaint();

	}
}
