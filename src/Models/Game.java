package Models;

import java.util.ArrayList;

public class Game{
    public String type;
    public int gridSize;
    public int win;
    public ArrayList<Player> players;

    public Game(String type, int win, int gridSize, ArrayList<Player> players){
        this.type = type;
        this.win = win;
        this.gridSize = gridSize;
        this.players = players;
    }

}