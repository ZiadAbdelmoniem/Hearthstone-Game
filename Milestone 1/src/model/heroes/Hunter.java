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
	 void buildDeck() throws Exception{
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\Git\\s\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,15);
		ArrayList<Card>  z = getDeck();
		for(int i=0;i<thenuetralminions.size();i++){
			Card m= thenuetralminions.get(i);
			z.add(m);
		}
		KillCommand spellone=new KillCommand();
		KillCommand spelltow=new KillCommand();
		MultiShot   spellthree=new MultiShot();
	    MultiShot   spellfour=new MultiShot();
	    Minion kingkrush=new Minion("King Krush",9, Rarity.LEGENDARY,8,8,false,false,true);
	    z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(kingkrush);
		Collections.shuffle(z);
}
	 
	    public void useHeroPower(Hero target) throws NotEnoughManaException,
	    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
if(this.getCurrentManaCrystals()<2){
	NotEnoughManaException x=new NotEnoughManaException();
	throw x;
}
if(this.isHeroPowerUsed()){
	HeroPowerAlreadyUsedException y=new HeroPowerAlreadyUsedException();
	throw y;
}
	    target.setCurrentHP(target.getCurrentHP()-2);
	    setHeroPowerUsed(true);
	    setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	    }
		@Override
		public void onMinionDeath(Minion m) {
			// TODO Auto-generated method stub
			
		}
		
}