package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell{
	public HolyNova() {
		super("Holy Nova",5,Rarity.BASIC);
	}
	public Object clone() throws CloneNotSupportedException{
		return new HolyNova();
	}
	
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField) {
		for(int k=0;k<oppField.size();k++) {
			Minion m = oppField.get(k);
			m.setCurrentHP((m.getCurrentHP()-2));
			if(m.getCurrentHP()==0)
				oppField.remove(k);
		}
		for(int j=0;j<curField.size();j++) {
			Minion m = oppField.get(j);
			m.setCurrentHP((m.getCurrentHP()+2));
		}
	}
}
