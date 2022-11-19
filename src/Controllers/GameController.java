package Controllers;

import Models.Game;
import Models.Player;

import java.util.ArrayList;

public class GameController {
    public static Game startGame(String type, int win, int gridSize, ArrayList<Player> players) {
        return new Game(type, win, gridSize, players);
    }
}
