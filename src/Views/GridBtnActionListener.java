package Views;

import Controllers.PlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBtnActionListener implements ActionListener {
    int col, row;

    public GridBtnActionListener(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();
        clickedBtn.setText(String.valueOf(GUI.state.currentPlayer.symbol));

        PlayerController.makeMove(GUI.state.currentPlayer, row, col, GUI.state);

        int currentPlayerIndex = GUI.state.players.indexOf(GUI.state.currentPlayer);
        GUI.inPlayFrame.scorePanel.unsetPlayer(currentPlayerIndex);

        int nextPlayerIndex = PlayerController.getNextPlayerIndex(GUI.state);
        GUI.state.currentPlayer = GUI.state.players.get(nextPlayerIndex);

        GUI.inPlayFrame.scorePanel.setCurrentPlayer(nextPlayerIndex);

        clickedBtn.setEnabled(false);
    }
}
