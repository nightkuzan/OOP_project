package bigtuugame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Game extends JPanel implements KeyListener {
    int gamespeed = 35;
    long point = 0;
    static Display display;
    static Homepage homepage;
    CharOne char1;
    int a = 200;
    Background background = new Background();

    Barrier[] barrierset = buildbarrier(4);

    public Game() { // Set inner Display
        this.setBounds(0, 0, 1280, 720);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);

        char1 = new CharOne(this, 100,420, 120, 100, 0); // set the character
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            // Point
            g2.drawImage(background.getImage(), 0, 0, 1280, 720, null); // Set Background

            g2.setColor(Color.BLACK);
            drawchar1health(g2); // call method for draw health
            g2.setStroke(new BasicStroke(0.0f)); // make the edge thickness
            g2.drawString("Score: " + this.point, 1100, 40); // write Score and set x, y point
            g2.setColor(Color.RED);

            g2.drawImage(char1.getImage(), char1.x, char1.y, 100, 120, null); // Set Character Image
            g2.setColor(Color.BLACK);
            g2.drawString("HP " + char1.char1health + "%", 40, 40); // write Hp and set x, y axis

            for (Barrier barrier : barrierset) { // loop for build barrier
                this.point += 1; // make point increase
                g2.drawImage(background.getImageBarrier(), barrier.x, barrier.y, barrier.width, barrier.height, null); // set
                if (Event.hitCheck(char1, barrier) && !barrier.getisHit()) {
                    barrier.setisHit(); // check hit
                    double rh = 0;
                    rh = (3 + Math.floor(Math.random() * 8));
                    char1.char1health -= rh; // decrease hp if character hit the barrier
                    a -= (rh * 2);
                    if (char1.char1health <= 0) { // check health = 0 will die and go to ask for play again
                        homepage.clear(point);
                        char1.char1health = new CharOne().char1health;
                        this.point = 0;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void drawchar1health(Graphics2D g2) {
        try {
            g2.setColor(Color.RED);
            g2.fillRect(100, 20, a, 25);
            g2.setColor(Color.BLACK);
            g2.drawRect(100, 20, 200, 25);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    double barrierheight,flexy;
    public Barrier[] buildbarrier(int barriernumber) {
        Barrier[] barrierset = new Barrier[barriernumber];
        double locatePadding = 0.0;
        for (int i = 0; i < barriernumber; i++) {
            double barrierlocate = 1750 + Math.floor(Math.random() * 200) + locatePadding; // random x-axis for barrier
            barrierheight = (70 + Math.floor(Math.random() * 50)); // random y-axis for barrier
            flexy = 555 - (int) barrierheight;
            barrierset[i] = new Barrier((int) barrierlocate, (int) flexy, 80, (int) barrierheight, gamespeed, this);
            // build barrier

            locatePadding += 1000;
        }
        return barrierset;
    }

    public double getBarHeight() {
        return barrierheight;
    }

    public double getBarY() {
        return flexy;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {// check if pressed key w spacebar or up arrow
        if (e.getKeyCode() == 32 || e.getKeyCode() == 38 || e.getKeyCode() == 87) {
            char1.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        homepage = new Homepage();

    }
}
