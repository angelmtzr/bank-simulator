package up.ppf.banksimulator.views;

import up.ppf.banksimulator.Main;
import up.ppf.banksimulator.agents.ClientAgent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class DetailedStateTableView extends JFrame {

    private TableModel detailedTableModel;
    private String[] columnNames;
    private int numberAgents;

    public DetailedStateTableView(String agentTypeName, String[] columnNames, int numberAgents) {
        this.columnNames = columnNames;
        this.numberAgents = numberAgents;
        this.detailedTableModel = new DefaultTableModel(columnNames, numberAgents);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(500, 500);

        var scrollPane = new JScrollPane(new JTable(detailedTableModel));
        scrollPane.setBorder(BorderFactory.createTitledBorder(agentTypeName + "s"));
        add(scrollPane);

        setVisible(true);
    }


    public void setClientStateRow(ClientAgent client) {
        var clientRowId = Integer.parseInt(client.getName().replaceAll("\\D", "")) - 1;
        detailedTableModel.setValueAt(client.getName(), clientRowId, 0);
        setValueDefault(clientRowId);
        var stateCol = client.getModel().getState().getValue();
//        detailedTableModel.setValueAt(client.);
//        if (col == 4 || col == 5) {
//            switch (col) {
//                case 4 -> detailedTableModel.setValueAt(client.getCurrentAtm().getName(), id, col);
//                case 5 -> detailedTableModel.setValueAt(client.getCurrentExecutive().getName(), id, col);
//            }
//        }
//        else {
//            detailedTableModel.setValueAt("X", id, col);
//        }
        switch (client.getModel().getState()) {
            case ATM -> {
                var atmName = client.getCurrentAtm() == null ? "Exiting" : client.getCurrentAtm().getName();
                detailedTableModel.setValueAt(atmName, clientRowId, stateCol);
            }
            case EXECUTIVE -> {
                var exName = client.getCurrentExecutive() == null ? "Exiting" : client.getCurrentExecutive().getName();
                detailedTableModel.setValueAt(exName, clientRowId, stateCol);
            }
            default -> detailedTableModel.setValueAt("X", clientRowId, stateCol);
        }
    }

    private void setValueDefault(int index) {
        detailedTableModel.setValueAt("", index, 1);
        detailedTableModel.setValueAt("", index, 2);
        detailedTableModel.setValueAt("", index, 3);
        if (columnNames.length == 7) {
            detailedTableModel.setValueAt("", index, 4);
            detailedTableModel.setValueAt("", index, 5);
            detailedTableModel.setValueAt("", index, 6);
        }
    }
}
