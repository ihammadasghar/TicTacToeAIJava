package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOptionsPanel extends JPanel implements ActionListener {
    public JRadioButton[] optionRadioBtns = new JRadioButton[GUI.gameTypeOptions.length];

    public GameOptionsPanel() {
        super();
        this.setLayout(new GridLayout(0, 1, 10, 0));
        JPanel optionsPanel = new JPanel();
        JPanel title = new JPanel();
        JPanel empty = new JPanel();

        JLabel label = new JLabel("Game Options", SwingConstants.CENTER);

        optionsPanel.setBorder(GUI.grayline);
        optionsPanel.setLayout(new GridLayout(3,1));


        title.setBorder(new EmptyBorder(100, 10, 50, 10));
        title.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        label.setPreferredSize(new Dimension(300,200));
        label.setForeground(Color.BLUE);
        label.setFont(GUI.setupPanelTitleFont);
        label.setPreferredSize(new Dimension(500, 50));


        title.add(label);

        ButtonGroup options = new ButtonGroup();
        for (int i = 0; i < optionRadioBtns.length; i++) {
            optionRadioBtns[i] = new JRadioButton(GUI.gameTypeOptions[i]);
            Font radioButtonFont= new Font(optionRadioBtns[i].getFont().getName(),optionRadioBtns[i].getFont().getStyle(),18);
            optionRadioBtns[i].setFont(radioButtonFont);
            optionRadioBtns[i].addActionListener(this);
            optionRadioBtns[i].setBounds(120, 30, 120, 50);
            options.add(optionRadioBtns[i]);
            optionsPanel.add(optionRadioBtns[i]);
        }

        optionRadioBtns[0].setSelected(true);
        this.add(title);
        this.add(optionsPanel);
        this.add(empty);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
