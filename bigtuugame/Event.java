package bigtuugame;


public class Event {
    public static boolean hitCheck(CharOne char1, Barrier barrier) {

        return  (char1.y + char1.char1Size -40>= barrier.y - barrier.height)&&(char1.x + char1.char1Size -40> barrier.x && char1.x < barrier.x);
    }
}
