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
        var id = Integer.parseInt(client.getName().replaceAll("\\D", "")) - 1;
        detailedTableModel.setValueAt(client.getName(), id, 0);
        setValueDefault(id);
        var col = client.getModel().getState().getValue();
        if (col == 4 || col == 5) {
            switch (col) {
                case 4:
                    detailedTableModel.setValueAt(client.getCurrentAtm().getName(), id, col);
                    break;
                case 5:
                    detailedTableModel.setValueAt(client.getCurrentExecutive().getName(), id, col);
                    break;
            }

        }
        detailedTableModel.setValueAt(client.getModel().getState(), id, col);

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
