package up.ppf.banksimulator.models;

import up.ppf.banksimulator.Bank;
import up.ppf.banksimulator.agents.ClientAgent;

public class DetailedStateTableModel {
    private Bank bank;

    public DetailedStateTableModel(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public ClientAgent getClient(int id) {
        return bank.getClients().stream()
                .filter(clientAgent -> clientAgent.getName().equals("Client " + id))
                .findFirst()
                .orElse(null);

    }

    public ExecutiveModel.ExecutiveState getExecutive(int id) {
        return bank.getExecutives().stream()
                .filter(executiveAgent -> executiveAgent.getName().equals("Executive " + id))
                .findFirst().get()
                .getModel().getState();

    }

    public AtmModel.AtmState getAtm(int id) {
        return bank.getAtms().stream()
                .filter(atmAgent -> atmAgent.getName().equals("Atm " + id))
                .findFirst().get()
                .getModel().getState();

    }
}
