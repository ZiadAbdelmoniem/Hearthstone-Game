package engine;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class opponentPanel extends JPanel{
	private JLabel hp;
	private JLabel nameofhero;
	private JLabel manano;
	private JLabel deck;
	
public opponentPanel(GameController c,Game g){
	super();
	this.setLayout(new GridLayout(1,4));
	hp=new JLabel("hp" +Integer.toString(g.getOpponent().getCurrentHP()));
	this.add(hp);
	nameofhero=new JLabel(g.getOpponent().getName());
	this.add(nameofhero);
	manano=new JLabel("mana:"+Integer.toString(g.getOpponent().getCurrentManaCrystals()));
	this.add(manano);
	deck=new JLabel("Cards in deck" + Integer.toString(g.getOpponent().getDeck().size()));
	this.add(deck);
	this.revalidate();
	this.repaint();
	
}

public JLabel getHp() {
	return hp;
}

public void setHp(JLabel hp) {
	this.hp = hp;
}

public JLabel getNameofhero() {
	return nameofhero;
}

public void setNameofhero(JLabel nameofhero) {
	this.nameofhero = nameofhero;
}

public JLabel getManano() {
	return manano;
}

public void setManano(JLabel manano) {
	this.manano = manano;
}

public JLabel getDeck() {
	return deck;
}

public void setDeck(JLabel deck) {
	this.deck = deck;
}


}
