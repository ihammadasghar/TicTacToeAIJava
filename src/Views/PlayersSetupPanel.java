package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayersSetupPanel extends JPanel {
    public int numOfPlayers = 4;
    public JComboBox[] playerTypeComboBoxes = new JComboBox[4];

    public PlayersSetupPanel() {
        JPanel mainPanel = new JPanel();
        JPanel Grid = new JPanel();
        JPanel gridSetUp = new JPanel();
        JPanel typeSetUp = new JPanel();
        JPanel typePanel = new JPanel();
        JPanel titlePanel = new JPanel();

        JLabel title = new JLabel("Players", JLabel.RIGHT);
        JLabel typeLabel = new JLabel("Type", SwingConstants.CENTER);
        typeLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        JLabel numOfPlayerLabel = new JLabel("" + numOfPlayers);
        title.setForeground(Color.BLUE);
        typeLabel.setFont(GUI.typeFont);
        numOfPlayerLabel.setFont(GUI.playerFont);


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title.setFont(GUI.setupPanelTitleFont);
        titlePanel.add(title);
        add(titlePanel);
        add(mainPanel);
        mainPanel.setBorder(GUI.blackline);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JSlider numOfPlayerSlider = new JSlider(JSlider.VERTICAL);

        Grid.setLayout(new BoxLayout(Grid, BoxLayout.Y_AXIS));
        gridSetUp.setBorder(GUI.blackline);
        gridSetUp.setLayout(new BoxLayout(gridSetUp, BoxLayout.Y_AXIS));
        gridSetUp.add(numOfPlayerLabel);
        gridSetUp.add(numOfPlayerSlider);
        Grid.add(gridSetUp);
        mainPanel.add(Grid);

        String playerTypes[] = {"Human", "AI"};

        for (int i = 0; i < playerTypeComboBoxes.length; i++) {
            playerTypeComboBoxes[i] = new JComboBox(playerTypes);
            playerTypeComboBoxes[i].setMaximumSize(new Dimension(300,100));
        }

        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typePanel.setBorder(GUI.blackline);
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
