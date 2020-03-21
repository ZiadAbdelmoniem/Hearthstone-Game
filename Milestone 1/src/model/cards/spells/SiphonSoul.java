package model.cards.spells;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class SiphonSoul extends Spell implements LeechingSpell {
    public SiphonSoul(){
        super("Siphon Soul",6, Rarity.RARE);
    }
    public Object clone() throws CloneNotSupportedException{
		return new SiphonSoul();
	}

	
	public int performAction(Minion m) {
		m.setDivine(false);
		m.setCurrentHP(0);
		return 3;
	}
}
