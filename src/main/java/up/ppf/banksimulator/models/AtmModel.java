package up.ppf.banksimulator.models;

public class AtmModel {
    public enum AtmState {AVAILABLE, OCCUPIED, OUT_OF_ORDER}

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
