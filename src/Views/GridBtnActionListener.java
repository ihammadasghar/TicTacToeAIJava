package Views;

import Controllers.PlayerController;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBtnActionListener implements ActionListener {
    int col, row;

    public GridBtnActionListener(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void actionPerformed(ActionEvent e) {
        // set symbol
        JButton clickedBtn = (JButton) e.getSource();

        int currentPlayerNum = GUI.state.currentPlayerNum;
        clickedBtn.setText(String.valueOf(GUI.state.players[currentPlayerNum].symbol));
        clickedBtn.setEnabled(false);
        clickedBtn.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return Color.decode(GUI.playerColors[currentPlayerNum]);
            }
        });

        // backend update
        PlayerController.makeMove(row, col, GUI.state);

        // frontend score update
        GUI.inPlayFrame.scorePanel.updateCurrentPlayerScore();

        GUI.inPlayFrame.scorePanel.unsetPlayer(GUI.state.currentPlayerNum);
        int nextPlayerIndex = PlayerController.getNextPlayerIndex(GUI.state);
        GUI.state.currentPlayerNum = nextPlayerIndex;
        GUI.inPlayFrame.scorePanel.setCurrentPlayer(nextPlayerIndex);
    }
}
