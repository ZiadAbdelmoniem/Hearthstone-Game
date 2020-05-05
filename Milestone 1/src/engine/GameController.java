package engine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;


import model.cards.minions.*;
import model.cards.spells.*;
import model.cards.*;
import model.heroes.*;

public class GameController implements ActionListener,GameListener {
	private static Game model;
	private preGameView view;
	private static GameView gameview;
	private static Hero firstplayer;
	private static Hero secplayer;
	private static Minion minionInAttack;
	private static Hero herotobeattacked;
	private static Spell spelltobeused;
	private static Hero herotousepower;
	
	
	public GameController(){
		minionInAttack=null;
		herotobeattacked=null;
		spelltobeused=null;
		herotousepower=null;
		view=new preGameView(this);
	}


	@Override
	public void onGameOver() {
		if(firstplayer.getCurrentHP()==0){
			gameview.removeMain();
			JLabel player2=new JLabel("THE 2ND PLAYER WINSS!!!");
			gameview.add(player2);
			gameview.revalidate();
			gameview.repaint();
		}
		else if(secplayer.getCurrentHP()==0){
			gameview.removeMain();
			JLabel player1=new JLabel("THE 1st PLAYER WINSS!!!");
			gameview.add(player1);
			gameview.revalidate();
			gameview.repaint();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chosen the heros lets play")){
			Game g;
			try {
				g = new Game(firstplayer, secplayer);
				model=g;
				gameview =new GameView(this,model);
				view.removeAll();
				view.dispose();
			} catch (FullHandException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("chose mage 1")){
			
			try {
				Mage m=new Mage();
				firstplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getActionCommand().equals("chose priest 1")){
			
			try {
				Priest m=new Priest();
				firstplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		if(e.getActionCommand().equals("chose hunter 1")){
			
			try {
				Hunter m=new Hunter();
				firstplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		

		if(e.getActionCommand().equals("chose paladin 1")){
			
			try {
				Paladin m=new Paladin();
				firstplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		

		if(e.getActionCommand().equals("chose warlock 1")){
			
			try {
				Warlock m=new Warlock();
				firstplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		

		if(e.getActionCommand().equals("chose mage 2")){
			
			try {
				Mage m=new Mage();
				secplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getActionCommand().equals("chose priest 2")){
			
			try {
				Priest m=new Priest();
				secplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getActionCommand().equals("chose hunter 2")){
			
			try {
				Hunter m=new Hunter();
				secplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getActionCommand().equals("chose paladin 2")){
			
			try {
				Paladin m=new Paladin();
				secplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		if(e.getActionCommand().equals("chose warlock 2")){
			
			try {
				Warlock m=new Warlock();
				secplayer=m;
			} catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
		
		if(e.getActionCommand().equals("current hero used herpower")){
			if(model.getCurrentHero() instanceof Mage){}
			if(model.getCurrentHero() instanceof Hunter){
				try {
					model.getCurrentHero().useHeroPower();
					gameview.refresh(this, model);
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(model.getCurrentHero() instanceof Paladin){
				try {
					model.getCurrentHero().useHeroPower();
					gameview.refresh(this, model);
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(model.getCurrentHero() instanceof Priest){}
			if(model.getCurrentHero() instanceof Warlock){
				try {
					model.getCurrentHero().useHeroPower();
					gameview.refresh(this, model);
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (HeroPowerAlreadyUsedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullHandException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
		
		
		
		if(e.getActionCommand().equals("0card in hand")){
			Card card1=model.getCurrentHero().getHand().get(0);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		
		if(e.getActionCommand().equals("1card in hand")){
			Card card1=model.getCurrentHero().getHand().get(1);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("2card in hand")){
			Card card1=model.getCurrentHero().getHand().get(2);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("3card in hand")){
			Card card1=model.getCurrentHero().getHand().get(3);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("4card in hand")){
			Card card1=model.getCurrentHero().getHand().get(4);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("5card in hand")){
			Card card1=model.getCurrentHero().getHand().get(5);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		
		if(e.getActionCommand().equals("6card in hand")){
			Card card1=model.getCurrentHero().getHand().get(6);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("7card in hand")){
			Card card1=model.getCurrentHero().getHand().get(7);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("8card in hand")){
			Card card1=model.getCurrentHero().getHand().get(8);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("9card in hand")){
			Card card1=model.getCurrentHero().getHand().get(9);
			if(card1 instanceof Minion){
				try {
					model.getCurrentHero().playMinion((Minion) card1);
					gameview.refresh(this,model);
				} catch (NotYourTurnException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnoughManaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FullFieldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameview.refresh(this,model);
				
			}
			else {
				if(card1 instanceof AOESpell){
					try {
						model.getCurrentHero().castSpell((AOESpell)card1, model.getOpponent().getField());
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof FieldSpell){
					try {
						model.getCurrentHero().castSpell((FieldSpell) card1);
						gameview.refresh(this, model);
					} catch (NotYourTurnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotEnoughManaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(card1 instanceof HeroTargetSpell){
					//model.getCurrentHero().castSpell(card1,h);
				}
				if(card1 instanceof LeechingSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
				if(card1 instanceof MinionTargetSpell){
					//model.getCurrentHero().castSpell(card1,m);
				}
			
		}
			
			
			}
		
		if(e.getActionCommand().equals("wants to attack the minion number 0")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(0));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 1")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(1));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 2")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(2));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 3")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(3));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 4")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(4));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 5")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(5));
		}
		
		if(e.getActionCommand().equals("wants to attack the minion number 6")){
			if(herotousepower==null && spelltobeused==null && minionInAttack!=null)
			minionInAttack.attack(model.getOpponent().getField().get(6));
		}
		
		if(e.getActionCommand().equals("turn ended")){
			try {
				model.endTurn();
				gameview.refresh(this, model);
			} catch (FullHandException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	public static void main (String [] args){
		GameController c=new GameController();
		//JTextArea nignog=new JTextArea("niggaa is the biggest   farstcvo invjsvs pcsndv bsdubvsbiv ios ndbhs b dchsu cbiushc iush cuh s uhi cbhsb cbdb bd bu ebvibbf efi ygd yc vv");
		//nignog.setLineWrap(true);
		//nn.add(nignog);
		//nignog.setVisible(true);
	
	}
}
