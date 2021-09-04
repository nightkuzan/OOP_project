package bigtuugame;


import java.awt.Color;
import javax.swing.JButton;
public class Ebutton extends JButton {
    private static final long serialVersionUID = 1L;

		public Ebutton(String title,int size,int x,int y,int width,int height) {
			super(title);
			this.setBackground(new Color(2, 117, 216));
			this.setForeground(Color.white);
			this.setFont(Element.getFont(size));
			this.setBounds(x, y, width, height);
		}
}
