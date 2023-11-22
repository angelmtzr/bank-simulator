package up.ppf.banksimulator;

import up.ppf.banksimulator.models.ExecutiveModel;

public class ExecutiveAgent extends Thread {
    private final ExecutiveModel model;

    public ExecutiveAgent(ExecutiveModel model) {
        this.model = model;
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
