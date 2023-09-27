import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy {
	
		int x;
		int y;
		int h;
		int w;
		int speed;
		ImageIcon img;
		Enemy(){
			        speed=10;
					y=100;
					x=1600/2;
					w=h=200;
					 
		     img=new ImageIcon(Enemy.class.getResource("Enemy.gif"));
		     
			
		}
		void move() {
			if (y>900) {
				y=0;
			}
			y=y+speed;
		}
		void printPlayer(Graphics pen) {
			pen.drawImage(img.getImage(),x,y,w,h,null);
			
		}	

}
