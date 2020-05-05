package engine;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.cards.minions.Minion;

public class currentField extends JPanel{
	
	public currentField(GameController c,Game g){
		super();
		this.setLayout(new GridLayout(1,7));
		for(int i=0;i<g.getCurrentHero().getField().size();i++){
			Minion m=g.getCurrentHero().getField().get(i);
			JButton j=new JButton(m.tostring());
			j.setActionCommand("Minion on field to attack number"+i);
			j.addActionListener(c);
			this.add(j);
		}
	}

}
