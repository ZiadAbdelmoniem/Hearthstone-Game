package model.cards;

public abstract class Card implements Cloneable   {
	private String name;
	private int manaCost;
	private Rarity rarity;
	
	public Rarity getRarity() {
		return rarity;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = Math.min(Math.max(manaCost,0),10);
	}
	
	public Card() {}
	public Card(String name,int manaCost,Rarity rarity) {
		this.setName(name);
		this.setManaCost(manaCost);
		this.rarity=rarity;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	//public Card clone() throws CloneNotSupportedException{
		
		//Card clone = (Card) super.clone();
		//return clone;
	//}
	
	

}
