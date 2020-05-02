package engine;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame implements GameListener{
	private JPanel main;
	
public GameView(GameController c, Game g){
	super();
	main=new JPanel();
	main.setLayout(new GridLayout(5,1));
	this.setBounds(600, 600, 600, 600);
	this.setVisible(true);
	JLabel n=new JLabel(g.getCurrentHero().getName());
	JLabel m=new JLabel(g.getOpponent().getName());
		main.add(n);
		main.add(m);
		this.add(main);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}

}
