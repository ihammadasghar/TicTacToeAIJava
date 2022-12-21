package Controllers;

import Models.Game;
import Models.Player;

public class GameController {
    public static Game getGameState(String type, int win, int gridSize, Player[] players) {
        return new Game(type, win, gridSize, players);
    }

    public static void updateScore() {
    }

    public static void changeTurn() {
    }
}
