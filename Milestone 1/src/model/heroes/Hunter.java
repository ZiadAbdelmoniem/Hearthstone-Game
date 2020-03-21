package model.heroes;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.KillCommand;
import model.cards.spells.MultiShot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;

public class Hunter extends Hero {


	public Hunter() throws Exception {
		super("Rexxar");
		//setCurrentHP(30);
	}
	public void buildDeck() throws Exception{
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,15);
		ArrayList<Card>  z = getDeck();
		for(int i=0;i<thenuetralminions.size();i++){
			Minion m= thenuetralminions.get(i);
			m.setListener(this);
			z.add((Card)m);
		}
		KillCommand spellone=new KillCommand();
		KillCommand spelltow=new KillCommand();
		MultiShot   spellthree=new MultiShot();
	    MultiShot   spellfour=new MultiShot();
	    Minion kingkrush=new Minion("King Krush",9, Rarity.LEGENDARY,8,8,false,false,true);
	    kingkrush.setListener(this);
	    z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(kingkrush);
		Collections.shuffle(z);
}
	 
	    public void useHeroPower(Hero target) throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
	    super.useHeroPower();
	    target.setCurrentHP(target.getCurrentHP()-2);
	    }
		
		public void onMinionDeath(Minion m) {
			super.onMinionDeath(m);
			
		}
		
}