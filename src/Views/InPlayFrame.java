package Views;

import javax.swing.*;

public class InPlayFrame extends JFrame {
    // Constructor
    public InPlayFrame() {
        super("In play");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);

        this.add(new GridPanel(GUI.state.gridSize));

        this.setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        this.setVisible(true);
        this.pack();
    }
}



