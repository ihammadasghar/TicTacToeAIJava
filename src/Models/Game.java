package Models;

public class Game {
    public String type;
    public int gridSize;
    public int win;
    public Player[] players;
    public int currentPlayerNum;
    public int[][] grid;
    public int movesMade = 0;

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

    public int calculatePlayerScore(int playerNum) {
        return getRowsScore(playerNum) + getColsScore(playerNum) + getDiag1Score(playerNum) + getDiag2Score(playerNum);
    }

    private int getColsScore(int playerNum) {
        int score = 0;
        for (int row = 0; row < this.gridSize; row++) {
            int count = 0;
            for (int col = 0; col < this.gridSize; col++) {
                count = playerNum != this.grid[row][col] ? 0 : count + 1;

                if (count == this.win) {
                    score++;
                    count--;
                }
            }
        }
        return score;
    }

    private int getRowsScore(int playerNum) {
        int score = 0;
        for (int col = 0; col < this.gridSize; col++) {
            int count = 0;
            for (int row = 0; row < this.gridSize; row++) {
                count = playerNum != this.grid[row][col] ? 0 : count + 1;

                if (count == this.win) {
                    score++;
                    count--;
                }
            }
        }
        return score;
    }

    private int getDiag1Score(int playerNum) {
        int score = 0;
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            count = playerNum != this.grid[i][i] ? 0 : count + 1;

            if (count == this.win) {
                score++;
                count--;
            }
        }
        return score;
    }

    private int getDiag2Score(int playerNum) {
        int score = 0;
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            int col = this.gridSize - 1 - i;
            count = playerNum != this.grid[i][col] ? 0 : count + 1;

            if (count == this.win) {
                score++;
                count--;
            }
        }
        return score;
    }
}