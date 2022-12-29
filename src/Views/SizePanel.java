package Views;

import Models.Grid;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SizePanel extends JPanel {
    public int gridSize = Grid.gridSize/*3*/;
    public int winNum = Grid.win/*7*/;

    public SizePanel() {
        JPanel sizeOptions = new JPanel();
        JPanel gridBox = new JPanel();
        JPanel gridSetUp = new JPanel();
        JPanel winSetUp = new JPanel();
        JPanel winBox = new JPanel();

        JSlider gridSlider = new JSlider(JSlider.VERTICAL);
        JSlider winSlider = new JSlider(JSlider.VERTICAL);

        JLabel sizeTitle = new JLabel("Size", SwingConstants.CENTER);
        JLabel gridTitle = new JLabel("Grid", SwingConstants.LEFT);
        JLabel winTitle = new JLabel("Win", JLabel.CENTER);
        JLabel gridValue = new JLabel("  "+Models.Grid.gridSize+"x"+Models.Grid.gridSize+"  ");
        JLabel winValue = new JLabel("" + winNum);

        gridBox.setBorder(GUI.blackline);
        winBox.setBorder(GUI.blackline);
        sizeOptions.setAlignmentX(SwingConstants.CENTER);
        sizeOptions.setBorder(new EmptyBorder(0, 45, 0, 0));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        sizeTitle.setForeground(Color.BLUE);
        sizeTitle.setFont(GUI.setupPanelTitleFont);
        sizeTitle.setBorder(new EmptyBorder(9, 170, 10, 10));

        add(sizeTitle);
        add(sizeOptions);

        sizeOptions.setLayout(new BoxLayout(sizeOptions, BoxLayout.X_AXIS));

        // Grid
        gridSetUp.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        gridTitle.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        gridTitle.setBorder(new EmptyBorder(0, 10, 0, 55));

        gridTitle.setFont(GUI.grid_winFont);
        gridValue.setFont(GUI.valueFont);
        gridBox.setLayout(new BoxLayout(gridBox, BoxLayout.Y_AXIS));
        gridBox.add(gridTitle);
        gridSetUp.setLayout(new BoxLayout(gridSetUp, BoxLayout.X_AXIS));
        gridSetUp.add(gridSlider);
        gridSetUp.add(gridValue);
        gridBox.add(gridSetUp);
        sizeOptions.add(gridBox);

        // Win
        winSetUp.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        winTitle.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        winTitle.setBorder(new EmptyBorder(0, 40, 0, 40));

        winTitle.setFont(GUI.grid_winFont);
        winValue.setFont(GUI.valueFont);
        winBox.setLayout(new BoxLayout(winBox, BoxLayout.Y_AXIS));
        winBox.add(winTitle);
        winSetUp.setLayout(new BoxLayout(winSetUp, BoxLayout.X_AXIS));
        winSetUp.add(winSlider);
        winSetUp.add(winValue);
        winBox.add(winSetUp);
        sizeOptions.add(winBox);

        gridSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                int tempgridSize = (int) ((state.getValue()) / 14) + 3;
                if (winNum > tempgridSize) {
                    winNum = tempgridSize;
                    winValue.setText("" + winNum);
                }
                gridSize = tempgridSize;
                Models.Grid.gridSize = gridSize;
                if(gridSize<=9){
                gridValue.setText("  "+gridSize + "x" + gridSize+"  ");}
                else{
                gridValue.setText(""+gridSize + "x" + gridSize+"");}

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
