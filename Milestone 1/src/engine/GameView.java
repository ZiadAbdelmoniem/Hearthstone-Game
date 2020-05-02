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
	main.setLayout(new GridLayout(6,1));
	this.setBounds(600, 600, 600, 600);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	opponentPanel oppPanel=new opponentPanel(c,g);
	oppHand opponentHand=new oppHand(c,g);
	
	currentPanel currPanel=new currentPanel(c,g);
	main.add(oppPanel);
	main.add(opponentHand);
	
	
	main.add(currPanel);
	
		this.add(main);
		this.revalidate();
		this.repaint();
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}

}
