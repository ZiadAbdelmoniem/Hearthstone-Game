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
	}
	public void buildDeck() throws Exception{
		String e="C:\\Users\\H.Maher\\Desktop\\GUC\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> neutrals= getNeutralMinions(getAllNeutralMinions(e),15);
		getDeck().addAll(neutrals);
		for(int i = 0 ; i < 2; i++)
		{
			getDeck().add(new KillCommand());
			getDeck().add(new MultiShot());
			
		}
		Minion krush=(new Minion("King Krush", 9, Rarity.LEGENDARY, 8, 8, false, false, true));
		krush.setListener(this);
		getDeck().add(krush);
		Collections.shuffle(getDeck());
}
	 
	    public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
	    super.useHeroPower();
	    try {
			getListener().damageOpponent(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    }
		
		public void onMinionDeath(Minion m) {
			super.onMinionDeath(m);
			
		}
		
}