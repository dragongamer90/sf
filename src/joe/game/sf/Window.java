package joe.game.sf;


import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private int width, height;
	private Screen screen;
	private Thread game;
	
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
		
		screen = new Screen(this.width, this.height);
		add(screen, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(width, height);
		
		game = new Thread(screen);
		game.start();
		pack();
		setVisible(true);
	}
}
