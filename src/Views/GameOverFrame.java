package Views;

import javax.swing.*;

public class GameOverFrame extends JFrame {

    public EndPanel endPanel;
    public RestartPanel restartPanel;
    public MessagePanel messagePanel;

    public GameOverFrame() {
        super("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel();
        JPanel buttons = new JPanel();

        messagePanel = new MessagePanel();
        endPanel = new EndPanel();
        restartPanel = new RestartPanel();

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        buttons.add(restartPanel);
        buttons.add(endPanel);

        main.add(messagePanel);
        main.add(buttons);
        this.add(main);

        setSize(GUI.FRAME_WIDTH_GAMEOVER, GUI.FRAME_HEIGHT_GAMEOVER);
        setLocation(GUI.END_X_POSITION, GUI.END_Y_POSITION);
        setVisible(true);
    }

}
