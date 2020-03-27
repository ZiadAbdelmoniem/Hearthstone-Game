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
        setCurrentHP(30);
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
	public static final ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException{
        ArrayList<Minion> li=new ArrayList<Minion>();
        BufferedReader br= new BufferedReader(new FileReader(filePath));
        String row="";
        while((row=br.readLine())!=null) {
            String[] data= row.split(",");
            String name = data[0];
            if(name.equalsIgnoreCase("Icehowl")) {
            	Icehowl mi = new Icehowl();
            	li.add(mi);
            }
            else {
            int manacost =Integer.parseInt(data[1]);
            char ra = data[2].charAt(0);
            Rarity r=null;
            switch(ra) {
                case 'l':r=Rarity.LEGENDARY;break;
                case 'b':r=Rarity.BASIC;break;
                case 'e': r=Rarity.EPIC; break;
                case 'r': r=Rarity.RARE; break;
                case 'c': r=Rarity.COMMON; break;
                default : break;
            }
            int att=Integer.parseInt(data[3]);
            int mxhp=Integer.parseInt(data[4]);
            boolean ta=false;
            if(data[5].equalsIgnoreCase("TRUE"))
                ta=true;
            boolean dv=false;
            if(data[6].equalsIgnoreCase("TRUE"))
                dv=true;
            boolean ch=false;
            if(data[7].equalsIgnoreCase("TRUE"))
                ch=true;
            Minion mi=new Minion(name,manacost,r,att,mxhp,ta,dv,ch);
            li.add(mi);
            }
        }
        br.close();
        return li;
    }
    public static final ArrayList<Minion> getNeutralMinions(ArrayList<Minion> allminions,int count) throws IOException, CloneNotSupportedException{
    	ArrayList<Minion> pls=new ArrayList<Minion>();
    	int size1=allminions.size();
    	while(pls.size()<count){
    	for(int j=0; j<count;j++) {
    		Random ra=new Random();
    		int i= ra.nextInt(size1);
    		Minion x=allminions.get(i);
    		int rep=0;
    		boolean flag=true;
    		for(int k=0;k<pls.size();k++) {
    			Minion m=pls.get(k);
    			if(x.equals(m)&&x.getRarity().equals(Rarity.LEGENDARY)) {
    			    flag=false;
    			    break;
    			}
    			else if(x.equals(m)&& !(x.getRarity().equals(Rarity.LEGENDARY))) {
    				rep++;
    				if(rep>1) {
    					flag=false;
    					break;
    				}
    			}
    		}
    		if(flag) {
    			Minion x1=(Minion)x.clone();
    			pls.add(x1);
    		}
    		if(pls.size()==count)
    			break;
    		}
     }
		return pls;
    }
    public void useHeroPower() throws NotEnoughManaException,
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
    	validator.validateManaCost((Card)s);
    	if(name.equals("Jaina Proudmoore")){
    	boolean flag=false;
    		for(int i=0;i<field.size();i++){
    		Minion m=field.get(i);
    		if(m.getName().equals("Kalycgos"))
    			flag=true;
    	}
    		if(flag){
    			s.performAction(field);
    	    	hand.remove(s);
    	    	if(((Card)s).getManaCost()<4)
    	    		this.currentManaCrystals=this.currentManaCrystals-0;
    	    	else{
    	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost()+4;
    	    	}
    	    	}
    		else{
    			s.performAction(field);
    	    	hand.remove(s);
    	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
    		}
    	}
    	else{
    	s.performAction(field);
    	hand.remove(s);
    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
    	}
    	}
    
    public void castSpell(AOESpell s, ArrayList<Minion >oppField) throws NotYourTurnException, NotEnoughManaException{
    	validator.validateTurn(this);
    	validator.validateManaCost((Card)s);
    	if(name.equals("Jaina Proudmoore")){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion m=field.get(i);
        		if(m.getName().equalsIgnoreCase("Kalycgos")) {
        			flag=true;
        			break;
        		}
        	}
        		if(flag){
        			s.performAction(oppField,field);
        	    	hand.remove(s);
        	    	if(((Card)s).getManaCost()<4)
        	    		this.currentManaCrystals=this.currentManaCrystals-0;
        	    	else{
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost()+4;
        	    	}
        	    	}
        		else{
        			s.performAction(oppField,field);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	s.performAction(oppField,field);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(MinionTargetSpell s, Minion m) throws NotYourTurnException,NotEnoughManaException,InvalidTargetException{
    	
    	if(this.field.contains(m))
    		throw new InvalidTargetException();
    	validator.validateTurn(this);
    	validator.validateManaCost((Card)s);
    	if(name.equals("Jaina Proudmoore")){
        	boolean flag=false;
        	for(int i=0;i<field.size();i++){
        		Minion z=field.get(i);
        		if(z.getName().equals("Kalycgos"))
        			flag=true;
        		}
        		if(flag){
        			s.performAction(m);
        	    	hand.remove((Card)s);
        	    	if(((Card)s).getManaCost()<4)
        	    		this.currentManaCrystals=this.currentManaCrystals-0;
        	    	else{
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost()+4;
        	    		}
        		}
        		else{
        			s.performAction(m);
        	    	hand.remove((Card)s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	s.performAction(m);
        	hand.remove((Card)s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(HeroTargetSpell s, Hero h) throws NotYourTurnException,NotEnoughManaException {
    	validator.validateManaCost((Card)s);
    	validator.validateTurn(this);
    	if(name.equals("Jaina Proudmoore")){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion m=field.get(i);
        		if(m.getName().equals("Kalycgos"))
        			flag=true;
        	}
        		if(flag){
        			s.performAction(h);
        	    	hand.remove(s);
        	    	if(((Card)s).getManaCost()<4)
        	    		this.currentManaCrystals=this.currentManaCrystals-0;
        	    	else{
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost()+4;
        	    	}
        	    	}
        		else{
        			s.performAction(h);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	s.performAction(h);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void castSpell(LeechingSpell s, Minion m) throws NotYourTurnException, NotEnoughManaException{
    	validator.validateTurn(this);
    	validator.validateManaCost((Card)s);
    	if(name.equals("Jaina Proudmoore")){
        	boolean flag=false;
        		for(int i=0;i<field.size();i++){
        		Minion z=field.get(i);
        		if(z.getName().equals("Kalycgos"))
        			flag=true;
        	}
        		if(flag){
        			s.performAction(m);
        	    	hand.remove(s);
        	    	if(((Card)s).getManaCost()<4)
        	    		this.currentManaCrystals=this.currentManaCrystals-0;
        	    	else{
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost()+4;
        	    	}
        	    	}
        		else{
        			s.performAction(m);
        	    	hand.remove(s);
        	    	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        		}
        	}
        	else{
        	s.performAction(m);
        	hand.remove(s);
        	this.currentManaCrystals=this.currentManaCrystals-((Card) s).getManaCost();
        	}
    	
    }
    
    public void endTurn() throws FullHandException, CloneNotSupportedException{
    	listener.endTurn();
    }
  
    public Card drawCard() throws FullHandException, CloneNotSupportedException{
    	Card c = deck.remove(0);
    	if(c!=null) {
    		if(hand.size()==10) {
    			throw new FullHandException(c);
    		}
    		hand.add(c);
    		if(deck.isEmpty()) {
    			fatigueDamage=1;
    			return c;
    		}
    	}
    	setCurrentHP(getCurrentHP()-fatigueDamage);
    	fatigueDamage++;
    	
		return c;
    }
    public void onMinionDeath(Minion m) {
    	int x=this.getField().indexOf(m);
    	this.getField().remove(x);
	}
	
}