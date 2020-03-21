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

	 void buildDeck() throws Exception {
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\Git\\s\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,15);
		ArrayList<Card> z=getDeck();
		int size=thenuetralminions.size();
		for(int i=0;i<size;i++){
			z.add((Card)(thenuetralminions.get(i)));
		}
		Card spellone= new SealOfChampions();
		Card spelltow= new SealOfChampions();
		Card spellthree= new LevelUp();
		Card  spellfour= new LevelUp();
		Minion t = new Minion("Tirion Fordring",4, Rarity.LEGENDARY,6,6,true,true,false);
		//Minion Tirion=new Minion("Tirion Fording",4, Rarity.LEGENDARY,6,6,true,true,false);
		z.add(t);
		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		//z.add(Tirion);
		Collections.shuffle(z);
}
	 
	 public void useHeroPower(Object o) throws NotEnoughManaException,
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
if(this.getField().size()==7){
	FullFieldException f= new FullFieldException();
	throw f;
}
else{
	Minion r=new Minion("Silver Hand Recruit",1,Rarity.BASIC,1,1,false,false,false);
	ArrayList<Minion> s=this.getField();
	s.add(r);
}
	    setHeroPowerUsed(true);
	    setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	    
}
	 
	 
		public static void main(String []args) { 			
			
}

		@Override
		public void onMinionDeath(Minion m) {
			// TODO Auto-generated method stub
			
		}

	
}