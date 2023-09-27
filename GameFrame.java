import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		GameFrame obj=new GameFrame();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(1600,850);
		obj.setResizable(false);
		obj.setTitle("My game-2023");
	    Board bord=new Board();
	    obj.add(bord);
		obj.setVisible(true);
		
		
		

	}

}
