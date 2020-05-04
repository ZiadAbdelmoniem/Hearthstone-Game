package engine;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame implements GameListener{
	private Mains main;
	
public GameView(GameController c, Game g){
	super();
	Mains main=new Mains(c,g);
	this.setBounds(600, 600, 600, 600);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
		this.add(main);
		this.revalidate();
		this.repaint();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}

}
