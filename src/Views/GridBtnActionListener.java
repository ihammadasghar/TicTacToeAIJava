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
        System.out.println("PlayerNum1 "+GUI.state.currentPlayerNum);
        clickedBtn.setUI(new MetalButtonUI(){
            protected Color getDisabledTextColor(){
                    return Color.decode(GUI.state.players[GUI.state.currentPlayerNum].color);
            }
        });
        clickedBtn.setText(String.valueOf(GUI.state.players[GUI.state.currentPlayerNum].symbol));
        clickedBtn.setEnabled(false);

        // backend update
        PlayerController.makeMove(row, col, GUI.state);

        // frontend score update
        GUI.inPlayFrame.scorePanel.updateCurrentPlayerScore();


        GUI.inPlayFrame.scorePanel.unsetPlayer(GUI.state.currentPlayerNum);
        int nextPlayerIndex = PlayerController.getNextPlayerIndex(GUI.state);
        GUI.state.currentPlayerNum = nextPlayerIndex;
        System.out.println("PlayerNum2 "+GUI.state.currentPlayerNum+"\n");
        GUI.inPlayFrame.scorePanel.setCurrentPlayer(nextPlayerIndex);
    }
}
