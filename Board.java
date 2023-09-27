import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel{
	BufferedImage backgroundImage;
	Timer timer;
	player player;
	Enemy enemy;
	boolean isGameOver;
	boolean iscollide() {
		int xDistance=Math.abs(player.x-enemy.x+35);
		int yDistance=Math.abs(player.y-enemy.y+35);
		int maxW=Math.max(player.w,enemy.w);
		int maxH=Math.max(player.h,enemy.h);
		return xDistance<=maxW-60 && yDistance<=maxH-60;
		
	}
	void attachListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.speed=0;
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method 
				if (e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.speed=-10;
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					player.speed=10;
				}
				
				
				
			}
		});
	}
	
	void gameLoop() {
		timer=new Timer(50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				player.move();
				enemy.move();
				isGameOver=iscollide();
				
			}
		});
		timer.start();
	}
	public Board()
	{
		try {
		backgroundImage=ImageIO.read(Board.class.getResource("bgimg.jpg"));
		player=new player();
		enemy=new Enemy();
		gameLoop();
		setFocusable(true);
		attachListener();
		}
		catch(Exception e)
		{
			System.out.println("No Background Image Exist");
			System.exit(0);
		}
	}
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		pen.drawImage(backgroundImage, 0, 0, 1550, 788,null);
		player.printPlayer(pen);
		enemy.printPlayer(pen);
		
		if (isGameOver) {
			pen.setColor(Color.RED);
			pen.setFont(new Font("times",Font.BOLD,40));
			pen.drawString("Game Over", 1500/2, 900/2);
			timer.stop();
		}
		
		
		
	}
	
	

}
