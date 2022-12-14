package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOptionsPanel extends JPanel implements ActionListener {
    public JRadioButton[] optionRadioBtns = new JRadioButton[GUI.gameTypeOptions.length];

    public GameOptionsPanel() {
        super();

        this.setLayout(new GridLayout(0, 1, 10, 10));
        this.setBorder(GUI.blackline);
        JLabel label = new JLabel("Game Options", JLabel.CENTER);
        label.setForeground(Color.BLUE);
        label.setFont(GUI.setupPanelTitleFont);
        label.setPreferredSize(new Dimension(250, 50));
        add(label);

        ButtonGroup options = new ButtonGroup();

        for (int i = 0; i < optionRadioBtns.length; i++) {
            optionRadioBtns[i] = new JRadioButton(GUI.gameTypeOptions[i]);
            optionRadioBtns[i].addActionListener(this);
            options.add(optionRadioBtns[i]);
            add(optionRadioBtns[i]);
        }

        optionRadioBtns[0].setSelected(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
