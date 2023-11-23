package up.ppf.banksimulator.models;

import java.util.Random;

public class ClientModel {
    public enum ClientState {
        BANK_ENTRANCE, ATM_LINE, EXECUTIVE_LINE, ATM, EXECUTIVE, EXITED;
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
