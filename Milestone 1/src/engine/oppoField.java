package engine;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.cards.minions.Minion;

public class oppoField extends JPanel{

	
	public oppoField(GameController c,Game g){
		super();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		this.setBorder(blackline);
		this.setLayout(new GridLayout(1,7));
		for(int i=0;i<g.getOpponent().getField().size();i++){
			Minion m=g.getOpponent().getField().get(i);
			JButton b=new JButton(m.tostring());
			b.addActionListener(c);
			b.setActionCommand("wants to attack the minion number "+i);
			b.setBorder(blackline);
			this.add(b);
		}
	}
}