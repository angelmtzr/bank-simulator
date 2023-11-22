package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.ExecutiveAgent;
import up.ppf.banksimulator.views.DetailedStateTableView;
import up.ppf.banksimulator.views.GeneralStateTableView;

import javax.swing.*;
import java.util.ArrayList;

public final class GeneralStateTableController {
    public GeneralStateTableController(GeneralStateTableView view, ArrayList<ExecutiveAgent> executives) {
        view.setClientsDetailedButtonListener((e) -> SwingUtilities.invokeLater(() -> new DetailedStateTableView(
                "Client",
                new String[]{"ID", "Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive"})));
        view.setAtmsDetailedButtonListener((e) -> SwingUtilities.invokeLater(() -> new DetailedStateTableView(
                "ATM",
                new String[]{"ID", "Available", "Occupied", "Out Of Order"})));
        view.setExecutivesDetailedButtonListener((e) -> {
            SwingUtilities.invokeLater(() -> {
                new DetailedStateTableView(
                        "Executive",
                        new String[]{"ID", "Idle", "Busy", "On Brake"});
            });
        });
    }
}
