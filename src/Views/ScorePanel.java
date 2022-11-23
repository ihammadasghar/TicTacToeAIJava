package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel implements ActionListener {
    public ScorePanel(int n) {
        super();

        this.setSize(GUI.FRAME_WIDTH,GUI.FRAME_HEIGHT);
        this.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel currentPlayer = new JLabel("Current Player");
        JLabel score = new JLabel("Score", SwingConstants.CENTER);
        this.add(currentPlayer);
        this.add(score);

        ButtonGroup group = new ButtonGroup();
        for(int i=0;i<n;i++){
            JRadioButton player = new JRadioButton(""+GUI.state.currentPlayer.name);
            player.addActionListener(this);
            JLabel playerScore = new JLabel(""+0, SwingConstants.CENTER);
            if(i==0){
                 player.setSelected(true);
            }
            group.add(player);
            this.add(player);
            this.add(playerScore);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}