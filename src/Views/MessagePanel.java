package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagePanel extends JPanel {
    public MessagePanel() {
        this.setBorder(new EmptyBorder(50, 0, 0, 0));
        List<Integer> scores = new ArrayList<Integer>();
        // add scores to array
            for(int i =0; i<GUI.state.players.length; i++) {
            scores.add(GUI.state.players[i].currentGameScore);
        }

        // get index of the highest score
        int bestScore = Collections.max(scores);
        JLabel msg = new JLabel("Congrats! Player " + (scores.indexOf(bestScore)+1) + " won with a score of "+ bestScore);
        msg.setFont(GUI.typeFont);
        this.add(msg);
}
}
