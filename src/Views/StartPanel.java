package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    public StartPanel() {
        this.setBorder(new EmptyBorder(20, 10, 50, 10));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton startBtn = new JButton("Start");
        startBtn.setFont(GUI.startFont);
        startBtn.addActionListener(this);
        startBtn.setPreferredSize(new Dimension(250, 70));
        startBtn.setForeground(Color.blue);
        this.add(startBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.startGame();
    }

}


