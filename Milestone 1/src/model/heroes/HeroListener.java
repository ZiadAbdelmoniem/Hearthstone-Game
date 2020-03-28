package model.heroes;

import exceptions.FullHandException;

public interface HeroListener {
	public void onHeroDeath();
	public void damageOpponent(int amount) throws Exception;
	public void endTurn() throws FullHandException, CloneNotSupportedException;

}
