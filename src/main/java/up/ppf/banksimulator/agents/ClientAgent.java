package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.Bank;
import up.ppf.banksimulator.models.ClientModel;

import java.util.Random;

public class ClientAgent extends Thread {
    private final ClientModel model;
    private final Bank bank;
    private static int idClient = 1;
    private ExecutiveAgent currentExecutive = null;
    private AtmAgent currentAtm = null;

    public ClientAgent(Bank bank, ClientModel model) {
        super("Client " + idClient++);
        this.model = model;
        this.bank = bank;

    }

    public ClientModel getModel() {
        return model;
    }

    public ExecutiveAgent getCurrentExecutive() {
        return currentExecutive;
    }

    public void setCurrentExecutive(ExecutiveAgent currentExecutive) {
        this.currentExecutive = currentExecutive;
    }

    public AtmAgent getCurrentAtm() {
        return currentAtm;
    }

    public void setCurrentAtm(AtmAgent currentAtm) {
        this.currentAtm = currentAtm;
    }

    public ClientModel.ClientState getActionDecision() {
        var rand = new Random();
        var states = new ClientModel.ClientState[]{
                ClientModel.ClientState.ATM,
                ClientModel.ClientState.EXECUTIVE
        };
        goToSleep(5000); // Time to decide action
        return states[rand.nextInt(states.length)];
    }


    public void atm() {
        if (bank.getAtmLine().couldNotEnter()) {
            return; // If no room in line, leave
        }
        // ATM LINE ------------------------
        model.setState(ClientModel.ClientState.ATM_LINE);
        goToSleep(5000);
        AtmAgent atm;
        while (true) {
            goToSleep(1500);
            atm = bank.getAvailableAtm();
            if (atm == null)
                continue;
            if (atm.entered(this))
                break;
        }
        bank.getAtmLine().leave();
        // ATM ------------------------
        model.setState(ClientModel.ClientState.ATM);
        currentAtm = atm;
        goToSleep(7000);
        atm.leave();
        // ATM LINE ------------------------
        currentAtm = null;
    }

    public void executive() {
        if (bank.getExecutiveLine().couldNotEnter()) {
            return; // If no room in line, leave
        }
        // EXECUTIVE LINE ------------------------
        model.setState(ClientModel.ClientState.EXECUTIVE_LINE);
        goToSleep(5000);
        ExecutiveAgent executive;
        while (true) {
            goToSleep(1500);
            executive = bank.getAvailableExecutive();
            if (executive == null)
                continue;
            if (executive.entered(this))
                break;
        }
        bank.getExecutiveLine().leave();
        // EXECUTIVE ------------------------
        currentExecutive = executive;
        model.setState(ClientModel.ClientState.EXECUTIVE);
        goToSleep(7000);
        executive.leave();
        currentExecutive = null;
    }

    @Override
    public void run() {
        switch (getActionDecision()) {
            case ATM -> atm();
            case EXECUTIVE -> executive();
        }
//        goToSleep(3000);
        model.setState(ClientModel.ClientState.EXITED);
    }

    private void setCurrentService(boolean set, AtmAgent atm, ExecutiveAgent executive) {
        if (!set) {
            setCurrentAtm(null);
            setCurrentExecutive(null);
        } else if (atm == null) {
            setCurrentExecutive(executive);
        } else if (executive == null) {
            setCurrentAtm(atm);
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
