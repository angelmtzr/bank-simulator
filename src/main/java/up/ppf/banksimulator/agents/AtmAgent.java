package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.AtmModel;

public class AtmAgent extends Thread {
    private final AtmModel model;
    private ClientAgent currentClient;
    private static int idClient = 1;
    private int counter;

    public AtmAgent(AtmModel model) {
        super("Atm  " + idClient++);
        this.model = model;
        this.currentClient = null;
        this.counter = 0;
    }

    public AtmModel getModel() {
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
            // If he has attended 5 clients it goes out of order
            if (counter > 5) {
                model.setState(AtmModel.AtmState.OUT_OF_ORDER);
            } else if (currentClient != null) {
                model.setState(AtmModel.AtmState.OCCUPIED);
                counter++;
            } else {
                model.setState(AtmModel.AtmState.AVAILABLE);
            }


//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            model.setState(AtmModel.AtmState.random());
        }
    }
}
