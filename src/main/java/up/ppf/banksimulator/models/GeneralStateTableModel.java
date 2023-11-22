package up.ppf.banksimulator.models;

import up.ppf.banksimulator.agents.ExecutiveAgent;

import java.util.ArrayList;

public class GeneralStateTableModel {
    private ArrayList<ExecutiveAgent> executives;

    public GeneralStateTableModel(ArrayList<ExecutiveAgent> executives) {
        this.executives = executives;
    }

    public ArrayList<ExecutiveAgent> getExecutives() {
        return executives;
    }

    public String getExecutivesFraction(ExecutiveModel.ExecutiveState state) {
        return executives.stream()
                .filter(executiveAgent -> executiveAgent.getModel().getState() == state)
                .toList().size()
                + "/" + executives.size();
    }
}
