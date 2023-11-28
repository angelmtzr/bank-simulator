package up.ppf.banksimulator.buffers;

import java.util.concurrent.Semaphore;

public class Line {
    private final Semaphore available;

    public Line(int capacity) {
        available = new Semaphore(capacity, true);
    }

    public boolean couldNotEnter() {
        return !available.tryAcquire();
    }

    public void leave() {
        available.release();
    }
}
