package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid implements ActionListener {
    char play = 'X';
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    Font fontSym = new Font("Dialog",Font.BOLD, 50);
    Font fontSides = new Font("Monospace",Font.PLAIN ,20);

    // Constructor
    public Grid(){
        int n=3;
        //creates frame
        JFrame frm = new JFrame("MainWindow");
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(0,(n+2),10,10));

        //adds upper legend
        for(int l=0;l<=(n+1);l++) {
            if(l<1){
                JLabel blk = new JLabel("");
                grid.add(blk);
            } else if (l==(n+1)) {
                JLabel blk = new JLabel("");
                grid.add(blk);
            } else {
                JLabel lgd = new JLabel("" + alphabet[(l-1)],SwingConstants.CENTER);
                lgd.setFont(fontSides);
                grid.add(lgd);
            }
        }

        //creates grid
        for(int i=0;i<n;i++){
            JLabel idxLeft = new JLabel(""+i,SwingConstants.RIGHT);
            idxLeft.setFont(fontSides);
            grid.add(idxLeft);
            for(int j =0;j<n;j++) {
                JButton btn = new JButton(""+i);
                btn.setFont(fontSym);
                btn.addActionListener(this);
                grid.add(btn);
            }
            JLabel idxRight = new JLabel(""+i,SwingConstants.LEFT);
            idxRight.setFont(fontSides);
            grid.add(idxRight);
        }

        //adds lower legend
        for(int l=0;l<=(n+1);l++) {
            if(l<1){
                JLabel blk = new JLabel("");
                grid.add(blk);
            } else if (l==(n+1)) {
                JLabel blk = new JLabel("");
                grid.add(blk);
            } else {
                JLabel lgd = new JLabel("" + alphabet[(l-1)],SwingConstants.CENTER);
                lgd.setFont(fontSides);
                grid.add(lgd);
            }
        }

        //size of frame
        frm.add(grid);
        frm.setSize(500,500);
        frm.setVisible(true);
    }

    public static void main(String[] args){
        //Calls Constructor
        new Grid();
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        System.out.println(clicked);
        clicked.setText(String.valueOf(play));
        if(play =='O'){
            play ='X';
        }
        else{
            play = 'O';
        }
    }
}



