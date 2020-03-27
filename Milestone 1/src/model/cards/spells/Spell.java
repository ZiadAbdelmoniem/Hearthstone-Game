package model.cards.spells;
import model.cards.Rarity;
import model.cards.Card;

public abstract class Spell extends Card {
	public Spell(String name, int manaCost ,Rarity rarity) {
		super(name, manaCost, rarity);
	}
	public Spell() {
		
	}
	public  Object clone() throws CloneNotSupportedException{
		return super.clone();
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
