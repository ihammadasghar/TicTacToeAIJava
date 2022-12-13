package Controllers;

import Models.AIPlayer;
import Models.Player;
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

    public static void makeMove() {

    }
}
