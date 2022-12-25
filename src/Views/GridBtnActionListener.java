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

        PlayerController.makeMove(row, col, GUI.state);
        GameController.changeTurn();
        
        /* NOTE: Switch GameEndedFrame when Frame is made*/
        // if(GameController.isGameOver(GUI.state)) ;
    }
}
