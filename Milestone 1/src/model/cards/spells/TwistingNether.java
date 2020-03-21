package model.cards.spells;
import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class TwistingNether extends Spell implements AOESpell{
	public TwistingNether() {
	
		super("Twisting Nether",8,Rarity.EPIC);
	}
	public Object clone() throws CloneNotSupportedException{
		return new TwistingNether();
	}
	@Override
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField) {
		for(int i=0;i<oppField.size();i++){
			Minion m=oppField.get(i);
			m.setCurrentHP(0);
		}
		for(int j=0;j<curField.size();j++){
			Minion m=curField.get(j);
			m.setCurrentHP(0);
		}
		
	}

}
