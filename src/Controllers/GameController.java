package Controllers;

import Models.Game;
import Models.Player;

import java.util.ArrayList;

public class GameController {
    public static Game getGameState(String type, int win, int gridSize, ArrayList<Player> players) {
        return new Game(type, win, gridSize, players);
    }
    public static void updateScore(){}
    public static void changeTurn(){}
}
