package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        JLabel msg = new JLabel();
        // check if all elements are equal
        if(verify.equals(scores)){
            msg.setText("No winners! Everyone got a score of "+ bestScore);}
        else{msg.setText(
                "Congrats! Player " + (scores.indexOf(bestScore)+1) + " won with a score of "+ bestScore);}

        msg.setFont(GUI.typeFont);
        this.add(msg);
}
}
