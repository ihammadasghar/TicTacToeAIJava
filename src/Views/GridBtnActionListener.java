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

        int nextPlayerIndex = PlayerController.getNextPlayerIndex(GUI.state);
        GUI.state.currentPlayer = GUI.state.players.get(nextPlayerIndex);

        GUI.inPlayFrame.scorePanel.setCurrentPlayer(nextPlayerIndex);
        for(int i=0;i< GUI.inPlayFrame.scorePanel.currentPlayerBtns.length; i++){
            if (i== nextPlayerIndex){
                GUI.inPlayFrame.scorePanel.currentPlayerBtns[nextPlayerIndex].setEnabled(true);
            }
            GUI.inPlayFrame.scorePanel.currentPlayerBtns[i].setEnabled(false);
        }

        clickedBtn.setEnabled(false);
    }
}
