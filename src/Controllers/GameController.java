package Controllers;

import Models.Game;
import Models.Player;
import Views.GUI;

public class GameController {
    public static Game getGameState(String type, int win, int gridSize, Player[] players) {
        return new Game(type, win, gridSize, players);
    }

    public static void updateScore() {
    }

    public static void changeTurn() {
    }

    public static int calculatePlayerScore(int playerNum, int[][] grid, int win) {
        int s = getRowsScore(playerNum, grid, win) + getColsScore(playerNum, grid, win) + getDiag1Score(playerNum, grid, win) + getDiag2Score(playerNum, grid, win);
        return GUI.state.type.equals("Misère") ? -s : s;
    }

    private static int getColsScore(int playerNum, int[][] grid, int win) {
        int score = 0;
        for (int row = 0; row < grid.length; row++) {
            int count = 0;
            for (int col = 0; col < grid.length; col++) {
                count = playerNum != grid[row][col] ? 0 : count + 1;

                if (count == win) {
                    score++;
                    count--;
                }
            }
        }
        return score;
    }

    public static int getRowsScore(int playerNum, int[][] grid, int win) {
        int score = 0;
        for (int col = 0; col < grid.length; col++) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                count = playerNum != grid[row][col] ? 0 : count + 1;

                if (count == win) {
                    score++;
                    count--;
                }
            }
        }
        return score;
    }

    public static int getDiag1Score(int playerNum, int[][] grid, int win) {
        int score = 0;
        for (int i = 0; i < grid.length - win + 1; i++) {
            for (int j = 0; j < grid.length - win + 1; j++) {
                int count = 0;
                for (int inc = 0; inc < win; inc++) {
                    if (playerNum == grid[i + inc][j + inc]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == win) score++;
            }
        }
        return score;
    }

    public static int getDiag2Score(int playerNum, int[][] grid, int win) {
        int score = 0;
        for (int i = 0; i < grid.length - win + 1; i++) {
            for (int j = win - 1; j < grid.length; j++) {
                int count = 0;
                for (int inc = 0; inc < win; inc++) {
                    if (playerNum == grid[i + inc][j - inc]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == win) score++;
            }
        }
        return score;
    }
}
