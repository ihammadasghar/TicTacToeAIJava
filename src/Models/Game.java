package Models;

import java.util.ArrayList;

public class Game {
    public String type;
    public int gridSize;
    public int win;
    public ArrayList<Player> players;
    public Player currentPlayer;
    public int[][] grid;

    public Game(String type, int win, int gridSize, ArrayList<Player> players) {
        this.type = type;
        this.win = win;
        this.gridSize = gridSize;
        this.grid = new int[gridSize][gridSize];
        this.players = players;
        currentPlayer = players.get(0);
    }

    public boolean isGameOver(int playerNum) {
        return (isInARow(playerNum) || isInACol(playerNum) || isInADiag1(playerNum) || isInADiag2(playerNum));
    }

    private boolean isInARow(int playerNum) {
        for (int row = 0; row < this.gridSize; row++) {
            int count = 0;
            for (int col = 0; col < this.gridSize; col++) {
                if (playerNum != this.grid[row][col]) {
                    count = 0;
                } else {
                    count++;
                }
                if (count == this.win) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInACol(int playerNum) {
        for (int col = 0; col < this.gridSize; col++) {
            int count = 0;
            for (int row = 0; row < this.gridSize; row++) {
                if (playerNum != this.grid[row][col]) {
                    count = 0;
                } else {
                    count++;
                }
                if (count == this.win) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInADiag1(int playerNum) {
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            if (playerNum != this.grid[i][i]) {
                count = 0;
            } else {
                count++;
            }
            if (count == this.win) {
                return true;
            }
        }
        return false;
    }

    private boolean isInADiag2(int playerNum) {
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            int col = this.gridSize - 1 - i;
            if (playerNum != this.grid[i][col]) {
                count = 0;
            } else {
                count++;
            }
            if (count == this.win) {
                return true;
            }
        }
        return false;
    }

}