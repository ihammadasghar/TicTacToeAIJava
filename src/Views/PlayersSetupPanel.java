package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayersSetupPanel extends JPanel {
    public int numOfPlayers;
    public JComboBox[] playerTypeComboBoxes = new JComboBox[4];

    public PlayersSetupPanel() {
        this.numOfPlayers = 4;
        JPanel mainPanel = new JPanel();
        JPanel Grid = new JPanel();
        JPanel gridSetUp = new JPanel();
        JPanel typeSetUp = new JPanel();
        JPanel typePanel = new JPanel();
        JPanel titlePanel = new JPanel();

        JSlider numOfPlayerSlider = new JSlider(JSlider.VERTICAL);

        JLabel title = new JLabel("Players", JLabel.RIGHT);
        JLabel typeLabel = new JLabel("Type", SwingConstants.CENTER);
        JLabel numOfPlayerLabel = new JLabel("" + numOfPlayers);

        numOfPlayerSlider.setBorder(new EmptyBorder(0, 5, 0, 0));
        typeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        title.setForeground(Color.BLUE);
        typeLabel.setFont(GUI.typeFont);
        numOfPlayerLabel.setFont(GUI.valueFont);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title.setFont(GUI.setupPanelTitleFont);
        titlePanel.add(title);
        add(titlePanel);
        add(mainPanel);
        mainPanel.setBorder(GUI.grayline);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));


        Grid.setLayout(new BoxLayout(Grid, BoxLayout.Y_AXIS));
        gridSetUp.setBorder(GUI.grayline);
        gridSetUp.setLayout(new BoxLayout(gridSetUp, BoxLayout.Y_AXIS));
        gridSetUp.add(numOfPlayerLabel);
        gridSetUp.add(numOfPlayerSlider);
        Grid.add(gridSetUp);
        mainPanel.add(Grid);


        for (int i = 0; i < playerTypeComboBoxes.length; i++) {
            playerTypeComboBoxes[i] = new JComboBox(GUI.playerTypes);
            playerTypeComboBoxes[i].setMaximumSize(new Dimension(300, 100));
        }

        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typePanel.setBorder(GUI.grayline);
        typeSetUp.setLayout(new BoxLayout(typeSetUp, BoxLayout.Y_AXIS));
        typeSetUp.add(typeLabel, BorderLayout.CENTER);


        for (int i = 0; i < playerTypeComboBoxes.length; i++) {
            typeSetUp.add(playerTypeComboBoxes[i]);
        }
        typePanel.add(typeSetUp);
        mainPanel.add(typePanel);

        numOfPlayerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                numOfPlayers = (int) ((state.getValue()) / 35) + 2;

                for (int i = 0; i < playerTypeComboBoxes.length; i++) {
                    playerTypeComboBoxes[i].setEnabled(i < numOfPlayers);
                }

                numOfPlayerLabel.setText("" + numOfPlayers);
            }
        });
    }
}
