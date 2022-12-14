package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    public StartPanel() {
        JButton startBtn = new JButton("Start");
        startBtn.setFont(GUI.startFont);
        startBtn.addActionListener(this);
        startBtn.setPreferredSize(new Dimension(250, 100));
        startBtn.setForeground(Color.blue);
        this.add(startBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.startGame();
    }

}


