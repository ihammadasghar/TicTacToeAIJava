package Models;

public class Game {
    public String type;
    public int gridSize;
    public int win;
    public Player[] players;
    public int currentPlayerNum;
    public int[][] grid;
    public int movesMade = 0;
    public int[] lastMoveMade = new int[2];

    public Game(String type, int win, int gridSize, Player[] players) {
        this.type = type;
        this.win = win;
        this.gridSize = gridSize;
        this.grid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = players.length;
            }
        }
        this.players = players;
        currentPlayerNum = 0;
    }
}