package engine;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.cards.Card;
import model.cards.minions.*;
import model.cards.spells.*;
import model.cards.*;

public class currentHand extends JPanel{

	public currentHand(GameController c,Game g){
		super();
		this.setLayout(new GridLayout(1,10));
		
		for(int i=0;i<g.getCurrentHero().getHand().size();i++){
			Card d=((Card)(g.getCurrentHero().getHand().get(i)));
			if (d instanceof Spell){
				JButton j=new JButton(((Spell) d).tostring()+ " click to play");
				j.addActionListener(c);
				j.setActionCommand(i+ "card in hand");
				this.add(j);
			}
			else{
				JButton j=new JButton(((Minion) d).tostring()+ " click to play");
				j.addActionListener(c);
				j.setActionCommand(i+ "card in hand");
				this.add(j);
			}
			}
	}
}
