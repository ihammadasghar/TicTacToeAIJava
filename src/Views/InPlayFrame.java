package Views;

import javax.swing.*;

public class InPlayFrame extends JFrame {
    // Constructor
    public InPlayFrame() {
        // Setup the frame
        super("In play");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);

        // Add panels to the frame
        this.add(new GridPanel(GUI.state.gridSize));

        // Make frame visible
        this.setVisible(true);
        this.pack();
    }
}



