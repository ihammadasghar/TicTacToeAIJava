package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PlayersSetupPanel extends JPanel {
    public int numOfPlayers = 3;
    public JSpinner p1TypeSpinner, p2TypeSpinner, p3TypeSpinner, p4TypeSpinner;

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
        SpinnerModel model1 = new SpinnerListModel(playerTypes);
        SpinnerModel model2 = new SpinnerListModel(playerTypes);
        SpinnerModel model3 = new SpinnerListModel(playerTypes);
        SpinnerModel model4 = new SpinnerListModel(playerTypes);
        p1TypeSpinner = new JSpinner(model1);
        p2TypeSpinner = new JSpinner(model2);
        p3TypeSpinner = new JSpinner(model3);
        p4TypeSpinner = new JSpinner(model4);


        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
        typeSetUp.setBorder(GUI.blackline);
        typeSetUp.setLayout(new BoxLayout(typeSetUp, BoxLayout.Y_AXIS));
        typeSetUp.add(typeLabel);
        typeSetUp.add(p1TypeSpinner);
        typeSetUp.add(p2TypeSpinner);
        typeSetUp.add(p3TypeSpinner);
        typeSetUp.add(p4TypeSpinner);
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
