import java.awt.Graphics;

import javax.swing.ImageIcon;

public class player {
	int x;
	int y;
	int h;
	int w;
	int speed;
	ImageIcon img;
	player(){
		x=70;
		w=h=100;
		y=900-50-h-170;
	     img=new ImageIcon(player.class.getResource("player.gif"));
	     
		
	}
	void move() {
		if( x>1500){
			x=0;
		}
		if (x<0) {
			x=1500;
		}
		x=x+speed;
	}
	void printPlayer(Graphics pen) {
		pen.drawImage(img.getImage(),x,y,w,h,null);
		
	}
	

}
