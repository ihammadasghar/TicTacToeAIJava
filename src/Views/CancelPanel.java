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
        JLabel def = new JLabel("(the current game)",SwingConstants.CENTER);
        this.add(def);
    }

    private class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //DO SOMETHING
            System.exit(0);
        }
    }
}
