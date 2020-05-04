package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
	
	
	public GameController(){
		view=new preGameView(this);
			
			//model=new Game(firstplayer,secplayer);
	}


	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chosen the heros lets play")){
			//JFrame game=new JFrame();
			//game.setBounds(600, 600, 600, 600);
			//JLabel text1= new JLabel(firstplayer.getName());
			//game.add(text1);
			//JLabel text2= new JLabel(secplayer.getName());
			//game.add(text2);
			//game.setVisible(true);
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
	
	}
}
