package engine;
import java.awt.Color;

import javax.swing.*;

public class View extends JFrame {
	
	 public static void main(String[]args){
	    	JFrame mainframe=new JFrame("boody");
	    	mainframe.setVisible(true);
	    	mainframe.setBounds(200, 200, 200, 200);
	    	mainframe.getContentPane().setBackground(Color.MAGENTA);
	 }
}
