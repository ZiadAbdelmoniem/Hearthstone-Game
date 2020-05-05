package engine;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame implements GameListener{
	private Mains main;
	//private GameController f;
	//private Game h;
	
public GameView(GameController c, Game g){
	super();
	//f=c;
	//h=g;
	main=new Mains(c,g);
	this.setBounds(600, 600, 600, 600);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(main);
		this.revalidate();
		this.repaint();
	}	
	
	
public void refresh(GameController f,Game h){
	Mains n=new Mains(f,h);
	this.remove(main);
	main=n;
	this.add(main);
	this.revalidate();
	this.repaint();
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}

}
