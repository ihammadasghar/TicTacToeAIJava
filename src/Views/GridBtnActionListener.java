package Views;

import Controllers.GameController;
import Controllers.PlayerController;
import Models.Game;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBtnActionListener implements ActionListener {
    int col, row;

    public GridBtnActionListener(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public void actionPerformed(ActionEvent e) {
        makeMove(e);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PlayerController.playMoveIfAI();
            }
        });

    }

    public void makeMove(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();
        int[] lastMove = GUI.state.lastMoveMade;

        if(GUI.state.movesMade != 0){
            JButton lastPLay = GUI.inPlayFrame.gridPanel.gridBtns[lastMove[0]][lastMove[1]];
            lastPLay.setContentAreaFilled(false);
        }

        clickedBtn.setBackground(Color.yellow);
        int currentPlayerNum = GUI.state.currentPlayerNum;
        clickedBtn.setText(String.valueOf(GUI.state.players[currentPlayerNum].symbol));
        clickedBtn.setEnabled(false);
        clickedBtn.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.decode(GUI.playerColors[currentPlayerNum]);
            }
        });

        PlayerController.makeMove(row, col, GUI.state);

        GameController.changeTurn();

        if (PlayerController.isGridFull(GUI.state.grid, GUI.state.players.length)) {
            GUI.gameOver();
        }
    }
}
