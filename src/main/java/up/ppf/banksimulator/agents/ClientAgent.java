package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.ClientModel;

import java.util.Random;

public class ClientAgent extends Thread {
    private final ClientModel model;

    public ClientAgent(ClientModel model) {
        this.model = model;
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


//    public void atm() {
//        atmLine.acquire();
//        model.setState(ClientModel.ClientState.ATM_LINE);
//        goToSleep(3000);
//        atmLine.release();
//        model.setState(ClientModel.ClientState.ATM);
//        goToSleep(7000);
//         TODO: Assign atm
//    }
//
//    public void executive() {
//        executiveLine.acquire();
//        model.setState(ClientModel.ClientState.EXECUTIVE_LINE);
//        goToSleep(3000);
//        executiveLine.release();
//        model.setState(ClientModel.ClientState.EXECUTIVE);
//    }

    @Override
    public void run() {
        while (true) {
            goToSleep(2000);
            model.setState(ClientModel.ClientState.random());
        }
//        switch (getActionDecision()) {
//            case ATM -> atm();
//            case EXECUTIVE -> executive();
//        }

    }

    private static void goToSleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
