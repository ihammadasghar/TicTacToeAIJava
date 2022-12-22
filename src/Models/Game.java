package Models;

public class Game {
    public String type;
    public int gridSize;
    public int win;
    public Player[] players;
    public int currentPlayerNum;
    public int[][] grid;

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

    public boolean isGameOver(int playerNum) {
        return false;
    }

    public void calculatePlayerScore(int playerNum) {
        players[playerNum].currentGameScore = 0;
        checkRows(playerNum);
        checkCols(playerNum);
        checkDiag1(playerNum);
        checkDiag2(playerNum);
    }

    private void checkCols(int playerNum) {
        for (int row = 0; row < this.gridSize; row++) {
            int count = 0;
            for (int col = 0; col < this.gridSize; col++) {
                count = playerNum != this.grid[row][col] ? 0 : count + 1;

                if (count == this.win) {
                    players[playerNum].currentGameScore++;
                    count--;
                }
            }
        }
    }

    private void checkRows(int playerNum) {
        for (int col = 0; col < this.gridSize; col++) {
            int count = 0;
            for (int row = 0; row < this.gridSize; row++) {
                count = playerNum != this.grid[row][col] ? 0 : count + 1;

                if (count == this.win) {
                    players[playerNum].currentGameScore++;
                    count--;
                }
            }
        }
    }

    private void checkDiag1(int playerNum) {
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            count = playerNum != this.grid[i][i] ? 0 : count + 1;

            if (count == this.win) {
                players[playerNum].currentGameScore++;
                count--;
            }
        }
    }

    private void checkDiag2(int playerNum) {
        int count = 0;
        for (int i = 0; i < this.gridSize; i++) {
            int col = this.gridSize - 1 - i;
            count = playerNum != this.grid[i][col] ? 0 : count + 1;

            if (count == this.win) {
                players[playerNum].currentGameScore++;
                count--;
            }
        }
    }
}