package bigtuugame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CharOne {
    private JPanel game;
    private long jumpPress = 0;
    public long point=0;
    private int countJump = 0;
    private boolean jumpExceeded = false;
    public int x, y, char1Size, char1health;
    private int jumpHight = 110;

    public CharOne(){
        
    }
    private ActionListener timerAction = (ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timeHelper.stop();
                    y += jumpHight;
                    game.repaint();
                    if (--countJump == 0){
                        jumpExceeded = false;
                    } else if (countJump == 1) {
                        timeHelper.start();
                    }
                }
            };
    private Timer time = new Timer(350, timerAction);
    private Timer timeHelper = new Timer(175, timerAction);

    public CharOne(JPanel game) {
        time.setRepeats(false);
        this.game = game;
    }

    public CharOne(JPanel game, int x, int y, int char1Size, int char1health, long point) {
        this(game);
        this.x = x;
        this.y = y;
        this.char1Size = char1Size;
        this.char1health = char1health;
        this.point = point;
    }

    public void jump() {
        if (!jumpExceeded) {
            time.stop();

            this.y -= jumpHight;
            game.repaint();
            jumpPress = System.currentTimeMillis();
            if (++countJump == 2) {
                jumpExceeded = true;
            }

            time.start();
        } 
    }



    public BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("img/3934345.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
	}

}