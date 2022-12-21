package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel implements ActionListener {
    public JRadioButton[] currentPlayerBtns = new JRadioButton[GUI.state.players.size()];

    public ScorePanel() {
        this.setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        this.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel currentPlayer = new JLabel("Current Player");
        JLabel score = new JLabel("Score", SwingConstants.CENTER);
        add(currentPlayer);
        add(score);
        setBorder(GUI.blackline);

        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i < GUI.state.players.size(); i++) {
            currentPlayerBtns[i] = new JRadioButton("" + GUI.state.players.get(i).name);
            currentPlayerBtns[i].addActionListener(this);
            currentPlayerBtns[i].setEnabled(false);
            JLabel playerScore = new JLabel("" + GUI.state.players.get(i).wins, SwingConstants.CENTER);
            group.add(currentPlayerBtns[i]);
            this.add(currentPlayerBtns[i]);
            this.add(playerScore);
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}