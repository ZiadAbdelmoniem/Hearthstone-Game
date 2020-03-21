package model.cards.minions;

import exceptions.InvalidTargetException;
import model.cards.Card;
import model.cards.Rarity;
import model.heroes.Hero;

public class Minion extends Card implements Cloneable {

	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean divine;
	private boolean sleeping;
	private boolean attacked;
	MinionListener listener;

	public boolean isAttacked() {
		return attacked;
	}

	public void setListener(MinionListener listener) {
		this.listener = listener;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {

		this.sleeping = sleeping;
	}

	public boolean isDivine() {
		return divine;
	}

	public void setDivine(boolean divine) {
		this.divine = divine;
	}

	public boolean isTaunt() {
		return taunt;
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = Math.min(Math.max(currentHP,0),maxHP);
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public void setAttack(int attack) {
		if(attack<=0)
			attack=0;
		
		this.attack = attack;
	}
	

	public int getAttack() {
		return attack;
	}

	public Minion() {
	}

	public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean divine,
			boolean charge) {
		super(name, manaCost, rarity);
		this.attack = attack;
		this.maxHP = maxHP;
		currentHP = maxHP;
		this.taunt = taunt;
		this.divine = divine;
		sleeping = !charge;
		attacked = false;
	}
	
	public String toString() {
		
		return getName()+" "+getManaCost()+" "+getRarity()+" "+getAttack()+" "+getMaxHP(); 
	}
	
//	public Minion clone1() {
//		String name=this.getName();
//		int manac=this.getManaCost();
//		Rarity  ra=this.getRarity();
//		int att= this.getAttack();
//		int maxhp=this.getMaxHP();
//		boolean t= this.taunt;
//		boolean dv=this.divine;
//		boolean ch=!this.sleeping;
//		return new Minion(name,manac,ra,att,maxhp,t,dv,ch);
//	}
	
	public boolean equals(Object o) {
		Minion m = (Minion)o;
		if(this.getName().equals(m.getName()))
			return true;
		return false;
	}
	
	public Object clone() throws CloneNotSupportedException{
		String name=this.getName();
		int manac=this.getManaCost();
		Rarity  ra=this.getRarity();
		int att= this.getAttack();
		int maxhp=this.getMaxHP();
		boolean t= this.taunt;
		boolean dv=this.divine;
		boolean ch=!this.sleeping;
		return new Minion(name,manac,ra,att,maxhp,t,dv,ch);
		
	}

	public void attack(Minion target){
		if(this.divine && target.divine) {
			this.divine = false;
			target.divine=false;
		}
		else if(this.divine) {
			//if(attack>=target.getCurrentHP()) should we do anything on death?
			// remove from deck and?
			target.setCurrentHP(target.getCurrentHP() - attack);
			this.divine=false;
		}
		else if(target.divine) {
			this.setCurrentHP(getCurrentHP() - target.getAttack());
			target.divine=false;
		}
			else {
			target.setCurrentHP(getCurrentHP() - attack);
			this.setCurrentHP(getCurrentHP() - target.getAttack());
		}
		
		}
	public void attack(Hero target) throws InvalidTargetException {
		if(this.getName().equals("Icehowl")) {
			InvalidTargetException F= new InvalidTargetException();
			throw F;
		}
		else {
			target.setCurrentHP(target.getCurrentHP() - attack);
		}
		}
	
	
}