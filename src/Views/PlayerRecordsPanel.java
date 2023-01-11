package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PlayerRecordsPanel extends JPanel {
    public PlayerRecordsPanel() {

        // Data to be displayed in the JTable
        String[][] data = new String[GUI.state.players.length][4];

        for (int i = 0; i < GUI.state.players.length; i++) {
            data[i][0] = GUI.state.players[i].name;
            data[i][1] = GUI.state.players[i].wins + "";
            data[i][2] = GUI.state.players[i].draws + "";
            data[i][3] = GUI.state.players[i].losses + "";
        }

        // Column Names
        String[] columnNames = {"Players", "Wins", "Draws", "Losses"};

        // Initializing the JTable
        JTable j = new JTable(data, columnNames){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        j.getTableHeader().setReorderingAllowed(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<4;i++) {
            j.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        j.setBounds(30, 40, 200, 200);
        j.getTableHeader().setResizingAllowed(false);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j){
            public Dimension getPreferredSize() {
                return new Dimension(500, 55+15*(GUI.state.players.length-2));
            }
        };

        this.add(sp);

    }
}
