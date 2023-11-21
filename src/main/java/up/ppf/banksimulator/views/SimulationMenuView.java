package up.ppf.banksimulator.views;

import up.ppf.banksimulator.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public final class SimulationMenuView extends JFrame {
    private final JTextField clientsNumberField;
    private final JTextField executivesNumberField;
    private final JTextField atmsNumberField;
    private final JButton startButton;

    public SimulationMenuView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(400, 200);

        var panel = new JPanel(new GridLayout(3, 2));

        // INPUT PARAMETERS FOR SIMULATION
        var clientsLabel = new JLabel("Number of Clients:");
        clientsNumberField = new JTextField();
        var executivesLabel = new JLabel("Number of Executives:");
        executivesNumberField = new JTextField();
        var atmsLabel = new JLabel("Number of ATMs:");
        atmsNumberField = new JTextField();

        panel.add(clientsLabel);
        panel.add(clientsNumberField);
        panel.add(executivesLabel);
        panel.add(executivesNumberField);
        panel.add(atmsLabel);
        panel.add(atmsNumberField);

        startButton = new JButton("Start Simulation");

        setLayout(new BorderLayout());

        add(panel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public int getClientsNumber() throws NumberFormatException {
        return Integer.parseInt(clientsNumberField.getText());
    }

    public int getExecutivesNumber() throws NumberFormatException {
        return Integer.parseInt(executivesNumberField.getText());
    }

    public int getAtmsNumber() throws NumberFormatException {
        return Integer.parseInt(atmsNumberField.getText());
    }

    public void addStartListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}