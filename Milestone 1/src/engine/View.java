package engine;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class View extends JFrame implements GameListener {
	public View(){
		super();
		this.setVisible(true);
		this.setBounds(800, 800, 800, 800);
		JPanel p = new JPanel();
	    JLabel t = new JLabel("Player one");
	    t.setFont(new Font("Verdana",1,20));
	    p.add(t);
	    p.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		this.add(p);
	    JButton mage= new JButton("Mage");
		JButton priest= new JButton("Priest");
		JButton hunter= new JButton("Hunter");
		JButton paladin= new JButton("Paladin");
		JButton warlock= new JButton("Warlock");
		this.add(mage);
		this.add(priest);
		this.add(hunter);
		this.add(paladin);
		this.add(warlock);
		//this.getContentPane().add(BorderLayout.CENTER,mage)
		//maybe use this to control heteb2a feen el buttons
		// this mainly says en awel ma el le3ba hetefta7 di awel 7aga heyshofoha 
	}
	
	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
	}
		
	
}
