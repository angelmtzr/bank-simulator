package up.ppf.banksimulator.buffers;

import java.util.concurrent.Semaphore;

public class Line {
    private final Semaphore available;

    public Line(int capacity) {
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
