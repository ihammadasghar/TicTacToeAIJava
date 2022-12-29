package Views;

import javax.swing.*;
import java.awt.*;

public class InPlayFrame extends JFrame {
    public ScorePanel scorePanel;
    public CancelPanel cancelPanel;
    public GridPanel gridPanel;


    // Constructor
    public InPlayFrame() {
        // Setup the frame
        super("In play");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();

        JPanel main = new JPanel(new GridBagLayout());
        main.setBorder(GUI.blackline);

        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEtchedBorder());
        main.add(panel1);

        JPanel gameDetailsPanel = new JPanel();
        gameDetailsPanel.setLayout(new BoxLayout(gameDetailsPanel, BoxLayout.Y_AXIS));

        scorePanel = new ScorePanel();
        cancelPanel = new CancelPanel();


        gameDetailsPanel.add(scorePanel);
        gameDetailsPanel.add(cancelPanel);

        // Add panels to the frame
        c.ipady = (int) (GUI.FRAME_HEIGHT_INPLAY / 3);
        c.ipadx = (int) (GUI.FRAME_WIDTH_INPLAY / 6);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        gridPanel = new GridPanel(GUI.state.gridSize);
        panel1.add(gridPanel, c);

        c.ipady = 0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        main.add(gameDetailsPanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH_INPLAY, GUI.FRAME_HEIGHT_INPLAY);
        setVisible(true);


    }
}



