package gaming.bigtuugame.game;

public class Event {
    public static boolean hitCheck(CharOne char1, Barrier barrier) {

        return  (char1.y + char1.char1Size >= barrier.y - barrier.height)&&(char1.x + char1.char1Size > barrier.x && char1.x < barrier.x);
    }
}
