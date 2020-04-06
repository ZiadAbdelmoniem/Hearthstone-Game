package engine;
import java.util.ArrayList;
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
import model.heroes.Mage;
import model.heroes.Warlock;
public class Game implements ActionValidator,HeroListener{

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
	public Game(Hero p1, Hero p2) throws FullHandException, CloneNotSupportedException {
	
		firstHero=p1;
		secondHero=p2;
		
		int coin = (int) (Math.random()*2);
		currentHero= coin==0?firstHero:secondHero;
		opponent= currentHero==firstHero?secondHero:firstHero;
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);

		
		int i=0;
		while(i<3) {
			currentHero.drawCard();
			opponent.drawCard();
			i++;
		}
		opponent.drawCard();
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);
		currentHero.setListener(this);
		opponent.setListener(this);
	}
	public static boolean tauntexist(ArrayList<Minion> o){
		boolean flag=false;
		for(int i=0;i<o.size();i++){
			Minion m=o.get(i);
			if(m.isTaunt())
				return true;
		}
		return flag;
	}
	
	public void validateTurn(Hero user) throws NotYourTurnException {
		if(opponent.equals(user))
			throw new NotYourTurnException();
	}
	
	public void validateAttack(Minion attacker, Minion target) throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if(currentHero.getField().contains(target) && currentHero.getField().contains(attacker))
			throw new InvalidTargetException();
		if(!opponent.getField().contains(target))
			throw new NotSummonedException();
		if(attacker.getAttack()==0)
			throw new CannotAttackException();
		if(attacker.isAttacked())
			throw new CannotAttackException();
		if(attacker.isSleeping())
			throw new CannotAttackException();
		if(!(currentHero.getField().contains(attacker)))
			throw new NotSummonedException();
		if(!(opponent.getField().contains(target)))
			throw new NotSummonedException();
		
		ArrayList<Minion> opf=opponent.getField();
		boolean[] taunts=new boolean[opf.size()]; //array of taunt minions indecies
		int index=opf.indexOf(target); //index of target
		boolean ex=false; //check if there are any taunts
		for(int i=0;i<opf.size();i++) {
			if(opf.get(i).isTaunt()) {
				taunts[i]=true;
				ex=true;
			}
		}
		if(ex&&(taunts[index]==false))
			throw new TauntBypassException();
	}
	
	public void validateAttack(Minion attacker, Hero target) throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if(attacker.getAttack()==0)
			throw new CannotAttackException();
		if(attacker.isAttacked())
			throw new CannotAttackException();
		if(target.equals(currentHero))
			throw new InvalidTargetException();
		if(attacker.isSleeping())
			throw new CannotAttackException();
		if(!(currentHero.getField().contains(attacker)))
			throw new NotSummonedException();
				
		boolean tauntex=false;
		for(int i=0;i<opponent.getField().size();i++) {
			if(opponent.getField().get(i).isTaunt()) {
				tauntex=true;
				break;
			}
		}
		if(tauntex) {
			throw new TauntBypassException();
		}
	}
	
	public void validateManaCost(Card card) throws NotEnoughManaException {
		int manac= card.getManaCost();
		if(currentHero.getCurrentManaCrystals()<manac)
			throw new NotEnoughManaException();
	}
	
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		if(currentHero.getField().size()==7)
			throw new FullFieldException();
	}
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		if(hero.getCurrentManaCrystals()<2)
			throw new NotEnoughManaException();
		if(hero.isHeroPowerUsed())
			throw new HeroPowerAlreadyUsedException();
	}
	public void onHeroDeath() {
		listener.onGameOver();
	}
	
	public void damageOpponent(int amount)
	{
		opponent.setCurrentHP(opponent.getCurrentHP()-amount);
	}
	
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		Hero t = opponent;
		opponent=currentHero;
		currentHero=t;
		currentHero.drawCard();
		currentHero.setTotalManaCrystals(currentHero.getTotalManaCrystals()+1);
		currentHero.setCurrentManaCrystals(currentHero.getTotalManaCrystals());
		currentHero.setHeroPowerUsed(false);
		for(int i=0;i<currentHero.getField().size();i++) {
			currentHero.getField().get(i).setAttacked(false);
		}
	}
	public static void main(String[] args) throws Exception {
		Hero w= new Warlock();
		Hero m = new Mage();
		Game g = new Game(w,m);
		System.out.println(g.getOpponent().getCurrentHP());
		g.damageOpponent(28);
		System.out.println(g.getOpponent().getCurrentHP());
		g.damageOpponent(1);
		System.out.println(g.getOpponent().getCurrentHP());
		
	}
}

