package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


public class MessagePanel extends JPanel {
    public MessagePanel() {
        this.setBorder(new EmptyBorder(50, 0, 0, 0));
        ArrayList<Integer> scores = new ArrayList<Integer>();
        int count =0;

        // add scores to array
            for(int i =0; i<GUI.state.players.length; i++) {
            scores.add(GUI.state.players[i].currentGameScore);
        }
        // get index of the highest score
        int bestScore = Collections.max(scores);

        // check if draw
        for(int i=0; i< GUI.state.players.length;i++){
            if(scores.get(i) == bestScore){
                count+=1;}
        }

        JLabel msg_player= new JLabel();
        JLabel msg_score = new JLabel();
        msg_player.setFont(GUI.typeFont);
        msg_score.setFont(GUI.typeFont);

        if(count >1 && bestScore ==1) {
            msg_score.setText("Draw with " + bestScore + " point");
            this.add(msg_score);
        }else if (count >1 && bestScore >1) {
            msg_score.setText("Draw with "+ bestScore+" point");
            this.add(msg_score);

        }else{
            msg_player.setText("Player " + (scores.indexOf(bestScore)+1));
            msg_player.setForeground((Color.decode(GUI.playerColors[(scores.indexOf(bestScore))])));
            msg_score.setText(" won with "+bestScore+" points");

            if (bestScore == 1){
                msg_score.setText(" won with "+bestScore+" point");
            }
            this.add(msg_player);
            this.add(msg_score);
        }


}
}
