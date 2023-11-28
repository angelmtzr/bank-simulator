package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.DetailedStateTableModel;
import up.ppf.banksimulator.models.GeneralStateTableModel;
import up.ppf.banksimulator.views.DetailedStateTableView;
import up.ppf.banksimulator.views.GeneralStateTableView;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class GeneralStateTableController {
    public GeneralStateTableController(GeneralStateTableView view, GeneralStateTableModel model) {
        Executors.newScheduledThreadPool(2).scheduleAtFixedRate(() -> {
            view.setExecutiveFractions(model.getExecutiveFractions());
            view.setAtmsFractions(model.getAtmFractions());
            view.setClientsFractions(model.getClientFractions());
        }, 0, 500, TimeUnit.MILLISECONDS);

        view.setClientsDetailedButtonListener((e) -> {
            var clientDetailedView = new DetailedStateTableView(
                    "Client",
                    new String[]{"ID", "Bank Entrance", "ATM Line", "Executive Line", "ATM", "Executive", "Exited"},
                    model.getBank().getClients().size());
            var clientDetailedModel = new DetailedStateTableModel(model.getBank());
            SwingUtilities.invokeLater(() -> {
                new DetailedStateTableController(clientDetailedView, clientDetailedModel);
            });
        });
        view.setAtmsDetailedButtonListener((e) -> {
            var atmDetailedView = new DetailedStateTableView(
                    "ATM",
                    new String[]{"ID", "Available", "Occupied", "Out Of Order"},
                    model.getBank().getAtms().size());
            var atmDetailedModel = new DetailedStateTableModel(model.getBank());
            SwingUtilities.invokeLater(() -> {
                new DetailedStateTableController(atmDetailedView, atmDetailedModel);
            });
        });

        view.setExecutivesDetailedButtonListener((e) -> {
            var executiveDetailedView = new DetailedStateTableView(
                    "Executive",
                    new String[]{"ID", "Idle", "Busy", "On Brake"},
                    model.getBank().getExecutives().size());
            var executiveDetailedModel = new DetailedStateTableModel(model.getBank());
            SwingUtilities.invokeLater(() -> {
                new DetailedStateTableController(executiveDetailedView, executiveDetailedModel);
            });
        });
    }
}
