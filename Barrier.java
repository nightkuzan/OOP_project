package gaming.bigtuugame.game;

import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Barrier {
    public int x, y, width, height, speed;
    private int xStart;
    private boolean isHit = false;

    public Barrier(int x, int y, int w, int h, int speed, JPanel game) {
        this.x = x;
        this.xStart = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.speed = speed;
        Move(game);
    }

    public void Move(JPanel game) {
        Timer time = new Timer(24, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                x -= speed;
                game.repaint();
                if (x < 0){
                    x = xStart;
                    resetisHit();
                }
            }
        });
        time.start();
    }

    public void setisHit(){
        this.isHit = true;
    }
    public void resetisHit(){
        this.isHit = false;
    }

    public boolean getisHit() {
        return isHit;
    }

    public int getx(){
        return x;
    }
}
