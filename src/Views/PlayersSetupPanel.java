package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayersSetupPanel extends JPanel {
    int numOfPlayers = 3;
    Font display = new Font("Monospace", Font.PLAIN, 40);

    JPanel mainPanel = new JPanel();
    JPanel Grid = new JPanel();
    JPanel gridSetUp = new JPanel();
    JPanel typeSetUp = new JPanel();
    JPanel typePanel = new JPanel();
    JLabel title = new JLabel("Players", SwingConstants.CENTER);
    JLabel typeLabel = new JLabel("Type", SwingConstants.CENTER);
    JLabel numOfPlayerLabel = new JLabel("3");

    public PlayersSetupPanel() {
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

        //

        String playerTypes[] = {"Human", "AI"};
        SpinnerModel model1 = new SpinnerListModel(playerTypes);
        SpinnerModel model2 = new SpinnerListModel(playerTypes);
        SpinnerModel model3 = new SpinnerListModel(playerTypes);
        SpinnerModel model4 = new SpinnerListModel(playerTypes);
        JSpinner player1TypeSpinner = new JSpinner(model1);
        JSpinner player2TypeSpinner = new JSpinner(model2);
        JSpinner player3TypeSpinner = new JSpinner(model3);
        JSpinner player4TypeSpinner = new JSpinner(model4);


        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typeSetUp.setBorder(GUI.blackline);
        typeSetUp.setLayout(new BoxLayout(typeSetUp, BoxLayout.Y_AXIS));
        typeSetUp.add(typeLabel);
        typeSetUp.add(player1TypeSpinner);
        typeSetUp.add(player2TypeSpinner);
        typeSetUp.add(player3TypeSpinner);
        typeSetUp.add(player4TypeSpinner);
        typePanel.add(typeSetUp);
        mainPanel.add(typePanel);

        numOfPlayerSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                numOfPlayers = (int) ((state.getValue()) / 35) + 2;
                numOfPlayerLabel.setText("" + numOfPlayers);
            }
        });
    }
}
