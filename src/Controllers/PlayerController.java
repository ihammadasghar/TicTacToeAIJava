package Controllers;

import Models.Player;
import Views.PlayersSetupPanel;

import java.util.ArrayList;

public class PlayerController {
    public static ArrayList<Player> getPlayerList(PlayersSetupPanel panel) {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("WallE", "ROBOT", 'X'));
        players.add(new Player("Pablo", "ROBOT", 'O'));
        return players;
    }
}
