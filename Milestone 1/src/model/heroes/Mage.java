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

public class Mage extends Hero{
	public Mage() throws Exception{
		super("Jaina Proudmoore");
		
	}
	 public void buildDeck() throws Exception {
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,13);
		ArrayList<Card>  z = getDeck();
		for(int i=0;i<thenuetralminions.size();i++){
			thenuetralminions.get(i).setListener(this);
			z.add((Card)(thenuetralminions.get(i)));
		}
		Polymorph spellone= new Polymorph();
		Polymorph spelltow= new Polymorph();
		Flamestrike spellthree= new Flamestrike();
		Flamestrike   spellfour= new Flamestrike();
		Pyroblast spellfive=new Pyroblast();
		Pyroblast spellsix=new Pyroblast();
		Minion kalycgos=new Minion("Kalycgos",10, Rarity.LEGENDARY,4,12,false,false,false);
		kalycgos.setListener(this);
		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(spellfive);
		z.add(spellsix);
		z.add(kalycgos);
		Collections.shuffle(z);
}

	 public void useHeroPower(Hero z) throws NotEnoughManaException,HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,FullFieldException, CloneNotSupportedException{
		super.useHeroPower();
		 	 z.setCurrentHP(z.getCurrentHP()-1);
		 }
	 public void useHeroPower(Minion z) throws NotEnoughManaException,HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,FullFieldException, CloneNotSupportedException{
			super.useHeroPower();
			 z.setCurrentHP(z.getCurrentHP()-1);
	 }
	@Override
	public void onMinionDeath(Minion m) {
		super.onMinionDeath(m);
		
	}
	
}
