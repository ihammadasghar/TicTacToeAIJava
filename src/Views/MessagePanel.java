package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class MessagePanel extends JPanel {
    public MessagePanel() {
        this.setBorder(new EmptyBorder(50, 0, 0, 0));
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Integer> verify = new ArrayList<Integer>();
        // add scores to array
            for(int i =0; i<GUI.state.players.length; i++) {
            scores.add(GUI.state.players[i].currentGameScore);
        }
        // get index of the highest score
        int bestScore = Collections.max(scores);
            for(int i=0; i< GUI.state.players.length;i++){
                verify.add(bestScore);}

        JLabel msg_player= new JLabel();
        JLabel msg_score = new JLabel();
        msg_player.setFont(GUI.typeFont);
        msg_score.setFont(GUI.typeFont);

        // check if all elements are equal
        if(verify.equals(scores)){
            msg_score.setText("No winners! Everyone got a score of "+ bestScore);
            this.add(msg_score);

        } else{
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
