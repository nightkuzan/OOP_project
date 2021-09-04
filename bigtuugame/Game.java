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
    private static final long serialVersionUID = 1L;
    int gamespeed = 25;

    CharOne char1 = new CharOne(100, 300, 120, 100,0);
    // Barrier barrier = new Barrier(900, 300, 40, 70, 25,this);
    Barrier[] barrierset = buildbarrier(6);

    public Game() {
        this.setBounds(0, 0, 1280, 720);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            // this.drawBG(g2);
            // Point
            // g2.setFont(Element.getFont(30));

            g2.setColor(Color.BLACK);
            drawchar1health(g2);
            g2.setStroke(new BasicStroke(0.0f));
            g2.drawString("Score: "+char1.point,1100,40);
            g2.setColor(Color.RED);
            g2.drawImage(char1.getImage(),char1.x, char1.y,
                    char1.char1Size,char1.char1Size,null);
            // g2.drawRect(char1.x, char1.y, char1.char1Size, char1.char1Size);
            g2.setColor(Color.BLACK);
            g2.drawString("HP " + char1.char1health + "%", 40, 40);
            for (Barrier barrier : barrierset) {
                char1.point+=1;
                g2.drawRect(barrier.x, barrier.y, barrier.width, barrier.height);
                if (Event.hitCheck(char1, barrier) && !barrier.getisHit()) {
                    barrier.setisHit();
                    // g2.setColor(Color.RED);
                    // g2.drawRect(0, 0, 1000, 800);
                    char1.char1health -= 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // private void drawBG(Graphics2D g2)throws IOException{
    // g2.drawImage(ImageIO.read(new File("img\\name")),0,0,2000,1000,null)
    // g2.drawImage()
    // }

    private void drawchar1health(Graphics2D g2){
        try{
            g2.setStroke(new BasicStroke(5.0f));
            g2.setColor(Color.RED);
            g2.drawRect(100,20,200,35);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Barrier[] buildbarrier(int barriernumber) {
        Barrier[] barrierset = new Barrier[barriernumber];
        double locatePadding = 0.0;
        for (int i = 0; i < barriernumber; i++) {
            double barrierlocate = 1750 + Math.floor(Math.random() * 200) + locatePadding;
            double barrierheight = (40 + Math.floor(Math.random() * 50));
            double flexy = 420-(barrierheight);
            barrierset[i] = new Barrier((int) barrierlocate, (int)flexy, 30,(int) barrierheight, gamespeed,this);
           
            locatePadding += 500;
        }
        return barrierset;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32 || e.getKeyCode() == 38 || e.getKeyCode() == 87) {
        char1.jump(this);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
