package up.ppf.banksimulator.views;

import org.jetbrains.annotations.NotNull;
import up.ppf.banksimulator.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GeneralStateTableView extends JFrame {
    private final JButton clientsDetailedButton;
    private final JButton atmsDetailedButton;
    private final JButton executivesDetailedButton;
    private DefaultTableModel tableModel;

    public GeneralStateTableView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(400, 500);
        setLayout(new GridLayout(3, 2));

        // TABLE CONFIGURATION
        var clientTable = getGeneralAgentTable("Client",
                Arrays.asList("Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive"));
        clientsDetailedButton = new JButton("Clients Detailed");

        var atmTable = getGeneralAgentTable("ATM",
                Arrays.asList("Available", "Occupied", "Out Of Order"));
        atmsDetailedButton = new JButton("ATMs Detailed");

        var executiveTable = getGeneralAgentTable("Executive",
                Arrays.asList("Idle", "Busy", "On Brake"));
        executivesDetailedButton = new JButton("Executives Detailed");

        add(clientTable);
        add(clientsDetailedButton);
        add(atmTable);
        add(atmsDetailedButton);
        add(executiveTable);
        add(executivesDetailedButton);

        setVisible(true);
    }

    private JScrollPane getGeneralAgentTable(String agentTypeName, @NotNull Iterable<String> stateNames) {
        var columnNames = new String[]{"State", "Count/Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        stateNames.forEach(stateName -> tableModel.addRow(new String[]{stateName, "0/0"}));
        var scrollPane = new JScrollPane(new JTable(tableModel));
        scrollPane.setBorder(BorderFactory.createTitledBorder(agentTypeName + "s"));
        return scrollPane;
    }

    public void setClientsDetailedButtonListener(ActionListener listener) {
        clientsDetailedButton.addActionListener(listener);
    }

    public void setAtmsDetailedButtonListener(ActionListener listener) {
        atmsDetailedButton.addActionListener(listener);
    }

    public void setExecutivesDetailedButtonListener(ActionListener listener) {
        executivesDetailedButton.addActionListener(listener);
    }
    public DefaultTableModel getTableModel(){
        return tableModel;
    }
}
