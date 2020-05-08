package engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUpp extends JFrame{
	
	public PopUpp(String s){
		super();
		JLabel b=new JLabel(s);
		b.setBounds(300, 300, 300, 300);
		b.setFont(new Font("Serif", Font.PLAIN, 22));
		this.setBounds(400,400,400,400);
		this.getContentPane().setBackground(Color.ORANGE);
		this.add(b);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	public PopUpp(String s,int x,GameController c){
		super();
		if(x==1){
		JLabel b=new JLabel(s);
		b.setFont(new Font("Serif", Font.PLAIN, 22));
		this.setBounds(400,400,400,400);
		this.getContentPane().setBackground(Color.CYAN);
		this.add(BorderLayout.NORTH,b);
		this.setLocationRelativeTo(null);
		JButton j=new JButton("click to Start a New Game");
		j.setActionCommand("new game");
		j.addActionListener(c);
		this.add(BorderLayout.SOUTH,j);
		this.setVisible(true);
		this.revalidate();
		this.repaint();
		
		}
		}

}
