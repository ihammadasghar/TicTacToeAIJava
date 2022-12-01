package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class SetupFrame extends JFrame {
    // Constructor
    public SetupFrame() {
        super("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new GridLayout(2, 2));
        main.setBorder(GUI.blackline);

        JPanel optionsPanel = new GameOptionsPanel();
        JPanel sizePanel = new SizePanel();
        JPanel startPanel = new StartPanel();
        JPanel playersSetupPanel = new PlayersSetupPanel();
        optionsPanel.setSize((int) GUI.FRAME_WIDTH / 4, (int) GUI.FRAME_HEIGHT / 4);
        main.add(playersSetupPanel);
        main.add(sizePanel);
        main.add(optionsPanel);
        main.add(startPanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        setVisible(true);
    }
}



