package Controllers;

import java.util.concurrent.ThreadLocalRandom;

import Models.AIPlayer;
import Models.Player;
import Models.Game;
import Views.GUI;
import Views.PlayersSetupPanel;

import java.awt.*;

public class PlayerController {
    public static Player[] getPlayerList(PlayersSetupPanel panel, char[] playerChars) {
        Player[] players = new Player[panel.numOfPlayers];

        for (int i = 0; i < panel.numOfPlayers; i++) {
            boolean isAI = (String) panel.playerTypeComboBoxes[i].getSelectedItem() == "AI";
            if (isAI) {
                Player ai = new AIPlayer("Player " + (i + 1) + (" (AI)"), playerChars[i]);
                players[i] = ai;
            } else {
                players[i] = new Player("Player " + (i + 1), playerChars[i]);
            }

        }
        return players;
    }

    public static void makeMove(int row, int col, Game game) {
        game.grid[row][col] = game.currentPlayerNum;
        int score = game.calculatePlayerScore(game.currentPlayerNum);
        game.players[game.currentPlayerNum].currentGameScore = game.type == "Misère" ? -score : score;
    }

    public static int getNextPlayerIndex(Game game) {
        int nextPlayerIndex = game.type == "Random turn" ? ThreadLocalRandom.current().nextInt(0, GUI.state.players.length) : (game.currentPlayerNum + 1) % game.players.length;
        return nextPlayerIndex;
    }
}
