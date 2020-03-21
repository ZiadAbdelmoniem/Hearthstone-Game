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
		//setCurrentHP();
	}
	 void buildDeck() throws Exception {
		String e="C:\\Users\\boudi\\Desktop\\Eclipse workspace\\Git\\s\\Milestone 1\\src\\neutral_minions.csv";
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

		z.add(spellone);
		z.add(spelltow);
		z.add(spellthree);
		z.add(spellfour);
		z.add(spellfive);
		z.add(spellsix);
		z.add(velen);
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
boolean flag=false;
for(int i=0;i<getField().size();i++){
	Minion m=getField().get(i);
	if(m.getName().equals("Prophet Velen")){
		flag=true;
	}
}
if(flag){
	 if(o instanceof Hero){
	    	Hero z=(Hero) o;
	    	if(z.getCurrentHP()>24)
	    		z.setCurrentHP(30);
	    	else{
	    		z.setCurrentHP(z.getCurrentHP()+8);
	    	}
	    }
	    else if(o instanceof Minion){
	    	Minion z=(Minion) o;
	    	int limit=z.getMaxHP()-8;
	    	if(z.getCurrentHP()>limit)
	    		z.setCurrentHP(z.getMaxHP());
	    	else{
	    		z.setCurrentHP(z.getCurrentHP()+8);
	    	}
	    }
	    setHeroPowerUsed(true);
	    setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	    }

else{

	    if(o instanceof Hero){
	    	Hero z=(Hero) o;
	    	if(z.getCurrentHP()>28)
	    		z.setCurrentHP(30);
	    	else{
	    		z.setCurrentHP(z.getCurrentHP()+2);
	    	}
	    }
	    else if(o instanceof Minion){
	    	Minion z=(Minion) o;
	    	int limit=z.getMaxHP()-2;
	    	if(z.getCurrentHP()>limit)
	    		z.setCurrentHP(z.getMaxHP());
	    	else{
	    		z.setCurrentHP(z.getCurrentHP()+2);
	    	}
	    }
	    setHeroPowerUsed(true);
	    setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	    }

	 }
	@Override
	public void onMinionDeath(Minion m) {
		// TODO Auto-generated method stub
		
	}
	
	 }
