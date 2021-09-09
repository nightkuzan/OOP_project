package bigtuugame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Background {
    public BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("img/112.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
	}
    public BufferedImage getImageBarrier() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("img/ba1.png"));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
	}
}
