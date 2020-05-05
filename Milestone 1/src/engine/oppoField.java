package engine;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.cards.minions.Minion;

public class oppoField extends JPanel{

	
	public oppoField(GameController c,Game g){
		super();
		this.setLayout(new GridLayout(1,7));
		for(int i=0;i<g.getOpponent().getField().size();i++){
			Minion m=g.getOpponent().getField().get(i);
			JButton b=new JButton(m.tostring());
			b.addActionListener(c);
			b.setActionCommand("wants to attack the minion number "+i);
			this.add(b);
		}
	}
}