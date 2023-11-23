package up.ppf.banksimulator.views;

import org.jetbrains.annotations.NotNull;
import up.ppf.banksimulator.Main;
import up.ppf.banksimulator.models.ExecutiveFractionsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GeneralStateTableView extends JFrame {
    private final JButton clientsDetailedButton;
    private final JButton atmsDetailedButton;
    private final JButton executivesDetailedButton;
    private final TableModel clientsTableModel;
    private final TableModel atmsTableModel;
    private final TableModel executivesTableModel;

    public GeneralStateTableView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(400, 500);
        setLayout(new GridLayout(3, 2));

        // TABLE CONFIGURATION
        clientsTableModel = getTableModel(Arrays.asList("Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive", "Exited"));
        clientsDetailedButton = new JButton("Clients Detailed");

        atmsTableModel = getTableModel(Arrays.asList("Available", "Occupied", "Out Of Order"));
        atmsDetailedButton = new JButton("ATMs Detailed");

        executivesTableModel = getTableModel(Arrays.asList("Idle", "Busy", "Taking A Break"));
        executivesDetailedButton = new JButton("Executives Detailed");

        add(getScrollPane("Client", clientsTableModel));
        add(clientsDetailedButton);
        add(getScrollPane("Atm", atmsTableModel));
        add(atmsDetailedButton);
        add(getScrollPane("Executive", executivesTableModel));
        add(executivesDetailedButton);

        setVisible(true);
    }

    private TableModel getTableModel(@NotNull Iterable<String> stateNames) {
        var columnNames = new String[]{"State", "Count/Total"};
        var tableModel = new DefaultTableModel(columnNames, 0);
        stateNames.forEach(stateName -> tableModel.addRow(new String[]{stateName, "0/0"}));
        return tableModel;
    }

    private JScrollPane getScrollPane(String agentTypeName, TableModel tableModel) {
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

    public void setExecutiveFractions(ExecutiveFractionsModel model) {
        executivesTableModel.setValueAt(model.getIdleFraction(), 0, 1);
        executivesTableModel.setValueAt(model.getBusyFraction(), 1, 1);
        executivesTableModel.setValueAt(model.getTakingBreakFraction(), 2, 1);
    }

    public void setAtmsFractions(AtmFractionsModel model) {
        atmsTableModel.setValueAt(model.getAvailableFraction(), 0, 1);
        atmsTableModel.setValueAt(model.getOccupiedFraction(), 1, 1);
        atmsTableModel.setValueAt(model.getOutOfOrderFraction(), 2, 1);
    }

    public void setClientsFractions(ClientFractionsModel model) {
        clientsTableModel.setValueAt(model.getEntranceFraction(), 0, 1);
        clientsTableModel.setValueAt(model.getAtmLineFraction(), 1, 1);
        clientsTableModel.setValueAt(model.getExecutiveLineFraction(), 2, 1);
        clientsTableModel.setValueAt(model.getAtmFraction(), 3, 1);
        clientsTableModel.setValueAt(model.getExecutiveFraction(), 4, 1);
        clientsTableModel.setValueAt(model.getExitedFraction(), 5, 1);
    }
}
