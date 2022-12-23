package Views;

import Controllers.GameController;
import Controllers.PlayerController;
import Models.Game;
import Models.Grid;
import Models.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    public static final int FRAME_HEIGHT = 800;
    public static final int FRAME_WIDTH = 1200;
    public static final char[] playerSymbols = {'O', 'X', '$', 'I'};
    public static final String[] gameTypeOptions = {"Normal", "Misère", "Random turn"};

    public static final String[] playerColors = {/*green*/"#4E9F3D", /*red*/"#950101", /*blue*/"#6E85B2", /*yellow*/"#FFD369"};
    public static Game state;
    public static Border blackline = BorderFactory.createLineBorder(Color.black);
    public static SetupFrame setupFrame;
    public static InPlayFrame inPlayFrame;

    //Fonts
    public static final Font displayFont = new Font("Monospace", Font.PLAIN, 40);
    public static final Font setupPanelTitleFont = new Font("Monospace", Font.PLAIN, 40);
    public static final Font gridSymFont = new Font("Dialog", Font.BOLD, 25);
    public static final Font gridSidesFont = new Font("Monospace", Font.PLAIN, 30);
    public static final Font startFont = new Font("Dialog", Font.BOLD, 30);

    public static void startGUI() {
        setupFrame = new SetupFrame();
    }

    public static void startGame() {
        setupFrame.dispose();

        Player[] players = PlayerController.getPlayerList(setupFrame.playersSetupPanel, playerSymbols);
        String gameType = "no type";
        for (int i = 0; i < gameTypeOptions.length; i++) {
            if (setupFrame.optionsPanel.optionRadioBtns[i].isSelected()) {
                gameType = setupFrame.optionsPanel.optionRadioBtns[i].getText();
                break;
            }
        }
        state = GameController.getGameState(gameType, setupFrame.sizePanel.winNum, Grid.gridSize, players);

        inPlayFrame = new InPlayFrame();
    }

    public static void endGame() {
        inPlayFrame.dispose();
        startGUI();
    }
}
