package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.views.MainTableStateView;
import up.ppf.banksimulator.views.SimulationMenuView;

import javax.swing.*;

public final class SimulationMenuController {
    public SimulationMenuController(SimulationMenuView view) {
        view.addStartListener((e) -> {
            try {
                int numClients = view.getClientsNumber();
                int numExecutives = view.getExecutivesNumber();
                int numATMs = view.getAtmsNumber();
                SwingUtilities.invokeLater(() -> new MainTableStateController(new MainTableStateView(), null));
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Invalid input. Please enter valid numbers.");
            }
        });
    }
}
