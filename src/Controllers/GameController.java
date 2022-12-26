package Controllers;

import Models.Game;
import Models.Player;
import Views.GUI;

import javax.swing.*;

public class GameController {
    public static Game getGameState(String type, int win, int gridSize, Player[] players) {
        return new Game(type, win, gridSize, players);
    }

    public static boolean isGameOver(Game game) {
        return game.movesMade == (game.gridSize * game.gridSize);
    }

    public static void changeTurn() {
        GUI.inPlayFrame.scorePanel.updateCurrentPlayerScore();

        GUI.inPlayFrame.scorePanel.unsetPlayer(GUI.state.currentPlayerNum);

        int nextPlayerIndex = PlayerController.getNextPlayerIndex(GUI.state);

        GUI.state.currentPlayerNum = nextPlayerIndex;
        GUI.inPlayFrame.scorePanel.setCurrentPlayer(nextPlayerIndex);
    }
}
