package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class CurseOfWeakness extends Spell implements AOESpell {
	
	public CurseOfWeakness() {
		
		super("Curse of Weakness",2,Rarity.RARE);
		
	}
	
	
	public static void main (String [] args)   {
		CurseOfWeakness s = new CurseOfWeakness();
		//System.out.println(s.getManaCost());
		try {
			CurseOfWeakness x = (CurseOfWeakness) s.clone();
			System.out.println(x);
			System.out.println(s);
		} catch (CloneNotSupportedException e) {
			
			
			e.printStackTrace();
		}
		
	}

	
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField) {
		for(int i=0;i<oppField.size();i++) {
			Minion m = oppField.get(i);
			m.setAttack((m.getAttack()-2));
		}
	}

}
