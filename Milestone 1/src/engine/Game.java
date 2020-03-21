package engine;
import java.util.Random;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.HeroListener;
public class Game implements ActionValidator,HeroListener{
//ba7ebak ya boody
	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;
	private GameListener listener;
	
	
	public void setListener(GameListener listener) {
		this.listener = listener;
	}
	public Hero getCurrentHero() {
		return currentHero;
	}
	public Hero getOpponent() {
		return opponent;
	}
	
	
	
	public Game() {}
	public Game(Hero p1, Hero p2) {
		firstHero=p1;
		secondHero=p2;
		Random ra= new Random();
		int i= ra.nextInt(4);
		if(i%2==0) {
		currentHero=firstHero;
		opponent=secondHero;
		}
		else {
			currentHero=secondHero;
			opponent=firstHero;
		}
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);
	}
	
	public void validateTurn(Hero user) throws NotYourTurnException {
		if(!currentHero.equals(user))
			throw new NotYourTurnException();
	}
	
	public void validateAttack(Minion attacker, Minion target) throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		
	}
	
	public void validateAttack(Minion attacker, Hero target) throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		
	}
	
	public void validateManaCost(Card card) throws NotEnoughManaException {
		
	}
	
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		
	}
	
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		
	}
	public void onHeroDeath() {
		
	}
	
	public void damageOpponent(int amount) {
		
	}
	
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		
	}

}
