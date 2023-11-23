package up.ppf.banksimulator;

import up.ppf.banksimulator.agents.AtmAgent;
import up.ppf.banksimulator.agents.ClientAgent;
import up.ppf.banksimulator.agents.ExecutiveAgent;
import up.ppf.banksimulator.buffers.Line;

import java.util.ArrayList;

public class Bank {
    private final Line atmLine;
    private final Line executiveLine;
    private final ArrayList<ExecutiveAgent> executives;
    private final ArrayList<AtmAgent> atms;
    private final ArrayList<ClientAgent> clients;

    public Bank(Line atmLine, Line executiveLine, ArrayList<ClientAgent> clients,
                ArrayList<AtmAgent> atms, ArrayList<ExecutiveAgent> executives) {
        this.atmLine = atmLine;
        this.executiveLine = executiveLine;
        this.executives = executives;
        this.atms = atms;
        this.clients = clients;
    }

    public Line getAtmLine() {
        return atmLine;
    }

    public Line getExecutiveLine() {
        return executiveLine;
    }

    public ArrayList<ExecutiveAgent> getExecutives() {
        return executives;
    }

    public ArrayList<AtmAgent> getAtms() {
        return atms;
    }

    public ArrayList<ClientAgent> getClients() {
        return clients;
    }
}
