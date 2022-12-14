package Controllers;

import Models.AIPlayer;
import Models.Player;
import Models.Game;
import Views.GUI;
import Views.PlayersSetupPanel;

import java.util.ArrayList;

public class PlayerController {
    public static ArrayList<Player> getPlayerList(PlayersSetupPanel panel, char[] playerChars) {
        ArrayList<Player> players = new ArrayList<Player>();

        for (int i = 0; i < panel.numOfPlayers; i++) {
            boolean isAI = (String) panel.playerTypeComboBoxes[i].getSelectedItem() == "AI";
            if (isAI) {
                Player ai = new AIPlayer("Player " + (i + 1), playerChars[i]);
                players.add(ai);
            } else {
                players.add(new Player("Player " + (i + 1), playerChars[i]));
            }

        }
        return players;
    }

    public static void makeMove(Player player, int row, int col, Game game) {
        int i = game.players.indexOf(player);
        game.grid[row][col] = i;
    }

    public static int getNextPlayerIndex(Game game) {
        return (game.players.indexOf(game.currentPlayer) + 1) % game.players.size();
    }
}
