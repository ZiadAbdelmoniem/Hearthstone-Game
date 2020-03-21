package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class KillCommand extends Spell implements HeroTargetSpell, MinionTargetSpell {
    public KillCommand(){
        super("Kill Command",3, Rarity.COMMON);
    }

    public Object clone() throws CloneNotSupportedException{
		return new KillCommand();
	}
	public void performAction(Minion m) throws InvalidTargetException {
		m.setCurrentHP((m.getCurrentHP()-5));
	}

	public void performAction(Hero h) {
		h.setCurrentHP((h.getCurrentHP()-3));
	}
}
