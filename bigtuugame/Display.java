package bigtuugame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
public class Display extends JFrame {
    public Display() {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        this.getContentPane().add(new Game());
    }

    public static void main(String[] args) {
        Display display = new Display();
    }

}
