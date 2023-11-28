package up.ppf.banksimulator.models;

import up.ppf.banksimulator.Bank;
import up.ppf.banksimulator.GeneralStateTableParamsModel;
import up.ppf.banksimulator.agents.AtmAgent;
import up.ppf.banksimulator.agents.ClientAgent;
import up.ppf.banksimulator.agents.ExecutiveAgent;
import up.ppf.banksimulator.buffers.Line;
import up.ppf.banksimulator.models.fractions.AtmFractionsModel;
import up.ppf.banksimulator.models.fractions.ClientFractionsModel;
import up.ppf.banksimulator.models.fractions.ExecutiveFractionsModel;

import java.util.ArrayList;

public class GeneralStateTableModel {
    private final Bank bank;

    public GeneralStateTableModel(GeneralStateTableParamsModel params) {
        bank = new Bank(
                new Line(params.getAtmsLineSize()),
                new Line(params.getExecutivesLineSize()),
                new ArrayList<ClientAgent>(),
                new ArrayList<AtmAgent>(),
                new ArrayList<ExecutiveAgent>()
        );

        bank.setClients(createClients(params.getClientsNumber()));
        bank.setAtms(createAtms(params.getAtmsNumber()));
        bank.setExecutives(createExecutives(params.getExecutiveNumber()));

        bank.getClients().forEach(Thread::start);
        bank.getAtms().forEach(Thread::start);
        bank.getExecutives().forEach(Thread::start);
    }


    private ArrayList<ClientAgent> createClients(int nClients) {
        var clients = new ArrayList<ClientAgent>();
        for (int i = 0; i < nClients; i++) {
            clients.add(new ClientAgent(bank, new ClientModel(ClientModel.ClientState.BANK_ENTRANCE)));
//            clients.get(i).start();
        }
        return clients;
    }

    private ArrayList<AtmAgent> createAtms(int nAtms) {
        var atms = new ArrayList<AtmAgent>();
        for (int i = 0; i < nAtms; i++) {
            atms.add(new AtmAgent(new AtmModel(AtmModel.AtmState.AVAILABLE)));
//            atms.get(i).start();
        }
        return atms;
    }

    private ArrayList<ExecutiveAgent> createExecutives(int nExecutives) {
        var executives = new ArrayList<ExecutiveAgent>();
        for (int i = 0; i < nExecutives; i++) {
            executives.add(new ExecutiveAgent(new ExecutiveModel(ExecutiveModel.ExecutiveState.IDLE)));
//            executives.get(i).start();
        }
        return executives;
    }


    private String getClientFraction(ClientModel.ClientState state) {
        return bank.getClients().stream()
                .filter(clientAgent -> clientAgent.getModel().getState() == state)
                .toList().size()
                + "/" + bank.getClients().size();
    }

    public ClientFractionsModel getClientFractions() {
        return new ClientFractionsModel(
                getClientFraction(ClientModel.ClientState.BANK_ENTRANCE),
                getClientFraction(ClientModel.ClientState.ATM_LINE),
                getClientFraction(ClientModel.ClientState.EXECUTIVE_LINE),
                getClientFraction(ClientModel.ClientState.ATM),
                getClientFraction(ClientModel.ClientState.EXECUTIVE),
                getClientFraction(ClientModel.ClientState.EXITED));
    }

    private String getAtmFraction(AtmModel.AtmState state) {
        return bank.getAtms().stream()
                .filter(atmAgent -> atmAgent.getModel().getState() == state)
                .toList().size()
                + "/" + bank.getAtms().size();
    }

    public AtmFractionsModel getAtmFractions() {
        return new AtmFractionsModel(
                getAtmFraction(AtmModel.AtmState.AVAILABLE),
                getAtmFraction(AtmModel.AtmState.OCCUPIED),
                getAtmFraction(AtmModel.AtmState.OUT_OF_ORDER));
    }

    private String getExecutivesFraction(ExecutiveModel.ExecutiveState state) {
        return bank.getExecutives().stream()
                .filter(executiveAgent -> executiveAgent.getModel().getState() == state)
                .toList().size()
                + "/" + bank.getExecutives().size();
    }

    public ExecutiveFractionsModel getExecutiveFractions() {
        return new ExecutiveFractionsModel(
                getExecutivesFraction(ExecutiveModel.ExecutiveState.IDLE),
                getExecutivesFraction(ExecutiveModel.ExecutiveState.BUSY),
                getExecutivesFraction(ExecutiveModel.ExecutiveState.TAKING_A_BREAK));
    }

    public Bank getBank() {
        return bank;
    }
}
