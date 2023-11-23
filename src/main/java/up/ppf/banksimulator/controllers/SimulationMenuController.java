package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.GeneralStateTableModel;
import up.ppf.banksimulator.views.GeneralStateTableView;
import up.ppf.banksimulator.views.SimulationMenuView;

import javax.swing.*;

public final class SimulationMenuController {
    public SimulationMenuController(SimulationMenuView view) {
        view.addStartButtonListener((e) -> {
            try {
                var model = new GeneralStateTableModel(view.getExecutivesNumber(), view.getAtmsNumber(), view.getClientsNumber());
                SwingUtilities.invokeLater(() -> new GeneralStateTableController(new GeneralStateTableView(), model));

            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Invalid input. Please enter valid numbers.");
            }
        });
    }
}
