package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.ExecutiveModel;
import up.ppf.banksimulator.models.GeneralStateTableModel;
import up.ppf.banksimulator.views.DetailedStateTableView;
import up.ppf.banksimulator.views.GeneralStateTableView;

import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class GeneralStateTableController {
    public GeneralStateTableController(GeneralStateTableView view, GeneralStateTableModel model) {
        var executor = Executors.newScheduledThreadPool(model.getExecutives().size());
        executor.scheduleAtFixedRate(() -> {
            view.getTableModel().setValueAt(model.getExecutivesFraction(ExecutiveModel.ExecutiveState.IDLE), 0, 1);
            view.getTableModel().setValueAt(model.getExecutivesFraction(ExecutiveModel.ExecutiveState.BUSY), 1, 1);
            view.getTableModel().setValueAt(model.getExecutivesFraction(ExecutiveModel.ExecutiveState.TAKING_A_BREAK), 2, 1);
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
