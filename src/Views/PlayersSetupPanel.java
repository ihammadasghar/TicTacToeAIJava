package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayersSetupPanel extends JPanel {
    public int numOfPlayers = 3;

    public PlayersSetupPanel() {
        Font display = new Font("Monospace", Font.PLAIN, 40);

        JPanel mainPanel = new JPanel();
        JPanel Grid = new JPanel();
        JPanel gridSetUp = new JPanel();
        JPanel typeSetUp = new JPanel();
        JPanel typePanel = new JPanel();
        JLabel title = new JLabel("Players", SwingConstants.CENTER);
        title.setForeground(Color.BLUE);
        JLabel typeLabel = new JLabel("Type", SwingConstants.CENTER);
        JLabel numOfPlayerLabel = new JLabel("3");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title.setFont(display);
        add(title);
        add(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        numOfPlayerLabel.setFont(display);

        JSlider numOfPlayerSlider = new JSlider(JSlider.VERTICAL);

        Grid.setLayout(new BoxLayout(Grid, BoxLayout.Y_AXIS));
        gridSetUp.setBorder(GUI.blackline);
        gridSetUp.setLayout(new BoxLayout(gridSetUp, BoxLayout.Y_AXIS));
        gridSetUp.add(numOfPlayerLabel);
        gridSetUp.add(numOfPlayerSlider);
        Grid.add(gridSetUp);
        mainPanel.add(Grid);

        String playerTypes[] = {"Human", "AI"};

        JComboBox model1 = new JComboBox(playerTypes);
        JComboBox model2 = new JComboBox(playerTypes);
        JComboBox model3 = new JComboBox(playerTypes);
        JComboBox model4 = new JComboBox(playerTypes);

        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typeSetUp.setBorder(GUI.blackline);
        typeSetUp.setLayout(new BoxLayout(typeSetUp, BoxLayout.Y_AXIS));
        typeSetUp.add(typeLabel);
        typeSetUp.add(model1);
        typeSetUp.add(model2);
        typeSetUp.add(model3);
        typeSetUp.add(model4);

        typePanel.add(typeSetUp);
        mainPanel.add(typePanel);

        numOfPlayerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                numOfPlayers = (int) ((state.getValue()) / 35) + 2;

                if (numOfPlayers==2){
                    model1.setEnabled(true);
                    model2.setEnabled(true);
                    model3.setEnabled(false);
                    model4.setEnabled(false);
                } else if (numOfPlayers==3){
                    model1.setEnabled(true);
                    model2.setEnabled(true);
                    model3.setEnabled(true);
                    model4.setEnabled(false);
                } else{
                model1.setEnabled(true);
                model2.setEnabled(true);
                model3.setEnabled(true);
                model4.setEnabled(true);}

                numOfPlayerLabel.setText("" + numOfPlayers);
            }
        });
    }
}
