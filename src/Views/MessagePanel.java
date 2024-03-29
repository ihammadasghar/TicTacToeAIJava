package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MessagePanel extends JPanel {
    public MessagePanel() {
        this.setBorder(new EmptyBorder(25, 0, 0, 0));

        int bestScore = GUI.state.players[0].currentGameScore;
        GUI.state.players[0].losses++;
        int bestScorePlayerNum = 0;
        boolean isDraw = false;
        ArrayList<Integer> drawBetweenPlayerNums = new ArrayList<>();
        drawBetweenPlayerNums.add(0);

        for (int i = 1; i < GUI.state.players.length; i++) {
            if (GUI.state.players[i].currentGameScore == bestScore) {
                isDraw = true;
                drawBetweenPlayerNums.add(i);
            } else if (GUI.state.players[i].currentGameScore > bestScore) {
                bestScore = GUI.state.players[i].currentGameScore;
                bestScorePlayerNum = i;
                isDraw = false;
                drawBetweenPlayerNums.clear();
                drawBetweenPlayerNums.add(i);
            }
            GUI.state.players[i].losses++;
        }

        JLabel msg_player = new JLabel("", SwingConstants.CENTER);
        JLabel msg_score = new JLabel("", SwingConstants.CENTER);
        msg_player.setFont(GUI.typeFont);
        msg_score.setFont(GUI.typeFont);

        if (isDraw) {
            StringBuilder msg = new StringBuilder();
            msg.append("Players ");
            for (int pNum : drawBetweenPlayerNums) {
                msg.append(pNum + 1).append(" ");
                GUI.state.players[pNum].draws++;
                GUI.state.players[pNum].losses--;
            }

            msg.append("drew with score ").append(bestScore);
            msg_score.setText(msg.toString());
        } else {
            msg_player.setText(GUI.state.players[bestScorePlayerNum].name);
            msg_player.setForeground((Color.decode(GUI.playerColors[bestScorePlayerNum])));
            msg_score.setText(" won with " + bestScore + " points");
            GUI.state.players[bestScorePlayerNum].wins++;
            GUI.state.players[bestScorePlayerNum].losses--;
            this.add(msg_player);
        }

        this.add(msg_score);

    }
}
