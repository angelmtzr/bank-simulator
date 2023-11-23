package up.ppf.banksimulator.models;

import java.util.Random;

public class AtmModel {
    public enum AtmState {
        AVAILABLE, OCCUPIED, OUT_OF_ORDER;
        private static final Random rand = new Random();

        public static AtmModel.AtmState random() {
            AtmModel.AtmState[] states = values();
            return states[rand.nextInt(states.length)];
        }

    }

    private AtmState state;

    public AtmModel(AtmState state) {
        this.state = state;
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
    }
}
