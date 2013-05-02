package joe.game.sf;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import joe.game.sf.mech.Game;


public class Screen extends JPanel implements Runnable {
	private int width, height;
	private Game game;
	private boolean isRunning;
	private int fps;

	public Screen(int width, int height) {
		this.fps = 50;
		this.isRunning = true;
		this.width = width;
		this.height = height;
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		game = new Game(width, height);
		addMouseMotionListener(new MouseHandler());
		addKeyListener(new KeyHandler());
		this.setFocusable(true);
	}
	
	@Override
	public void run() {
		while(isRunning){
			game.update();
			repaint();
			try {
				Thread.sleep((1000/fps));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paint(Graphics g){
		game.render(g);
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	private class MouseHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			game.setMouseX(e.getX());
			game.setMouseY(e.getY());
		}
		
	}
	
	private class KeyHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyChar()) {
			case 'w': {game.setUp(true);}break;
			case 'a': {game.setLeft(true);}break;
			case 's': {game.setDown(true);}break;
			case 'd': {game.setRight(true);}break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyChar()) {
			case 'w': {game.setUp(false);}break;
			case 'a': {game.setLeft(false);}break;
			case 's': {game.setDown(false);}break;
			case 'd': {game.setRight(false);}break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == 'f') {
				game.boom();
			}
		}
	}
}
