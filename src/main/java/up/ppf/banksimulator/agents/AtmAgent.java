package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.AtmModel;

public class AtmAgent extends Thread {
    private final AtmModel model;

    public AtmAgent(AtmModel model) {
        this.model = model;
    }

    public AtmModel getModel() {
        return model;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            model.setState(AtmModel.AtmState.random());
        }
    }
}
