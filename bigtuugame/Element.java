package bigtuugame;

import java.awt.Font;
import java.io.File;
public class Element {
    public static Font getFont(int size){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT,new File("font/Mali-Bold.ttf"));
			// font = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("font/Mali-Bold.ttf"));
			return font.deriveFont((float)size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;
	}
}
