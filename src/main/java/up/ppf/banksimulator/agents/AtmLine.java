package up.ppf.banksimulator.agents;

import java.util.concurrent.Semaphore;

public class AtmLine {
    private final Semaphore available;

    public AtmLine(int capacity) {
        available = new Semaphore(capacity, true);
    }

    public void enter() {
        try {
            available.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void leave() {
        available.release();
    }
}
