package Controllers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import Models.Player;
import Models.Game;
import Views.GUI;
import Views.PlayersSetupPanel;

public class PlayerController {
    public static Player[] getPlayerList(PlayersSetupPanel panel, char[] playerChars) {
        Player[] players = new Player[panel.numOfPlayers];

        for (int i = 0; i < panel.numOfPlayers; i++) {
            String playerType = ((String) panel.playerTypeComboBoxes[i].getSelectedItem());
            boolean isAI = playerType.equals("AI") || playerType.equals("Smart AI");
            players[i] = new Player("Player " + (i + 1) + " (" + playerType + ")", playerChars[i], isAI);
        }
        return players;
    }

    public static void makeMove(int row, int col, Game game) {
        game.grid[row][col] = game.currentPlayerNum;
        game.players[game.currentPlayerNum].currentGameScore = GameController.calculatePlayerScore(game.currentPlayerNum, game.grid, game.win);
        game.movesMade++;
        game.lastMoveMade = new int[]{row, col};
    }

    public static void playMoveIfAI() {
        if (GUI.state.players[GUI.state.currentPlayerNum].isAI) {
            int[] move = PlayerController.getAIMove(GUI.state.currentPlayerNum, GUI.state);
            System.out.println("Move was: " + move[0] + " - " + move[1]);
            GUI.inPlayFrame.gridPanel.gridBtns[move[0]][move[1]].doClick(500);
        }
    }

    public static int getNextPlayerIndex(Game game) {
        return game.type.equals("Random turn") ? ThreadLocalRandom.current().nextInt(0, GUI.state.players.length) : (game.currentPlayerNum + 1) % game.players.length;
    }

    public static int[] getAIMove(int playerNum, Game game) {
        boolean isSmart = GUI.state.players[playerNum].name.contains("Smart");
        double gridSizeCut = isSmart ? (3.0 * ((double) game.gridSize / 10.0)) : 0;
        double initialDepth = isSmart ? 6 : 1;
        int depth = (int) (initialDepth - gridSizeCut + (initialDepth * ((double) game.movesMade / (double) (game.gridSize * game.gridSize))));

        System.out.println("Depth: " + depth);

        int[][] grid = deepCopy(game.grid);
        int bestOutcome = Integer.MAX_VALUE;
        ArrayList<int[]> availableMoves = getEmptySlotsCords(grid, GUI.state.players.length);
        int[] bestMove = availableMoves.get(0);

        double distanceToLastMove = 0;

        for (int[] m : availableMoves) {
            int outcome = minimax(m, grid, playerNum, playerNum, Integer.MIN_VALUE, Integer.MAX_VALUE, depth);
            System.out.println("Possible move was (" + outcome + "): " + m[0] + " - " + m[1]);

            if (outcome <= bestOutcome) {
                double dist = getDistanceBetweenMoves(m, game.lastMoveMade);
                if (bestOutcome == outcome && distanceToLastMove <= dist)
                    continue;
                bestOutcome = outcome;
                bestMove = m;
                distanceToLastMove = dist;
            }
        }

        return bestMove;
    }

    public static int minimax(int[] move, int[][] game, int playerNum, int minPlayerNum, int alpha, int beta, int depth) {
        int[][] grid = deepCopy(game);
        grid[move[0]][move[1]] = playerNum;

        if (depth == 0 || isGridFull(grid, GUI.state.players.length)) {
            int sumOfScores = 0;
            int pScore = 0;
            for (int i = 0; i < GUI.state.players.length; i++) {
                if (i == minPlayerNum) {
                    pScore = GameController.calculatePlayerScore(i, grid, GUI.state.win);
                } else {
                    sumOfScores += GameController.calculatePlayerScore(i, grid, GUI.state.win);
                }
            }
            return sumOfScores - pScore;
        }

        if (playerNum == minPlayerNum) {
            int maxState = Integer.MIN_VALUE;
            ArrayList<int[]> availableMoves = getEmptySlotsCords(grid, GUI.state.players.length);
            for (int[] m : availableMoves) {
                int gridState = minimax(m, grid, (playerNum + 1) % GUI.state.players.length, minPlayerNum, alpha, beta, depth - 1);
                maxState = Math.max(maxState, gridState);
                alpha = Math.max(alpha, maxState);

                if (beta <= alpha) break;
            }
            return maxState;

        } else {
            int minState = Integer.MAX_VALUE;
            ArrayList<int[]> availableMoves = getEmptySlotsCords(grid, GUI.state.players.length);
            for (int[] m : availableMoves) {
                int gridState = minimax(m, grid, (playerNum + 1) % GUI.state.players.length, minPlayerNum, alpha, beta, depth - 1);
                minState = Math.min(minState, gridState);
                beta = Math.min(beta, minState);

                if (beta <= alpha) break;
            }
            return minState;

        }
    }

    public static double getDistanceBetweenMoves(int[] move1, int[] move2) {
        return Math.sqrt((move2[0] - move1[0]) * (move2[0] - move1[0]) + (move2[1] - move1[1]) * (move2[1] - move1[1]));
    }

    public static ArrayList<int[]> getEmptySlotsCords(int[][] grid, int n) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == n) {
                    int[] cord = {i, j};
                    result.add(cord);
                }
            }
        }
        return result;
    }

    public static boolean isGridFull(int[][] grid, int playerNum) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (ints[j] == playerNum) return false;
            }
        }
        return true;
    }

    public static int[][] deepCopy(int[][] matrix) {
        return java.util.Arrays.stream(matrix).map(int[]::clone).toArray($ -> matrix.clone());
    }

}
