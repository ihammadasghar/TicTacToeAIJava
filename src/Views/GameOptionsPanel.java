package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOptionsPanel extends JPanel implements ActionListener {
    ButtonGroup optionBtns;
    Checkbox c1, c2, c3;

    public GameOptionsPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Game Options", JLabel.CENTER);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setPreferredSize(new Dimension(250, 50));
        add(label);

        JPanel options = new JPanel();
        options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
        options.setBorder(GUI.blackline);

        CheckboxGroup cbg = new CheckboxGroup();
        c1 = new Checkbox("Normal", cbg, true);
        c2 = new Checkbox("Misere", cbg, false);
        c3 = new Checkbox("Random turn", cbg, false);
        options.add(c1);
        options.add(c2);
        options.add(c3);

        add(options);

    }

    public void actionPerformed(ActionEvent e) {
    }

}
