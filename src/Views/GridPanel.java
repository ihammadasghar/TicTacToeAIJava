package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridPanel extends JPanel implements ActionListener {
    public GridPanel(int n) {
        super();

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Font fontSym = new Font("Dialog", Font.BOLD, 50);
        Font fontSides = new Font("Monospace", Font.PLAIN, 20);

        this.setLayout(new GridLayout(0, (n + 2), 10, 10));

        //adds upper legend
        for (int l = 0; l <= (n + 1); l++) {
            if (l < 1) {
                JLabel blk = new JLabel("");
                this.add(blk);
            } else if (l == (n + 1)) {
                JLabel blk = new JLabel("");
                this.add(blk);
            } else {
                JLabel lgd = new JLabel("" + alphabet[(l - 1)], SwingConstants.CENTER);
                lgd.setFont(fontSides);
                this.add(lgd);
            }
        }

        //creates grid
        for (int i = 0; i < n; i++) {
            JLabel idxLeft = new JLabel("" + i, SwingConstants.RIGHT);
            idxLeft.setFont(fontSides);
            this.add(idxLeft);
            for (int j = 0; j < n; j++) {
                JButton btn = new JButton("" + i);
                btn.setFont(fontSym);
                btn.addActionListener(this);
                this.add(btn);
            }
            JLabel idxRight = new JLabel("" + i, SwingConstants.LEFT);
            idxRight.setFont(fontSides);
            this.add(idxRight);
        }

        //adds lower legend
        for (int l = 0; l <= (n + 1); l++) {
            if (l < 1) {
                JLabel blk = new JLabel("");
                this.add(blk);
            } else if (l == (n + 1)) {
                JLabel blk = new JLabel("");
                this.add(blk);
            } else {
                JLabel lgd = new JLabel("" + alphabet[(l - 1)], SwingConstants.CENTER);
                lgd.setFont(fontSides);
                this.add(lgd);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();
        clickedBtn.setText(String.valueOf(GUI.state.currentPlayer.symbol));
    }

}
