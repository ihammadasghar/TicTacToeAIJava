package Views;

import javax.swing.*;
import java.awt.*;

public class InPlayFrame extends JFrame {
    // Constructor
    public InPlayFrame() {
        // Setup the frame
        super("In play");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();

        JPanel main = new JPanel(new GridBagLayout());
        main.setBorder(GUI.blackline);

        JPanel gameDetailsPanel = new JPanel();
        gameDetailsPanel.setLayout(new BoxLayout(gameDetailsPanel, BoxLayout.Y_AXIS));

        JPanel scorePanel = new ScorePanel();
        JPanel blankPanel = new JPanel();
        JPanel cancelPanel = new CancelPanel();

        gameDetailsPanel.add(scorePanel);
        gameDetailsPanel.add(cancelPanel);

        // Add panels to the frame
        c.ipady = (int) (GUI.FRAME_HEIGHT / 3);
        c.ipadx = (int) (GUI.FRAME_WIDTH / 6);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        main.add(new GridPanel(GUI.state.gridSize), c);

        c.ipady = 0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        main.add(gameDetailsPanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        setVisible(true);
    }
}



