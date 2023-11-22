package up.ppf.banksimulator.models;

public class ClientModel {
    public enum ClientState {BANK_ENTRANCE, ATM_LINE, EXECUTIVE_LINE, ATM, EXECUTIVE}

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
