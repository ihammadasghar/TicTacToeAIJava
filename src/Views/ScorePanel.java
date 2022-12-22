package Views;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.metal.MetalRadioButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel implements ActionListener {
    public static JRadioButton[] currentPlayerBtns = new JRadioButton[GUI.state.players.length];
    public JLabel[] playerScoreLabels = new JLabel[GUI.state.players.length];

    public ScorePanel() {
        this.setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        this.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel currentPlayer = new JLabel("Current Player");
        JLabel score = new JLabel("Score", SwingConstants.CENTER);
        add(currentPlayer);
        add(score);
        setBorder(GUI.blackline);

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < GUI.state.players.length; i++) {
            currentPlayerBtns[i] = new JRadioButton("" + GUI.state.players[i].name);
            currentPlayerBtns[i].addActionListener(this);
            currentPlayerBtns[i].setForeground((Color.decode(GUI.playerColors[i])));
            currentPlayerBtns[i].setEnabled(false);
            currentPlayerBtns[i].setUI(new MetalRadioButtonUI(){
                protected Color getDisabledTextColor(){
                    return Color.decode(GUI.playerColors[GUI.state.currentPlayerNum]);
                }
            });
            playerScoreLabels[i] = new JLabel("" + GUI.state.players[i].currentGameScore, SwingConstants.CENTER);
            group.add(currentPlayerBtns[i]);
            this.add(currentPlayerBtns[i]);
            this.add(playerScoreLabels[i]);
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