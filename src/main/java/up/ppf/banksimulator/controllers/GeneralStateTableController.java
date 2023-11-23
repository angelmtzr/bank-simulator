package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.GeneralStateTableModel;
import up.ppf.banksimulator.views.DetailedStateTableView;
import up.ppf.banksimulator.views.GeneralStateTableView;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class GeneralStateTableController {
    public GeneralStateTableController(GeneralStateTableView view, GeneralStateTableModel model) {
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(() -> {
            view.setExecutiveFractions(model.getExecutiveFractions());
            view.setAtmsFractions(model.getAtmFractions());
            view.setClientsFractions(model.getClientFractions());
        }, 0, 500, TimeUnit.MILLISECONDS);

        view.setClientsDetailedButtonListener((e) -> SwingUtilities.invokeLater(() -> new DetailedStateTableView(
                "Client",
                new String[]{"ID", "Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive", "Exited"})));
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
