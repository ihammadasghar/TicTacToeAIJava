package Views;

import javax.swing.*;
import java.awt.*;

public class InPlayFrame extends JFrame {
    public ScorePanel scorePanel;
    public CancelPanel cancelPanel;
    public GridPanel gridPanel;
    public DetailsPanel detailsPanel;

    // Constructor
    public InPlayFrame() {
        // Setup the frame
        super("In play");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();

        JPanel main = new JPanel(new GridBagLayout());
        main.setBorder(GUI.grayline);

        JPanel gameDetailsPanel = new JPanel();
        gameDetailsPanel.setLayout(new BoxLayout(gameDetailsPanel, BoxLayout.Y_AXIS));
        gameDetailsPanel.setBorder(GUI.grayline);
        gameDetailsPanel.setBorder(BorderFactory.createEtchedBorder());
        gameDetailsPanel.setBackground(Color.white);

        scorePanel = new ScorePanel();
        detailsPanel = new DetailsPanel();
        cancelPanel = new CancelPanel();

        gameDetailsPanel.add(scorePanel);
        gameDetailsPanel.add(detailsPanel);
        gameDetailsPanel.add(cancelPanel);

        // Add panels to the frame
        c.ipady = (int) (GUI.FRAME_HEIGHT_INPLAY / 3);
        c.ipadx = (int) (GUI.FRAME_WIDTH_INPLAY / 6);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        gridPanel = new GridPanel(GUI.state.gridSize);
        main.add(gridPanel, c);

        c.ipady = 0;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 0;
        main.add(gameDetailsPanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH_INPLAY, GUI.FRAME_HEIGHT_INPLAY);
        setLocation(GUI.GAME_X_POSITION,GUI.GAME_Y_POSITION);
        setVisible(true);
    }
}



