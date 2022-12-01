package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelPanel extends JPanel{
    public CancelPanel() {
        this.setLayout(new GridLayout(2,0,0,10));
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setForeground(Color.red);
        cancelBtn.addActionListener(new CloseListener());
        this.add(cancelBtn);
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            GUI.endGame();
        }
    }
}
