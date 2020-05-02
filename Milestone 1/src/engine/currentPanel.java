package engine;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class currentPanel extends JPanel{
	private JLabel hp;
	private JButton heropower;
	private JLabel nameofhero;
	private JLabel manano;
	private JLabel deck;
	private JButton endturn;
	
public currentPanel(GameController c,Game g){
	super();
	this.setLayout(new GridLayout(1,6));
	hp=new JLabel("hp" +Integer.toString(g.getCurrentHero().getCurrentHP()));
	this.add(hp);
	heropower=new JButton("Hero POWER!!");
	heropower.setActionCommand("current hero used herpower");
	heropower.addActionListener(c);
	this.add(heropower);
	nameofhero=new JLabel(g.getCurrentHero().getName());
	this.add(nameofhero);
	manano=new JLabel("mana:"+Integer.toString(g.getCurrentHero().getCurrentManaCrystals()));
	this.add(manano);
	deck=new JLabel("Cards in deck" + Integer.toString(g.getCurrentHero().getDeck().size()));
	this.add(deck);
	endturn=new JButton("click if you want to end you turn");
	endturn.addActionListener(c);
	endturn.setActionCommand("turn ended");
	this.add(endturn);
	this.revalidate();
	this.repaint();
	
	

}

public JLabel getHp() {
	return hp;
}

public void setHp(JLabel hp) {
	this.hp = hp;
}

public JButton getHeropower() {
	return heropower;
}

public void setHeropower(JButton heropower) {
	this.heropower = heropower;
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

public JButton getEndturn() {
	return endturn;
}

public void setEndturn(JButton endturn) {
	this.endturn = endturn;
}	

}
