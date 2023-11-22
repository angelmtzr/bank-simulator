package up.ppf.banksimulator;

import up.ppf.banksimulator.controllers.SimulationMenuController;
import up.ppf.banksimulator.views.SimulationMenuView;

import javax.swing.*;

public class Main {
    public static final String TITLE = "Bankorama";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimulationMenuController(new SimulationMenuView()));
    }
}