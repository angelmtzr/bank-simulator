package up.ppf.banksimulator.controllers;

import up.ppf.banksimulator.ExecutiveAgent;
import up.ppf.banksimulator.models.ExecutiveModel;
import up.ppf.banksimulator.views.GeneralStateTableView;
import up.ppf.banksimulator.views.SimulationMenuView;

import javax.swing.*;
import java.util.ArrayList;

public final class SimulationMenuController {
    public SimulationMenuController(SimulationMenuView view) {
        view.addStartButtonListener((e) -> {
            try {
                var executives = new ArrayList<ExecutiveAgent>();
                for (int i = 0; i <= view.getExecutivesNumber(); i++) {
                    executives.add(new ExecutiveAgent(new ExecutiveModel(ExecutiveModel.ExecutiveState.IDLE)));
                    executives.get(i).start();
                }
                SwingUtilities.invokeLater(() -> new GeneralStateTableController(new GeneralStateTableView(), executives));
            } catch (NumberFormatException ex) {
                view.displayErrorMessage("Invalid input. Please enter valid numbers.");
            }
        });
    }
}
