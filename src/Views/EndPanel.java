package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPanel extends JPanel{
    public EndPanel() {
        JButton endBtn = new JButton("End Game");
        endBtn.setForeground(Color.red);
        endBtn.setFont(GUI.startFont);
        endBtn.setPreferredSize(new Dimension(200, 70));
        endBtn.addActionListener(new CloseListener());
        this.add(endBtn);
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            GUI.endGame();
        }
    }
}
