package gaming.bigtuugame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CharOne {
    public long jumpPress = 0;
    public int countJump = 0;
    public boolean jumpExceeded = false;
    public int x, y, char1Size, char1health,point;
    private int jumpHight = 150;

    public CharOne() {

    }

    public CharOne(int x, int y, int char1Size, int char1health, int point) {
        this.x = x;
        this.y = y;
        this.char1Size = char1Size;
        this.char1health = char1health;
        this.point = point;
    }

    public void jump(JPanel game) {
        if (!jumpExceeded) {
            this.y -= jumpHight;
            Timer time = new Timer(350, (ActionListener) new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    y += jumpHight;
                    game.repaint();
                    --countJump;
                    if (countJump == 0){
                        jumpExceeded = false;
                    } 
                }
            });
            game.repaint();
            jumpPress = System.currentTimeMillis();
            countJump++;
            if (countJump == 2) {
                jumpExceeded = true;
            }
            time.setRepeats(false);
            time.start();
        } 
    }



    public BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("img/char1.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
	}

}
