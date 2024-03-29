package bigtuugame;

import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
public class Display extends JFrame implements ActionListener{
	private Dimension size = new Dimension(1280,720);
	
	public Display() {
		this.setting();
		this.getContentPane().add(new Game());
	}
	public void setting() {
		this.setTitle("KonDue Run!!"); //setTitle("KonDue Run!!")
		this.setSize(size);
        this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocation(280,100);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	 
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}
	
	public void endGame(long point) {
		removeContent();
		this.getContentPane().add(new Menu(point,this));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("restart")) {
			removeContent();
			Game game = new Game();
			this.getContentPane().add(game);
			game.requestFocus();

		}
		else if(e.getActionCommand().equals("home")) {
			removeContent();
			dispose();
			Homepage homepage = new Homepage();
		}
	}



}
