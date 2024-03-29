package Views;

import javax.swing.*;
import java.awt.*;

public class SetupFrame extends JFrame {
    public GameOptionsPanel optionsPanel;
    public SizePanel sizePanel;
    public StartPanel startPanel;
    public PlayersSetupPanel playersSetupPanel;

    // Constructor
    public SetupFrame() {
        super("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new GridLayout(2, 2));
        main.setBorder(GUI.grayline);

        optionsPanel = new GameOptionsPanel();
        sizePanel = new SizePanel();
        startPanel = new StartPanel();
        playersSetupPanel = new PlayersSetupPanel();
        optionsPanel.setSize((int) GUI.FRAME_WIDTH_SETUP / 4, (int) GUI.FRAME_HEIGHT_SETUP / 4);
        main.add(playersSetupPanel);
        main.add(sizePanel);
        main.add(optionsPanel);
        main.add(startPanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH_SETUP, GUI.FRAME_HEIGHT_SETUP);
        setLocation(GUI.SETUP_X_POSITION, GUI.SETUP_Y_POSITION);
        setVisible(true);
    }
}



