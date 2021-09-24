package bigtuugame;


public class Event {
    static Game game = new Game();
    public static boolean hitCheck(CharOne char1, Barrier barrier) {

        return  (char1.y + char1.char1Size >= game.getBarY()-game.getBarHeight()+70)&&(char1.x + char1.char1Size -70> barrier.x && char1.x < barrier.x);  //check character hit the barrier
    }
}
