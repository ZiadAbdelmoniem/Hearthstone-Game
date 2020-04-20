package engine;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.AOESpell;
import model.cards.spells.Flamestrike;
import model.cards.spells.HeroTargetSpell;
import model.cards.spells.MinionTargetSpell;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;
import model.cards.spells.Spell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.heroes.Hero;
import model.heroes.Mage;

public class GameController implements ActionListener,GameListener {
	private Game model;
	private GameView view;
	private Hero firstplayer;
	private Hero secplayer;
	
	
	public GameController(){
			view=new GameView(this);
			
			//model=new Game(firstplayer,secplayer);
	}


	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("chosen the heros lets play")){
			JFrame game=new JFrame();
			game.setBounds(600, 600, 600, 600);
			JLabel text= new JLabel("the GAME has started");
			game.add(text);
			game.setVisible(true);
			//Game g=new Game(firstplayer, secplayer);
		}
		if(e.getActionCommand().equals("chose mage 1")){
			
			//firstplayer=(Hero) m;
			
		}
	}
	
	public static void main (String [] args){
		GameController c=new GameController();
	
	}
}
