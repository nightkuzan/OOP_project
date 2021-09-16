package bigtuugame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
public class Display extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(1280,720);
		
	public Display() {
		this.homePage();
		//this.setting();
		this.getContentPane().add(new Game());
	}
	public Display(boolean status) {
		this.setting();
		this.getContentPane().add(new Game());
	}
	private void homePage() {
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
	}
	private void setting() {
		this.setTitle("KonDue Run!!"); //setTitle("KonDue Run!!")
		this.setSize(size);
        this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(280,100);
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
	}



}
