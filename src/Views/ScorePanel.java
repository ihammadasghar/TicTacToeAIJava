package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScorePanel extends JPanel implements ActionListener {


    public static JRadioButton[] currentPlayerBtns = new JRadioButton[GUI.state.players.length];
    public static JLabel[] playerScoreLabels = new JLabel[GUI.state.players.length];


    public ScorePanel() {
        this.setSize(GUI.FRAME_WIDTH_INPLAY, GUI.FRAME_HEIGHT_INPLAY);
        this.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel currentPlayer = new JLabel("Current Player", SwingConstants.CENTER);
        JLabel score = new JLabel("Score", SwingConstants.CENTER);
        add(currentPlayer);
        add(score);
        currentPlayer.setBorder(GUI.grayline);
        score.setBorder(GUI.grayline);
        currentPlayer.setBorder(BorderFactory.createEtchedBorder());
        currentPlayer.setBackground(Color.white);
        score.setBorder(BorderFactory.createEtchedBorder());
        score.setBackground(Color.white);



        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < GUI.state.players.length; i++) {
            currentPlayerBtns[i] = new JRadioButton("[" + GUI.state.players[i].symbol + "] " + GUI.state.players[i].name);
            currentPlayerBtns[i].addActionListener(this);
            currentPlayerBtns[i].setForeground((Color.decode(GUI.playerColors[i])));
            currentPlayerBtns[i].setEnabled(false);


            playerScoreLabels[i] = new JLabel("" + GUI.state.players[i].currentGameScore, SwingConstants.CENTER);
            if (i == 0) {
                playerScoreLabels[i].setForeground(Color.decode("#4E9F3D"));
            }
            if (i == 1) {
                playerScoreLabels[i].setForeground(Color.decode("#950101"));
            }
            if (i == 2) {
                playerScoreLabels[i].setForeground(Color.decode("#6E85B2"));
            }
            if (i == 3) {
                playerScoreLabels[i].setForeground(Color.decode("#FFD369"));
            }

            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEtchedBorder());
            panel.setBackground(Color.white);
            group.add(currentPlayerBtns[i]);
            this.add(currentPlayerBtns[i]);
            panel.add(playerScoreLabels[i]);
            this.add(panel);



        }
        currentPlayerBtns[0].setEnabled(true);
        currentPlayerBtns[0].setSelected(true);

    }


    public void setCurrentPlayer(int i) {
        currentPlayerBtns[i].setSelected(true);
        currentPlayerBtns[i].setEnabled(true);
    }

    public void unsetPlayer(int i) {
        currentPlayerBtns[i].setSelected(false);
        currentPlayerBtns[i].setEnabled(false);
    }

    public void updateCurrentPlayerScore() {
        playerScoreLabels[GUI.state.currentPlayerNum].setText("" + GUI.state.players[GUI.state.currentPlayerNum].currentGameScore);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}