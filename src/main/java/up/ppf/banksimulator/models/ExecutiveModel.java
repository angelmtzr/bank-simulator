package up.ppf.banksimulator.models;

import java.util.Random;

public class ExecutiveModel {
    public enum ExecutiveState {
        IDLE, BUSY, TAKING_A_BREAK;
        private static final Random rand = new Random();

        public static ExecutiveState random() {
            ExecutiveState[] states = values();
            return states[rand.nextInt(states.length)];
        }
    }

    private ExecutiveState state;

    public ExecutiveModel(ExecutiveState state) {
        this.state = state;
    }

    public ExecutiveState getState() {
        return state;
    }

    public void setState(ExecutiveState state) {
        this.state = state;
    }
}
