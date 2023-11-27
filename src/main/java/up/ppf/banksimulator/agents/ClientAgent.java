package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.Bank;
import up.ppf.banksimulator.models.AtmModel;
import up.ppf.banksimulator.models.ClientModel;
import up.ppf.banksimulator.models.ExecutiveModel;

import java.util.Random;

public class ClientAgent extends Thread {
    private final ClientModel model;
    private final Bank bank;
    private static int idClient = 1;

    public ClientAgent(Bank bank, ClientModel model) {
        super("Client " + idClient++);
        this.model = model;
        this.bank = bank;

    }

    public ClientModel getModel() {
        return model;
    }

    public ClientModel.ClientState getActionDecision() {
        var rand = new Random();
        var states = new ClientModel.ClientState[]{
                ClientModel.ClientState.ATM,
                ClientModel.ClientState.EXECUTIVE
        };
        goToSleep(4000); // Time to decide action
        return states[rand.nextInt(states.length)];
    }


    public void atm() {
        bank.getAtmLine().enter();
        model.setState(ClientModel.ClientState.ATM_LINE);
        goToSleep(3000);
        bank.getAtmLine().leave();
//         TODO: Assign atm
        var atm = bank.getAtms().stream()
                .filter(atmAgent -> atmAgent.getModel().getState() == AtmModel.AtmState.AVAILABLE)
                .findFirst();
        atm.ifPresent(atmAgent -> atmAgent.setCurrentClient(this));
        model.setState(ClientModel.ClientState.ATM);
        // TODO: Model when with atm
        goToSleep(1000);
        //When exiting current client is set to null
        atm.ifPresent(atmAgent -> atmAgent.setCurrentClient(null));
        model.setState(ClientModel.ClientState.EXITED);

    }

    public void executive() {
        bank.getExecutiveLine().enter();
        model.setState(ClientModel.ClientState.EXECUTIVE_LINE);
        goToSleep(3000);
        bank.getExecutiveLine().leave();
//         TODO: Assign Executive
        var executive = bank.getExecutives().stream()
                .filter(executiveAgent -> executiveAgent.getModel().getState() == ExecutiveModel.ExecutiveState.IDLE)
                .findFirst();
        executive.ifPresent(executiveAgent -> executiveAgent.setCurrentClient(this));
        model.setState(ClientModel.ClientState.EXECUTIVE);
        // TODO: Model when with executive
        goToSleep(1000);
        //When exiting current client is set to null
        executive.ifPresent(executiveAgent -> executiveAgent.setCurrentClient(null));
        model.setState(ClientModel.ClientState.EXITED);

    }


    @Override
    public void run() {
//        while (model.getState() != ClientModel.ClientState.EXITED) {
//            goToSleep(2000);
//            model.setState(ClientModel.ClientState.random());
//        }
        switch (getActionDecision()) {
            case ATM -> atm();
            case EXECUTIVE -> executive();
        }

    }

    private static void goToSleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
