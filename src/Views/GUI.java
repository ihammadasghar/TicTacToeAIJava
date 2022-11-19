package Views;

import Controllers.GameController;
import Models.Game;
import Models.Player;

import java.util.ArrayList;

public class GUI {
    public static final int FRAME_HEIGHT = 500;
    public static final int FRAME_WIDTH = 500;
    public static Game state;

    public static void startGame() {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("WallE", "ROBOT", 'X'));
        state = GameController.startGame("something", 2, 5, players);
        new InPlayFrame();
    }
}
