package Views;

import javax.swing.*;
import java.awt.*;

public class SetupFrame extends JFrame {
    // Constructor
    public SetupFrame() {
        super("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new GridLayout(2, 2));
        main.setBorder(GUI.blackline);

        JPanel panel = new GameOptionsPanel();
        JPanel sizePanel = new SizePanel();
        panel.setSize((int) GUI.FRAME_WIDTH / 4, (int) GUI.FRAME_HEIGHT / 4);
        main.add(panel);
        main.add(sizePanel);

        // Make frame visible
        add(main);
        setSize(GUI.FRAME_WIDTH, GUI.FRAME_HEIGHT);
        setVisible(true);
    }
}



