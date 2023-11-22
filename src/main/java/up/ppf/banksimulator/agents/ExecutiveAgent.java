package up.ppf.banksimulator.agents;

import up.ppf.banksimulator.models.ExecutiveModel;

public class ExecutiveAgent extends Thread {
    private final ExecutiveModel model;

    public ExecutiveAgent(ExecutiveModel model) {
        this.model = model;
    }

    public ExecutiveModel getModel() {
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
            model.setState(ExecutiveModel.ExecutiveState.random());
        }
    }
}
