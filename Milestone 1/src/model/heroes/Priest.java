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

public class Priest extends Hero{
	public Priest() throws Exception {
		super("Anduin Wrynn");
	}
	 public void buildDeck() throws Exception {
		String e="C:\\Users\\H.Maher\\Desktop\\GUC\\hmmm\\Milestone 1\\src\\neutral_minions.csv";
		ArrayList<Minion> allneutralminions= getAllNeutralMinions(e);
		ArrayList<Minion> thenuetralminions= getNeutralMinions(allneutralminions,13);
		ArrayList<Card>  z = getDeck();
		for(int i=0;i<thenuetralminions.size();i++){
			z.add((Card)(thenuetralminions.get(i)));
		}
		DivineSpirit spellone= new DivineSpirit();
		DivineSpirit spelltow= new DivineSpirit();
		HolyNova spellthree= new HolyNova();
		HolyNova   spellfour= new HolyNova();
		ShadowWordDeath spellfive= new ShadowWordDeath();
		ShadowWordDeath spellsix= new ShadowWordDeath();
		Minion velen= new Minion("Prophet Velen",7, Rarity.LEGENDARY,7,7,false,false,false);
		velen.setListener(this);
		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(spellfive);
		z.add(spellsix);
		z.add(velen);
		Collections.shuffle(z);

	}
	 public void useHeroPower(Minion mi ) throws NotEnoughManaException,
	    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
		 super.useHeroPower();
		 boolean flag=false;
		 for(int i=0;i<getField().size();i++){
			 Minion m=getField().get(i);
			 if(m.getName().equalsIgnoreCase("Prophet Velen")){
				 flag=true;
			 }
		 }
		 if(flag){
	    		mi.setCurrentHP(mi.getCurrentHP()+8);
	    }
		 else{
	    		mi.setCurrentHP(mi.getCurrentHP()+2);
	    }
	}	 
	 
	 public void useHeroPower(Hero mi) throws NotEnoughManaException,
	    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	    FullFieldException, CloneNotSupportedException{
		 super.useHeroPower();
		 boolean flag1=false;
		 for(int i=0;i<this.getField().size();i++){
			 Minion m=this.getField().get(i);
			 if(m.getName().equals("Prophet Velen")){
				 flag1=true;
				 break;
			 }
		 }

		 if(flag1==true){
	    		mi.setCurrentHP(mi.getCurrentHP()+8);
	    }
		 else{
	    		mi.setCurrentHP(mi.getCurrentHP()+2);
	    }
	}	 
	 
	 
	public void onMinionDeath(Minion m) {
		super.onMinionDeath(m);
		
	}
}
