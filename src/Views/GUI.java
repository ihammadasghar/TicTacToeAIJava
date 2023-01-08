package Views;

import Controllers.GameController;
import Controllers.PlayerController;
import Models.Game;
import Models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {

    static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int SETUP_X_POSITION = (int) (size.getWidth()) / 4;
    public static final int SETUP_Y_POSITION = (int) (size.getHeight()) / 100;

    public static final int GAME_X_POSITION = (int) (size.getWidth()) / 7;
    public static final int GAME_Y_POSITION = (int) (size.getHeight()) / 100;

    public static final int END_X_POSITION = (int) (size.getWidth()) / 3;
    public static final int END_Y_POSITION = (int) (size.getHeight()) / 5;
    public static final int FRAME_HEIGHT_INPLAY = 800;
    public static final int FRAME_WIDTH_INPLAY = 1200;

    public static final int FRAME_HEIGHT_SETUP = 800;
    public static final int FRAME_WIDTH_SETUP = 800;

    public static final int FRAME_HEIGHT_GAMEOVER = 400;
    public static final int FRAME_WIDTH_GAMEOVER = 600;
    public static final String[] playerTypes = {"Human", "Smart AI", "AI"};
    public static final char[] playerSymbols = {'O', 'X', '$', 'I'};
    public static final String[] gameTypeOptions = {"Normal", "Misère", "Random turn"};

    public static final String[] playerColors = {/*green*/"#4E9F3D", /*red*/"#950101", /*blue*/"#6E85B2", /*yellow*/"#FFC133"};
    public static Game state;
    public static Border grayline = BorderFactory.createEtchedBorder();
    public static SetupFrame setupFrame;
    public static InPlayFrame inPlayFrame;
    public static GameOverFrame gameOverFrame;

    //Fonts
    public static final Font setupPanelTitleFont = new Font("Monospace", Font.PLAIN, 40);
    public static final Font gridSymFont = new Font("Dialog", Font.BOLD, 25);
    public static final Font typeFont = new Font("Dialog", Font.PLAIN, 25);
    public static final Font valueFont = new Font("Dialog", Font.PLAIN, 70);
    public static final Font grid_winFont = new Font("Dialog", Font.PLAIN, 20);
    public static final Font gridSidesFont = new Font("Monospace", Font.PLAIN, 30);
    public static final Font startFont = new Font("Dialog", Font.BOLD, 30);

    public static void startGUI() {
        setupFrame = new SetupFrame();
    }

    public static void startGame(boolean recreatePlayers) {
        Player[] players = state != null ? state.players : null;
        if (recreatePlayers) {
            players = PlayerController.getPlayerList(setupFrame.playersSetupPanel, playerSymbols);
        } else {
            for (Player p : players) {
                p.currentGameScore = 0;
            }
        }

        String gameType = "no type";

        for (int i = 0; i < gameTypeOptions.length; i++) {
            if (setupFrame.optionsPanel.optionRadioBtns[i].isSelected()) {
                gameType = setupFrame.optionsPanel.optionRadioBtns[i].getText();
                break;
            }
        }

        state = GameController.getGameState(gameType, setupFrame.sizePanel.winNum, setupFrame.sizePanel.gridSize, players);

        setupFrame.dispose();
        inPlayFrame = new InPlayFrame();
        SwingUtilities.invokeLater(PlayerController::playMoveIfAI);
    }

    public static void restartGame() {
        inPlayFrame.dispose();
        gameOverFrame.dispose();
        startGame(false);
    }

    public static void gameOver() {
        gameOverFrame = new GameOverFrame();
    }

    public static void cancelGame() {
        inPlayFrame.dispose();
        startGUI();
    }

    public static void endGame() {
        inPlayFrame.dispose();
        gameOverFrame.dispose();
        startGUI();
    }

}
