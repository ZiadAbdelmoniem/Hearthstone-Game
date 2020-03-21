package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class Pyroblast extends Spell implements HeroTargetSpell, MinionTargetSpell {
    public Pyroblast(){
        super("Pyroblast",10, Rarity.EPIC);
    }

    public Object clone() throws CloneNotSupportedException{
		return new Pyroblast();
	}
	public void performAction(Minion m) throws InvalidTargetException {
		//I want to check if the target is going to die
		m.setCurrentHP(m.getCurrentHP()-10);
	}


	public void performAction(Hero h) {
		h.setCurrentHP(h.getCurrentHP()-10);
		
	}
}
