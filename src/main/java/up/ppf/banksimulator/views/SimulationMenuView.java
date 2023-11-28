package up.ppf.banksimulator.views;

import up.ppf.banksimulator.GeneralStateTableParamsModel;
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
        setSize(600, 350);

        // INPUT PARAMETERS FOR SIMULATION
        var clientsLabel = new JLabel("Number of Clients:");
        clientsNumberField = new JTextField("11");
        var executivesLabel = new JLabel("Number of Executives:");
        executivesNumberField = new JTextField("3");
        var atmsLabel = new JLabel("Number of ATMs:");
        atmsNumberField = new JTextField("2");
        var atmsLineLabel = new JLabel("ATMs line size:");
        atmsLineField = new JTextField("5");
        var executivesLineLabel = new JLabel("Executives line size:");
        executivesLineField = new JTextField("5");

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

        var menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());

        menuPanel.add(panel, BorderLayout.CENTER);
        menuPanel.add(startButton, BorderLayout.SOUTH);

        var infoPanel = new JPanel(new GridLayout(1, 2));
        infoPanel.add(new JLabel(new ImageIcon("UP.jpg")));
        var text = new TextArea("""
                ISGC
                Fundamentos de Programación en Paralelo
                Pablo Raschid Llamas Aun
                Ángel Martínez Rodríguez
                Luis Felipe Organista Méndez
                Profesor: Dr. Juan Carlos López Pimentel
                28/11/2023""");
        text.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        text.setEditable(false);
        infoPanel.add(text);

        setLayout(new GridLayout(2, 1));
        add(menuPanel);
        add(infoPanel);
        setVisible(true);
    }

    private int getClientsNumber() throws NumberFormatException {
        return Integer.parseInt(clientsNumberField.getText());
    }

    private int getExecutivesNumber() throws NumberFormatException {
        return Integer.parseInt(executivesNumberField.getText());
    }

    private int getAtmsNumber() throws NumberFormatException {
        return Integer.parseInt(atmsNumberField.getText());
    }

    private int getAtmsLineCapacity() throws NumberFormatException {
        return Integer.parseInt(atmsLineField.getText());
    }

    private int getExecutivesLineCapacity() throws NumberFormatException {
        return Integer.parseInt(executivesLineField.getText());
    }

    public GeneralStateTableParamsModel getParams() {
        return new GeneralStateTableParamsModel(getClientsNumber(), getAtmsNumber(),
                getExecutivesNumber(), getAtmsLineCapacity(), getExecutivesLineCapacity());
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}