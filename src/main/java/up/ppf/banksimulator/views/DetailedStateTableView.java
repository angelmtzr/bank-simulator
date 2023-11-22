package up.ppf.banksimulator.views;

import up.ppf.banksimulator.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class DetailedStateTableView extends JFrame {
    public DetailedStateTableView(String agentTypeName, String[] columnNames) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(500, 500);

        var tableModel = new DefaultTableModel(columnNames, 0);
        var scrollPane = new JScrollPane(new JTable(tableModel));
        scrollPane.setBorder(BorderFactory.createTitledBorder(agentTypeName + "s"));
        add(scrollPane);

        setVisible(true);
    }

    public void addTableRow() {
        
    }
}
