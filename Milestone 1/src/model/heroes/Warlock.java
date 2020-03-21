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
		 String e="C:\\Users\\H.Maher\\Desktop\\GUC\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> thenuetralminions= getNeutralMinions(getAllNeutralMinions(e),13);
		ArrayList<Card>  z = getDeck();
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
	 public void useHeroPower() throws NotEnoughManaException,
	    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		this.drawCard();
	    this.setCurrentHP(this.getCurrentHP()-2);
	    }

	 public Card drawCard() throws FullHandException, CloneNotSupportedException{
		 boolean f =false;
		 Card c = this.getDeck().get(0);
		 for(int i=0;i<getField().size();i++) {
			 if(getField().get(i).getName().equalsIgnoreCase("Wilfred Fizzlebang")) {
				 f=true;
				 break;
			 }
		 }
		 if(f) {
			 if(c!=null && this.getHand().size()<10) {
				 c.setManaCost(0);
				 getHand().add(c);
				 return c;
			 }
			if(getHand().size()==10)
				throw new FullHandException(c);
		 }
		super.drawCard();
		return c;
	 }
	
	public void onMinionDeath(Minion m) {
		super.onMinionDeath(m);
		
	}
	

}
