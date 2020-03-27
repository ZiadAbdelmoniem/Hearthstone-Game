package model.heroes;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;

public class Paladin extends Hero{
	
	public Paladin() throws Exception {
		super("Uther Lightbringer");
		
	   // buildDeck();
	}

	public void buildDeck() throws Exception {
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,15);
		ArrayList<Card> z=getDeck();
		int size=thenuetralminions.size();
		for(int i=0;i<size;i++){
			Minion m= thenuetralminions.get(i);
			m.setListener(this);
			z.add((Card)m);
	}
		Card spellone= new SealOfChampions();
		Card spelltow= new SealOfChampions();
		Card spellthree= new LevelUp();
		Card  spellfour= new LevelUp();
		
		Minion t = new Minion("Tirion Fordring",4, Rarity.LEGENDARY,6,6,true,true,false);
		t.setListener(this);
		
		z.add(t);
		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		//z.add(Tirion);
		Collections.shuffle(z);
}
	 
	public void useHeroPower() throws NotEnoughManaException,
    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
    FullFieldException, CloneNotSupportedException{
    	super.useHeroPower();
    	if(this.getField().size()==7)
    		throw new FullFieldException();
		Minion r=new Minion("Silver Hand Recruit",1,Rarity.BASIC,1,1,false,false,false);
    	this.getField().add(r);
			
}
	 
	 
		public static void main(String []args) { 			
			
}

		@Override
		public void onMinionDeath(Minion m) {
			super.onMinionDeath(m);
			
		}

	
}