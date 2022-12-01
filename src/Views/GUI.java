package Views;

import Controllers.GameController;
import Controllers.PlayerController;
import Models.Game;
import Models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    public static final int FRAME_HEIGHT = 800;
    public static final int FRAME_WIDTH = 800;
    public static Game state;
    public static Border blackline = BorderFactory.createLineBorder(Color.black);
    public static JFrame setupFrame;
    public static JFrame inPlayFrame;

    public static void startGUI() {
        setupFrame = new SetupFrame();
    }

    public static void startGame() {
        setupFrame.dispose();

        ArrayList<Player> players = PlayerController.getPlayerList(new PlayersSetupPanel());
        state = GameController.getGameState("something", 2, 5, players);

        inPlayFrame = new InPlayFrame();
    }

    public static void endGame(){
        inPlayFrame.dispose();
        startGUI();
    }
}
