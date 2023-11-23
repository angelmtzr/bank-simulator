package up.ppf.banksimulator.models;

import up.ppf.banksimulator.agents.AtmAgent;
import up.ppf.banksimulator.agents.ClientAgent;
import up.ppf.banksimulator.agents.ExecutiveAgent;
import up.ppf.banksimulator.views.AtmFractionsModel;

import java.util.ArrayList;

public class GeneralStateTableModel {
    private final ArrayList<ExecutiveAgent> executives = new ArrayList<>();
    private final ArrayList<AtmAgent> atms = new ArrayList<>();
    private final ArrayList<ClientAgent> clients = new ArrayList<>();

    public GeneralStateTableModel(int nExecutives, int nAtms, int nClients) {
        setExecutives(nExecutives);
        setAtms(nAtms);
        setClients(nClients);

    }

    private void setExecutives(int nExecutives) {
        for (int i = 0; i < nExecutives; i++) {
            executives.add(new ExecutiveAgent(new ExecutiveModel(ExecutiveModel.ExecutiveState.IDLE)));
            executives.get(i).start();
        }
    }

    private void setAtms(int nAtms) {
        for (int i = 0; i < nAtms; i++) {
            atms.add(new AtmAgent(new AtmModel(AtmModel.AtmState.AVAILABLE)));
            atms.get(i).start();
        }
    }

    private void setClients(int nClients) {
        for (int i = 0; i < nClients; i++) {
            clients.add(new ClientAgent(new ClientModel(ClientModel.ClientState.BANK_ENTRANCE)));
            clients.get(i).start();
        }
    }

    public ArrayList<ExecutiveAgent> getExecutives() {
        return executives;
    }

    private String getExecutivesFraction(ExecutiveModel.ExecutiveState state) {
        return executives.stream()
                .filter(executiveAgent -> executiveAgent.getModel().getState() == state)
                .toList().size()
                + "/" + executives.size();
    }

    public ExecutiveFractionsModel getExecutiveFractions() {
        return new ExecutiveFractionsModel(
                getExecutivesFraction(ExecutiveModel.ExecutiveState.IDLE),
                getExecutivesFraction(ExecutiveModel.ExecutiveState.BUSY),
                getExecutivesFraction(ExecutiveModel.ExecutiveState.TAKING_A_BREAK));
    }

    private String getAtmFraction(AtmModel.AtmState state) {
        return atms.stream()
                .filter(atmAgent -> atmAgent.getModel().getState() == state)
                .toList().size()
                + "/" + executives.size();
    }

    public AtmFractionsModel getAtmFractions() {
        return new AtmFractionsModel(
                getAtmFraction(AtmModel.AtmState.AVAILABLE),
                getAtmFraction(AtmModel.AtmState.OCCUPIED),
                getAtmFraction(AtmModel.AtmState.OUT_OF_ORDER));
    }
    
    private String getClientFraction(ExecutiveModel.ExecutiveState state) {
        return executives.stream()
                .filter(executiveAgent -> executiveAgent.getModel().getState() == state)
                .toList().size()
                + "/" + executives.size();
    }
}
