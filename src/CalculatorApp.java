package CalculatorApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CalculatorApp extends JFrame implements Runnable {
private Gui gui;
private boolean cleanCanvas=true;
private int fps;



	public CalculatorApp(int fps) {
		this.fps=fps;
		this.setSize(800,770);
		gui =new Gui(this);
		//gui=new Gui();
		
		this.addMouseListener(gui);
		

	
	}
	public CalculatorApp() {
		this(60);
	}
	
	public void start() {
		this.setTitle("Calculator App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setResizable(true);

		this.setVisible(true);
	this.startThread();
		 // calls run method after paint
	}
	
	
	
	private synchronized void startThread() {
		Thread t1 = new Thread(this);
		t1.start(); // calls run method after paint
		this.setFocusable(true);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
CalculatorApp i=new CalculatorApp();
i.start();
	}
	
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime(); // long 2^63
		double nanoSecondConversion = 1000000000.0 / this.fps; // 60 frames per second
		double changeInSeconds = 0;

		while (true) {
			long now = System.nanoTime();

			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while (changeInSeconds >= 1) {
				update();
				changeInSeconds--;
			}

			render();
			lastTime = now;
		}
		
	}
	
	
	
	private void render() {
		BufferStrategy buffs = this.getBufferStrategy();
		if (buffs == null) {
			this.createBufferStrategy(3);
			buffs = this.getBufferStrategy();
		}

		Graphics g = buffs.getDrawGraphics();

		if (this.cleanCanvas) {
			g.setColor(this.getBackground());
			g.fillRect(0, 0, this.getWidth(), 150);
		}

		draw((Graphics2D) g);

		g.dispose();

		buffs.show();
	}
	
	
	
 private void update() {
	 this.gui.update();
 }
 
 
	public void draw (Graphics2D win) {
		
		this.gui.draw(win);
	}
}
