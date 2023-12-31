package up.ppf.banksimulator.models;

import java.util.Random;

public class ClientModel {
    public enum ClientState {
        BANK_ENTRANCE(1), ATM_LINE(2), EXECUTIVE_LINE(3), ATM(4), EXECUTIVE(5), EXITED(6);
        private int value;

        ClientState(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private static final Random rand = new Random();

        public static ClientModel.ClientState random() {
            ClientModel.ClientState[] states = values();
            return states[rand.nextInt(states.length)];
        }
    }

    private ClientState state;

    public ClientModel(ClientState state) {
        this.state = state;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }
}
