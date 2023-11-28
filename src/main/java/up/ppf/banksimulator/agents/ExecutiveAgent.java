package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.ExecutiveModel;

import java.util.concurrent.Semaphore;

public class ExecutiveAgent extends Thread {
    private final ExecutiveModel model;
    private ClientAgent currentClient;
    private static int idClient = 1;
    private int counter;
    private final Semaphore availableSem;

    public ExecutiveAgent(ExecutiveModel model) {
        super("Executive " + idClient++);
        this.model = model;
        this.availableSem = new Semaphore(1, true);
        this.currentClient = null;
        this.counter = 0;
    }

    public ExecutiveModel getModel() {
        return model;
    }

    public boolean entered(ClientAgent client) {
        currentClient = client;
        return availableSem.tryAcquire();
    }

    public void leave() {
        currentClient = null;
        availableSem.release();
    }

    public ClientAgent getCurrentClient() {
        return currentClient;
    }

    @Override
    public void run() {
        while (true) {
//            // If he has attended 5 clients he will take a break
//            if (counter > 5) {
//                model.setState(ExecutiveModel.ExecutiveState.TAKING_A_BREAK);
            if (currentClient != null) {
                model.setState(ExecutiveModel.ExecutiveState.BUSY);
            } else {
                model.setState(ExecutiveModel.ExecutiveState.IDLE);
            }


//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            model.setState(ExecutiveModel.ExecutiveState.random());

        }
    }
}
