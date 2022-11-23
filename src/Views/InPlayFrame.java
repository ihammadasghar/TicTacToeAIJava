package Views;

import javax.swing.*;
import java.awt.*;

public class InPlayFrame extends JFrame {
    // Constructor
    public InPlayFrame() {
        // Setup the frame
        super("In play");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new GridLayout(1, 2));
        main.setBorder(GUI.blackline);

        // Add panels to the frame
        main.add(new GridPanel(GUI.state.gridSize));

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        setVisible(true);
    }
}



