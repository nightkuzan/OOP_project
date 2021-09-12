package bigtuugame;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Menu extends JPanel {
    private static final long serialVersionUID = 1L;
    public long point;

    public Menu() {

    }

    public Menu(long point, ActionListener main) {
        try {
            this.point = point;
            this.setBackground(new Color(241, 9, 69));  //set background color
            this.setBounds(0, 0, 1280, 720); //set size background color
            this.setFocusable(true);
            this.setLayout(null);

            EleLabel status = new EleLabel("You Died!", 40, 610, 100, 200, 100); //write string and set x,y axis and width and height 
            status.setForeground(Color.white);

            EleLabel showPoint = new EleLabel("Total : " + this.point, 30, 610, 200, 200, 100);//write string and set x,y axis and width and height 
            showPoint.setForeground(Color.white);

            EleButton restart = new EleButton("restart", 15, 540, 300, 200, 50);//write string and set x,y axis and width and height 
            restart.addActionListener(main);

            this.add(showPoint);
            this.add(status);
            this.add(restart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
