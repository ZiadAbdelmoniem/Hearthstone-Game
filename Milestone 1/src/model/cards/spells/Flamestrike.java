package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class Flamestrike extends Spell implements AOESpell {
	public Flamestrike() {
		super("Flamestrike",7,Rarity.BASIC);
	}
	public Object clone() throws CloneNotSupportedException{
		return new Flamestrike();
	}
	
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField) {
		for(int j=0;j<oppField.size();j++) {
			Minion m = oppField.get(j);
			if(m.isDivine()) {
				m.setDivine(false);
			}
			else{
				m.setCurrentHP((m.getCurrentHP()-4));
			}
			if(m.getCurrentHP()==0)
				oppField.remove(j);
		}
	}
	
}
