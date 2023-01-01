package Views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel{

    public DetailsPanel() {
        this.setSize(GUI.FRAME_WIDTH_INPLAY, GUI.FRAME_HEIGHT_INPLAY);
        this.setLayout(new GridLayout(0, 1, 10, 10));

        JLabel gametype = new JLabel("Game Type: "+ GUI.state.type, SwingConstants.CENTER);
        JLabel wintype = new JLabel("Win Type: "+ GUI.state.win, SwingConstants.CENTER);
        add(gametype);
        add(wintype);

        gametype.setBorder(BorderFactory.createEtchedBorder());
        gametype.setBackground(Color.white);
        wintype.setBorder(BorderFactory.createEtchedBorder());
        wintype.setBackground(Color.white);
        }

    }






