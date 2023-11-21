package up.ppf.banksimulator.views;

import org.jetbrains.annotations.NotNull;
import up.ppf.banksimulator.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class MainTableStateView extends JFrame {
    public MainTableStateView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(400, 500);
        setLayout(new GridLayout(3, 1));

        // TABLE CONFIGURATION
        add(getAgentStateTableScrollPane("Client",
                Arrays.asList("Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive")));
        add(getAgentStateTableScrollPane("ATM",
                Arrays.asList("Available", "Occupied", "Out Of Order")));
        add(getAgentStateTableScrollPane("Executive",
                Arrays.asList("Idle", "Busy", "On Brake")));

        setVisible(true);
    }

    private JScrollPane getAgentStateTableScrollPane(String agentTypeName, @NotNull Iterable<String> stateNames) {
        var columnNames = new String[]{"State", "Count/Total"};
        var tableModel = new DefaultTableModel(columnNames, 0);
        stateNames.forEach(stateName -> tableModel.addRow(new String[]{stateName, "0/0"}));
        var scrollPane = new JScrollPane(new JTable(tableModel));
        scrollPane.setBorder(BorderFactory.createTitledBorder(agentTypeName + "s"));
        return scrollPane;
    }
}
