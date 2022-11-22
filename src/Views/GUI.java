package Views;

import Controllers.GameController;
import Models.Game;
import Models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    public static final int FRAME_HEIGHT = 400;
    public static final int FRAME_WIDTH = 400;
    public static Game state;
    public static Border blackline = BorderFactory.createLineBorder(Color.black);

    public static void startGame() {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("WallE", "ROBOT", 'X'));

        state = GameController.startGame("something", 2, 5, players);
        new SetupFrame();
    }
}
