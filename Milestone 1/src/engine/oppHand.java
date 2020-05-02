package engine;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class oppHand extends JPanel{
	public oppHand(GameController c,Game g){
		super();
		this.setLayout(new GridLayout(1,7));
		for(int i=0;i<g.getOpponent().getHand().size();i++){
			JLabel n=new JLabel("Card" + Integer.toString(i+1));
			this.add(n);
		}
	}

}
