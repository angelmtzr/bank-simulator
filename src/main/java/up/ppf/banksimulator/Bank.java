package up.ppf.banksimulator;

import up.ppf.banksimulator.agents.AtmAgent;
import up.ppf.banksimulator.agents.ClientAgent;
import up.ppf.banksimulator.agents.ExecutiveAgent;
import up.ppf.banksimulator.buffers.Line;
import up.ppf.banksimulator.models.AtmModel;
import up.ppf.banksimulator.models.ExecutiveModel;

import java.util.ArrayList;

public class Bank {
    private final Line atmLine;
    private final Line executiveLine;
    private ArrayList<ExecutiveAgent> executives;
    private ArrayList<AtmAgent> atms;
    private ArrayList<ClientAgent> clients;

    public Bank(Line atmLine, Line executiveLine, ArrayList<ClientAgent> clients,
                ArrayList<AtmAgent> atms, ArrayList<ExecutiveAgent> executives) {
        this.atmLine = atmLine;
        this.executiveLine = executiveLine;
        this.executives = executives;
        this.atms = atms;
        this.clients = clients;
    }

    public void setExecutives(ArrayList<ExecutiveAgent> executives) {
        this.executives = executives;
    }

    public void setAtms(ArrayList<AtmAgent> atms) {
        this.atms = atms;
    }

    public void setClients(ArrayList<ClientAgent> clients) {
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

    public AtmAgent getAvailableAtm() {
        return atms.stream()
                .filter(a -> a.getModel().getState() == AtmModel.AtmState.AVAILABLE)
                .findFirst()
                .orElse(null);
    }

    public ExecutiveAgent getAvailableExecutive() {
        return executives.stream()
                .filter(e -> e.getModel().getState() == ExecutiveModel.ExecutiveState.IDLE)
                .findFirst()
                .orElse(null);
    }
}
