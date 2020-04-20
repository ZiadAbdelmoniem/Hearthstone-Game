package engine;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GameView extends JFrame implements GameListener {
	private JPanel title;
	private JLabel theplayer;
	private JPanel player1;
	private JTextArea text1;
	public GameView(GameController c){
		super();
		this.setBounds(400, 400, 400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JPanel p = new JPanel();
	    //JLabel t = new JLabel("Player one");
	    //t.setFont(new Font("Verdana",1,20));
	    //p.add(t);
	    //p.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
		//this.add(p);
		player1=new JPanel();
		player1.setPreferredSize(new Dimension(100,100));
		this.add(BorderLayout.NORTH,player1);
		theplayer=new JLabel("PLAYER 1 CHOOSE YOUR HERO TO START THE ADVENTURE!");
		player1.add(theplayer);
		title= new JPanel();
		title.setPreferredSize(new Dimension(100,100));
	    title.setLayout(new GridLayout(1,5));
		JButton mage= new JButton("Mage");
		mage.addActionListener(c);
		mage.setBounds(100, 100, 100, 100);
		mage.setActionCommand("chose mage 1");
		JButton priest= new JButton("Priest");
		priest.setBounds(100, 100, 100, 100);
		JButton hunter= new JButton("Hunter");
		hunter.setBounds(100, 100, 100, 100);
		JButton paladin= new JButton("Paladin");
		paladin.setBounds(100, 100, 100, 100);
		JButton warlock= new JButton("Warlock");
		warlock.setBounds(100, 100, 100, 100);
		title.add(mage);
		title.add(priest);
		title.add(hunter);
		title.add(paladin);
		title.add(warlock);
		this.add(BorderLayout.SOUTH,title);
		this.revalidate();
		this.repaint();
		//this.getContentPane().add(BorderLayout.CENTER,mage)
		//maybe use this to control heteb2a feen el buttons
		// this mainly says en awel ma el le3ba hetefta7 di awel 7aga heyshofoha 
	}
	
	public JPanel gettitle() {
		return title;
	}

	public void setTitle(JPanel title) {
		this.title = title;
	}

	public JLabel getTheplayer() {
		return theplayer;
	}

	public void setTheplayer(JLabel theplayer) {
		this.theplayer = theplayer;
	}

	public JPanel getPlayer1() {
		return player1;
	}

	public void setPlayer1(JPanel player1) {
		this.player1 = player1;
	}

	public JTextArea getText1() {
		return text1;
	}

	public void setText1(JTextArea text1) {
		this.text1 = text1;
	}

	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
	}
		public static void main (String [] args){
			GameView v = new GameView();
		}
	
}
