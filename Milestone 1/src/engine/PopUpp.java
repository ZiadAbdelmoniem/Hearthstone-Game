package engine;

import java.awt.Color;
import java.awt.Font;

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

}
