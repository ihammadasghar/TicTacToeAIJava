package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlayerRecordsPanel extends JPanel {
    public PlayerRecordsPanel() {
        this.setBorder(new EmptyBorder(50, 0, 0, 0));

        // Data to be displayed in the JTable
        String[][] data = new String[GUI.state.players.length][4];

        for (int i = 0; i < GUI.state.players.length; i++) {
            data[i][0] = GUI.state.players[i].name;
            data[i][1] = GUI.state.players[i].wins + "";
            data[i][2] = GUI.state.players[i].draws + "";
            data[i][3] = GUI.state.players[i].losses + "";
        }

        // Column Names
        String[] columnNames = {"Player", "Wins", "Draws", "Losses"};

        // Initializing the JTable
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 200);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);

        this.add(sp);

    }
}
