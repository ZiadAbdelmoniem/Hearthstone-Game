package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class MultiShot extends Spell implements AOESpell{
	public MultiShot() {
		super("Multi-Shot",4,Rarity.BASIC);
	}
	public Object clone() throws CloneNotSupportedException{
		return new MultiShot();
	}
	
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField) {
		int s =0;
		boolean []array=new boolean[oppField.size()];
		if(oppField.size()==1) {
			if(oppField.get(0).isDivine()) {
				oppField.get(0).setDivine(false);
			}
			else {
				oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP()-3);
			}
			return;
		}
		if(oppField.isEmpty())
			return;
		
		while(s<3) {
		int ra = (int) Math.random()*oppField.size();
		if(array[ra]==false) {
		array[ra]=true;
		Minion m = oppField.get(ra);
		if(m.isDivine()) {
			m.setDivine(false);
		}
		else{m.setCurrentHP(m.getCurrentHP()-3);
		
		}
		s++;
		}
		}
	}
}
