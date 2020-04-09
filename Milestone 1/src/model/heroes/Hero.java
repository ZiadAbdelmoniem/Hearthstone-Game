package model.heroes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import engine.*;
import exceptions.*;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.*;
import model.cards.spells.*;

public abstract class Hero implements MinionListener  {

	private HeroListener listener;
	private ActionValidator validator;
    private String name;
    private int currentManaCrystals;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Minion> field;
    private int fatigueDamage;
    private int currentHP;
    private boolean heroPowerUsed;
    private int totalManaCrystals;
    
    
    public Hero() {}
    public Hero(String name) throws Exception {
        deck= new ArrayList<Card>();
        field= new ArrayList<Minion>();
        hand = new ArrayList<Card>();
    	this.name=name;
        this.buildDeck();
        currentHP=30;
        for(int i=0;i<this.deck.size();i++){
        	if(this.deck.get(i) instanceof Minion){
        		Minion x=(Minion) this.deck.get(i);
        		x.setListener(this);
        	}
        }
    }

    
    
    public HeroListener getListener() {
		return listener;
	}
	public void setListener(HeroListener listener) {
		this.listener = listener;
	}
	public void setValidator(ActionValidator validator) {
		this.validator = validator;
	}
	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP=currentHP;
		this.currentHP = Math.min(Math.max(0,currentHP),30);
		if(getCurrentHP()==0)
			listener.onHeroDeath();
	}
	public void setHeroPowerUsed(boolean heroPowerUsed) {
		this.heroPowerUsed = heroPowerUsed;
	}
    public String getName() {
        return name;
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public int getCurrentHP() {
        return this.currentHP;
    }
    
	public int getTotalManaCrystals() {
        return totalManaCrystals;
    }
    public int getCurrentManaCrystals() {
        return currentManaCrystals;
    }
    public ArrayList<Minion> getField() {
        return field;
    }
    public void setTotalManaCrystals(int totalManaCrystals) {
        this.totalManaCrystals = Math.min(Math.max(0,totalManaCrystals),10);
    }
    public void setCurrentManaCrystals(int currentManaCrystals) {
    	this.currentManaCrystals = Math.min(Math.max(0,currentManaCrystals),10);
    }
    
    
    
    public void buildDeck() throws Exception{}
    public static final ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		ArrayList<Minion> minions = new ArrayList<Minion>();
		String current = br.readLine();
		while (current != null) {
			String[] line = current.split(",");
			Minion minion = null;
			String n = line[0];
			int m = Integer.parseInt(line[1]);
			Rarity r = null;
			switch (
				(line[2])
			) {
			case "b":
				r = Rarity.BASIC;
				break;
			case "c":
				r = Rarity.COMMON;
				break;
			case "r":
				r = Rarity.RARE;
				break;
			case "e":
				r = Rarity.EPIC;
				break;
			case "l":
				r = Rarity.LEGENDARY;
				break;
			}
			int a = Integer.parseInt(line[3]);
			int p = Integer.parseInt(line[4]);
			boolean t = line[5].equals("TRUE") ? true : false;
			boolean d = line[6].equals("TRUE") ? true : false;
			boolean c = line[7].equals("TRUE") ? true : false;
			if (!n.equals("Icehowl"))
				minion = new Minion(n, m, r, a, p, t, d, c);
			else
				minion = new Icehowl();
			minions.add(minion);
			current = br.readLine();
		}
		br.close();
		return minions;
	}

	public static final ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions, int count) throws CloneNotSupportedException {
		ArrayList<Minion> res = new ArrayList<Minion>();
		int i = 0;
		while (i < count) {
			
			int index = (int) (Math.random() * minions.size());
			Minion minion = minions.get(index);
			int occ = 0;
			for (int j = 0; j < res.size(); j++) {
				if (res.get(j).getName().equals(minion.getName()))
					occ++;
			}
			if (occ == 0)
			{
				res.add(minion);
				i++;
			}
			else if(occ==1 && minion.getRarity()!=Rarity.LEGENDARY)
			{
				res.add((Minion) minion.clone());
				i++;
			}
		}
		return res;
	}    public void useHeroPower() throws NotEnoughManaException,
    HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
    FullFieldException, CloneNotSupportedException{
    	validator.validateTurn(this);
    	validator.validateUsingHeroPower(this);
    	this.setHeroPowerUsed(true);
	    this.setCurrentManaCrystals(this.getCurrentManaCrystals()-2);
	    
    }
    
    public void playMinion(Minion m) throws NotYourTurnException,
    NotEnoughManaException, FullFieldException{
    	validator.validateTurn(this);
    	validator.validateManaCost(((Card)m));
    	validator.validatePlayingMinion(m);
    	int i=hand.indexOf(m);
    	field.add(m);
    	hand.remove(i);
    	this.currentManaCrystals=this.currentManaCrystals-m.getManaCost();
    }
    public void attackWithMinion(Minion attacker, Minion target) throws
    CannotAttackException, NotYourTurnException, TauntBypassException,
    InvalidTargetException, NotSummonedException{
    	validator.validateTurn(this);
    	validator.validateAttack(attacker, target);
    	attacker.attack(target);
    } 
    public void attackWithMinion(Minion attacker, Hero target) throws CannotAttackException, NotYourTurnException, TauntBypassException,
    NotSummonedException, InvalidTargetException{
    	validator.validateTurn(this);
    	validator.validateAttack(attacker, target);
    	attacker.attack(target);
    	
    }
    
    public void castSpell(FieldSpell s) throws NotYourTurnException,NotEnoughManaException{
    	validator.validateTurn(this);
    	if(this instanceof Mage){
    	boolean flag=false;
    		for(int i=0;i<field.size();i++){
    		Minion m=field.get(i);
    		if(m.getName().equalsIgnoreCase("Kalycgos"))
    			flag=true;
    	}
    		if(flag){
    			((Card) s).setManaCost(((Card) s).getManaCost()-4);
    			validator.validateManaCost((Card) s);
    			s.performAction(field);
    	    	hand.remove(s);
    	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
    	    	}
    		else{
    			validator.validateManaCost((Card) s);
    			s.performAction(field);
    	    	hand.remove(s);
    	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
    		}
    	}
    	else{
    	validator.validateManaCost((Card) s);
    	s.performAction(field);
    	hand.remove(s);
    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
    	}
    	}
    
    public void castSpell(AOESpell s, ArrayList<Minion >oppField) throws NotYourTurnException, NotEnoughManaException{
    	validator.validateTurn(this);
    	if(this instanceof Mage){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion m=field.get(i);
        		if(m.getName().equalsIgnoreCase("Kalycgos")) {
        			flag=true;
        			break;
        		}
        	}
        		if(flag){
        			((Card) s).setManaCost(((Card) s).getManaCost()-4);
        			validator.validateManaCost((Card)s);
        			s.performAction(oppField,field);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	    	}
        		else{
        			validator.validateManaCost((Card)s);
        			s.performAction(oppField,field);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	validator.validateManaCost((Card)s);
        	s.performAction(oppField,field);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(MinionTargetSpell s, Minion m) throws NotYourTurnException,NotEnoughManaException,InvalidTargetException{
    	validator.validateTurn(this);
    	if(this instanceof Mage){
        	boolean flag=false;
        	for(int i=0;i<field.size();i++){
        		Minion z=field.get(i);
        		if(z.getName().equalsIgnoreCase("Kalycgos"))
        			flag=true;
        		}
        		if(flag){
        			((Card) s).setManaCost(((Card) s).getManaCost()-4);
        			validator.validateManaCost((Card) s);
        			s.performAction(m);
        	    	hand.remove((Card)s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	    		}
        		else{
        			validator.validateManaCost((Card) s);
        			s.performAction(m);
        	    	hand.remove((Card)s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	validator.validateManaCost((Card) s);
        	s.performAction(m);
        	hand.remove((Card)s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(HeroTargetSpell s, Hero h) throws NotYourTurnException,NotEnoughManaException {
    	validator.validateTurn(this);
    	//should we check if hero is attacking himself?
    	if(this instanceof Mage){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion m=field.get(i);
        		if(m.getName().equalsIgnoreCase("Kalycgos"))
        			flag=true;
        	}
        		if(flag){
        			((Card) s).setManaCost(((Card) s).getManaCost()-4);
        			validator.validateManaCost((Card) s);
        			hand.remove(s);
        			s.performAction(h);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	    	}
        		else{
        			validator.validateManaCost((Card) s);
        			s.performAction(h);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	validator.validateManaCost((Card) s);
        	s.performAction(h);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(LeechingSpell s, Minion m) throws NotYourTurnException, NotEnoughManaException{
    	validator.validateTurn(this);
    	if(this instanceof Mage){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion z=field.get(i);
        		if(z.getName().equals("Kalycgos"))
        			flag=true;
        	}
        		if(flag){
        			((Card) s).setManaCost(((Card) s).getManaCost()-4);
        			validator.validateManaCost((Card) s);
        			int k=s.performAction(m);
        			this.setCurrentHP(getCurrentHP()+k);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	    	}
        		else{
        			validator.validateManaCost((Card) s);
        			int k=s.performAction(m);
        			this.setCurrentHP(getCurrentHP()+k);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        		validator.validateManaCost((Card) s);
        	int k=s.performAction(m);
        	this.setCurrentHP(getCurrentHP()+k);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void endTurn() throws FullHandException, CloneNotSupportedException{
    	listener.endTurn();
    }
  
    public Card drawCard() throws FullHandException, CloneNotSupportedException{
    	if(!this.getDeck().isEmpty()) {
    		boolean f =false;
    		for(int i=0;i<getField().size();i++) {
    			if(getField().get(i).getName().equalsIgnoreCase("Chromaggus")) {
    				f=true;
    				break;
    			}
    		}
    		Card c = this.getDeck().remove(0);
    		if(hand.size()==10)
    			throw new FullHandException(c);
    		this.getHand().add(c);
    		if(f&&hand.size()!=10) {
    			this.hand.add((Card)c.clone());
    		}
    		
    		
    		
    		if(deck.isEmpty()) {
    			fatigueDamage=1;
    		}
    		
    		return c;
    		
    	}
    	this.setCurrentHP(this.getCurrentHP()-fatigueDamage);
    	fatigueDamage++;
		return null;
    	}
    
    public void onMinionDeath(Minion m) {
    	int x=this.getField().indexOf(m);
    	this.field.remove(x);
	}
	
}