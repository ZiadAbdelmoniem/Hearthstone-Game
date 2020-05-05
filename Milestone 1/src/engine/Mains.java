package engine;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Mains extends JPanel {
	private JPanel oppPanel;
	private JPanel opponentHand;
	private JPanel oppfield1;
	private JPanel currfield1;
	private JPanel currhand1;
	private JPanel currPanel;
	
public Mains(GameController c,Game g){
		super();
		this.setLayout(new GridLayout(6,1));
		//this.setBounds(600, 600, 600, 600);
		this.setVisible(true);
		oppPanel=new opponentPanel(c,g);
		opponentHand=new oppHand(c,g);
		//oppfield1=
		//currfield1=
		//currhand1=
		currPanel=new currentPanel(c,g);
		this.add(oppPanel);
		this.add(opponentHand);
		//this.add(oppfield1);
		//this.add(currfield1);
		//this.add(currhand1);
		this.add(currPanel);
		
		
			this.revalidate();
			this.repaint();
	}

}
