package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SizePanel extends JPanel {
    int gridSize = 3;
    int winNum = 7;
    Font display = new Font("Monospace", Font.PLAIN, 40);

    JPanel sizeOptions = new JPanel();
    JPanel Grid = new JPanel();
    JPanel gridSetUp = new JPanel();
    JPanel winSetUp = new JPanel();
    JPanel Win = new JPanel();
    JLabel sizeTitle = new JLabel("Size", SwingConstants.CENTER);
    JLabel gridValue = new JLabel("6x6");
    JLabel winValue = new JLabel("" + winNum);

    public SizePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        sizeTitle.setFont(display);
        this.add(sizeTitle);
        this.add(sizeOptions);
        sizeOptions.setLayout(new BoxLayout(sizeOptions, BoxLayout.X_AXIS));
        gridValue.setFont(display);
        winValue.setFont(display);
        JLabel winTitle = new JLabel("Win", SwingConstants.CENTER);
        JSlider winSlider = new JSlider(JSlider.VERTICAL);

        JLabel gridTitle = new JLabel("Grid", SwingConstants.CENTER);
        JSlider gridSlider = new JSlider(JSlider.VERTICAL);

        Grid.setLayout(new BoxLayout(Grid, BoxLayout.Y_AXIS));
        Grid.add(gridTitle);
        gridSetUp.setBorder(GUI.blackline);
        gridSetUp.setLayout(new BoxLayout(gridSetUp, BoxLayout.X_AXIS));
        gridSetUp.add(gridSlider);
        gridSetUp.add(gridValue);
        Grid.add(gridSetUp);
        sizeOptions.add(Grid);

        //
        Win.setLayout(new BoxLayout(Win, BoxLayout.Y_AXIS));
        Win.add(winTitle);
        winSetUp.setBorder(GUI.blackline);
        winSetUp.setLayout(new BoxLayout(winSetUp, BoxLayout.X_AXIS));
        winSetUp.add(winSlider);
        winSetUp.add(winValue);
        Win.add(winSetUp);
        sizeOptions.add(Win);

        gridSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                gridSize = (int) ((state.getValue()) / 14) + 3;
                if (winNum > gridSize) {
                    winNum = gridSize;
                    winValue.setText("" + winNum);
                }
                GUI.state.gridSize = gridSize;
                gridValue.setText(gridSize + "x" + gridSize);
            }
        });
        winSetUp.add(winSlider);
        winSetUp.add(winValue);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                winNum = (int) (state.getValue() / (100 / gridSize));
                if (winNum < 3) {
                    winNum = 3;
                }
                winValue.setText("" + winNum);
            }
        });
    }
}
