package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.models.GeneralStateTableModel;
import up.ppf.banksimulator.views.GeneralStateTableView;
import up.ppf.banksimulator.views.SimulationMenuView;

import javax.swing.*;

public final class SimulationMenuController {
    public SimulationMenuController(SimulationMenuView view) {
        view.addStartButtonListener((e) -> {
            try {
                var stateModel = new GeneralStateTableModel(view.getParams());
                var stateView = new GeneralStateTableView(
                        view.getParams().getAtmsLineSize(),
                        view.getParams().getExecutivesLineSize());
                SwingUtilities.invokeLater(() -> new GeneralStateTableController(stateView, stateModel));

            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Invalid input. Please enter valid numbers.");
            }
        });
    }
}
