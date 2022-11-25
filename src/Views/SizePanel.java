package Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SizePanel extends JPanel{
    int gridSize = 3;
    int winNum = 7;
    Font display = new Font("Monospace", Font.PLAIN, 40);
    JPanel sizeOptions = new JPanel();
    JPanel Grid = new JPanel();
    JPanel gridSetUp = new JPanel();
    JPanel winSetUp = new JPanel();
    JPanel Win = new JPanel();
    JLabel sizeTitle = new JLabel("Size");
    JLabel gridValue = new JLabel("6x6");
    JLabel winValue = new JLabel(""+winNum);

    public SizePanel() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        sizeTitle.setFont(display);
        this.add(sizeTitle);
        this.add(sizeOptions);
        sizeOptions.setLayout(new BoxLayout(sizeOptions,BoxLayout.X_AXIS));
        sizeOptions.setBorder(GUI.blackline);
        gridValue.setFont(display);
        winValue.setFont(display);
        JLabel winTitle = new JLabel("Win");
        JSlider winSlider = new JSlider(JSlider.VERTICAL);

        JLabel gridTitle = new JLabel("Grid");
        JSlider gridSlider = new JSlider(JSlider.VERTICAL);

        Grid.setLayout(new BoxLayout(Grid,BoxLayout.Y_AXIS));
        Grid.add(gridTitle);
        gridSetUp.setLayout(new BoxLayout(gridSetUp,BoxLayout.X_AXIS));
        gridSetUp.add(gridSlider);
        gridSetUp.add(gridValue);
        Grid.add(gridSetUp);
        sizeOptions.add(Grid);

        Win.setLayout(new BoxLayout(Win,BoxLayout.Y_AXIS));
        Win.add(winTitle);
        winSetUp.setLayout(new BoxLayout(winSetUp,BoxLayout.X_AXIS));
        winSetUp.add(winSlider);
        winSetUp.add(winValue);
        Win.add(winSetUp);
        sizeOptions.add(Win);

        /*
        Win.setLayout(new BoxLayout(Win,BoxLayout.Y_AXIS));
        Win.add(winTitle);
        this.add(Win);
        winSetUp.setBorder(GUI.blackline);
        winSetUp.setLayout(new BoxLayout(winSetUp,BoxLayout.X_AXIS));
        winSetUp.add(winSlider);
        winSetUp.add(winValue);
        Win.add(winSetUp);
        sizeOptions.add(Win);
         */
        gridSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                if (state.getValue() <= 0){gridSize=10; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 14){gridSize=9; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 28){gridSize=8; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 42){gridSize=7; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 56){gridSize=6; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 70){gridSize=5; gridValue.setText(""+gridSize+"x"+gridSize);}
                else if(state.getValue() <= 84){gridSize=4; gridValue.setText(""+gridSize+"x"+gridSize);}
                else{gridSize=3; gridValue.setText(""+gridSize+"x"+gridSize);}
            }
        });
        Win.add(winSlider);
        Win.add(winValue);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider state = (JSlider) e.getSource();
                if (state.getValue() <= 0){winNum=10; winValue.setText(""+winNum);}
                else if(state.getValue() <= 20){winNum=9; winValue.setText(""+winNum);}
                else if(state.getValue() <= 40){winNum=8; winValue.setText(""+winNum);}
                else if(state.getValue() <= 60){winNum=7; winValue.setText(""+winNum);}
                else if(state.getValue() <= 80){winNum=6; winValue.setText(""+winNum);}
                else{winNum=5; winValue.setText(""+winNum);}
            }
        });
    }
    }
