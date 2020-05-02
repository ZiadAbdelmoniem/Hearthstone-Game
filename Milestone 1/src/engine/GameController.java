package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.heroes.Hero;
import model.heroes.Mage;

public class GameController implements ActionListener,GameListener {
	private Game model;
	private preGameView view;
	private Hero firstplayer;
	private Hero secplayer;
	
	
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
			JFrame game=new JFrame();
			game.setBounds(600, 600, 600, 600);
			JLabel text= new JLabel("the GAME has started");
			game.add(text);
			game.setVisible(true);
			//Game g=new Game(firstplayer, secplayer);
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
	}
	
	public static void main (String [] args){
		GameController c=new GameController();
		//boody
	
	}
}
