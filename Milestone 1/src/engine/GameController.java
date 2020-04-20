package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.heroes.Hero;

public class GameController implements ActionListener,GameListener {
	private Game model;
	private GameView view;
	private Hero firstplayer;
	private Hero secplayer;
	
	
	public GameController(){
			view=new GameView(this);
			
			//model=new Game(firstplayer,secplayer);
	}
		
	
	public static void main (String[] args){
	
		
		
	}


	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
