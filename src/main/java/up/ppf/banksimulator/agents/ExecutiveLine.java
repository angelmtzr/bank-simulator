package up.ppf.banksimulator.agents;

import java.util.concurrent.Semaphore;

public class ExecutiveLine {
    private final int MAX_AVAILABLE;
    private final Semaphore available;

    public ExecutiveLine(int capacity) {
        MAX_AVAILABLE = capacity;
        available = new Semaphore(MAX_AVAILABLE, true);
    }
}
