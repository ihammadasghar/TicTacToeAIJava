package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartPanel extends JPanel implements ActionListener {

    public RestartPanel() {
        //this.setBorder(new EmptyBorder(20, 30, 50, 10));
        //this.setLayout(new GridBagLayout());

        /*
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
         */

        JButton restartBtn = new JButton("Restart");
        restartBtn.setFont(GUI.startFont);
        restartBtn.addActionListener(this);
        restartBtn.setPreferredSize(new Dimension(200, 70));
        restartBtn.setForeground(Color.blue);
        this.add(restartBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GUI.restartGame();}

}


