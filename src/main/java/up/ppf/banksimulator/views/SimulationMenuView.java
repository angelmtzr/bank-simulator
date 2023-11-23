package up.ppf.banksimulator.views;

import up.ppf.banksimulator.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public final class SimulationMenuView extends JFrame {
    private final JTextField clientsNumberField;
    private final JTextField executivesNumberField;
    private final JTextField atmsNumberField;
    private final JTextField atmsLineField;
    private final JTextField executivesLineField;
    private final JButton startButton;

    public SimulationMenuView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(Main.TITLE);
        setSize(400, 200);

        // INPUT PARAMETERS FOR SIMULATION
        var clientsLabel = new JLabel("Number of Clients:");
        clientsNumberField = new JTextField("5");
        var executivesLabel = new JLabel("Number of Executives:");
        executivesNumberField = new JTextField("5");
        var atmsLabel = new JLabel("Number of ATMs:");
        atmsNumberField = new JTextField("5");
        var atmsLineLabel = new JLabel("ATMs line size:");
        atmsLineField = new JTextField("10");
        var executivesLineLabel = new JLabel("Executives line size:");
        executivesLineField = new JTextField("10");

        var panel = new JPanel(new GridLayout(5, 2));

        panel.add(clientsLabel);
        panel.add(clientsNumberField);
        panel.add(executivesLabel);
        panel.add(executivesNumberField);
        panel.add(atmsLabel);
        panel.add(atmsNumberField);
        panel.add(atmsLineLabel);
        panel.add(atmsLineField);
        panel.add(executivesLineLabel);
        panel.add(executivesLineField);

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

    public int getAtmsLineCapacity() throws NumberFormatException {
        return Integer.parseInt(atmsLineField.getText());
    }

    public int getExecutivesLineCapacity() throws NumberFormatException {
        return Integer.parseInt(executivesLineField.getText());
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}