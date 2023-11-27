package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.ExecutiveModel;

public class ExecutiveAgent extends Thread {
    private final ExecutiveModel model;
    private ClientAgent currentClient;
    private int counter;

    public ExecutiveAgent(ExecutiveModel model) {
        this.model = model;
        this.currentClient = null;
        this.counter = 0;
    }

    public ExecutiveModel getModel() {
        return model;
    }

    public void setCurrentClient(ClientAgent currentClient) {
        this.currentClient = currentClient;
    }

    public ClientAgent getCurrentClient() {
        return currentClient;
    }

    @Override
    public void run() {
        while (true) {
            // If he has attended 5 clients he will take a break
            if (counter > 5) {
                model.setState(ExecutiveModel.ExecutiveState.TAKING_A_BREAK);
            } else if (currentClient != null) {
                model.setState(ExecutiveModel.ExecutiveState.BUSY);
                counter++;
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
