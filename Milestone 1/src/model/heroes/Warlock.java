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

public class Warlock extends Hero{
	public Warlock() throws Exception{
		super("Gul'dan");

	}
	 public void buildDeck() throws Exception {
		 String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> thenuetralminions= getNeutralMinions(getAllNeutralMinions(e),13);
		ArrayList<Card>  z = super.getDeck();
		int size =thenuetralminions.size();
		for(int i=0;i<size;i++){
			thenuetralminions.get(i).setListener(this);
			z.add((Card)(thenuetralminions.get(i)));
		}
		CurseOfWeakness spellone= new CurseOfWeakness();
		CurseOfWeakness spelltow= new CurseOfWeakness();
		SiphonSoul spellthree= new SiphonSoul();
		SiphonSoul   spellfour= new SiphonSoul();
		TwistingNether spellfive= new TwistingNether();
		TwistingNether spellsix= new TwistingNether();
		Minion wilfred= new Minion("Wilfred Fizzlebang",6, Rarity.LEGENDARY,4,4,false,false,false);
		wilfred.setListener(this);
		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(spellfive);
		z.add(spellsix);
		z.add(wilfred);
		Collections.shuffle(z);
}
	 public void useHeroPower() throws NotEnoughManaException,HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		if(this.getDeck().isEmpty())
			super.drawCard();
		this.drawCard();
	    this.setCurrentHP(this.getCurrentHP()-2);
	    }
	 public Card drawCard() throws FullHandException, CloneNotSupportedException{
		 boolean f =false;
		 boolean ch=false;
		 if(!this.getDeck().isEmpty()) {
			 Card c = this.getDeck().remove(0);
			 if(getHand().size()==10) 
	    			throw new FullHandException(c);
	    	for(int i=0;i<this.getField().size();i++) {
	    		Minion mi = this.getField().get(i);
	    		if(mi.getName().equalsIgnoreCase("Wilfred Fizzlebang")) 
	    			f=true;
	    		if(mi.getName().equalsIgnoreCase("Chromaggus"))
	    			ch=true;
	    	}
			 if(f && c instanceof Minion) {
				 c.setManaCost(0);
				 this.getHand().add(0,c);
			 }
			 else {
				 this.getHand().add(0,c);
			 }
			if(ch) {
				if(getHand().size()==10)
					throw new FullHandException(c);
				this.getHand().add((Card)c.clone());
			}
			return c;
		 }
		super.drawCard();
		return null;
		 }
		 
	public void onMinionDeath(Minion m) {
		super.onMinionDeath(m);
		
	}
	

}
