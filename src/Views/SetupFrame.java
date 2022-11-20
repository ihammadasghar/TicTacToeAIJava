package Views;

import javax.swing.*;

public class SetupFrame extends JFrame {
    // Constructor
    public SetupFrame() {
        // Setup the frame
        super("Game Setup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);

        // Add panels to the frame
        this.add(new PlayersSetupPanel());

        // Make frame visible
        this.setVisible(true);
        this.pack();
    }
}



