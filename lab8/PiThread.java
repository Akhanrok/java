package lab8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PiThread extends Thread {
    private static final Random random = ThreadLocalRandom.current();
    private final long iterations;
    private int pointsWithinCircle = 0;

    public PiThread(long iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for(long i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if(Math.sqrt(x * x + y * y) <= 1) {
                pointsWithinCircle++;
            }
        }
    }

    public int getPointsWithinCircle() {
        return pointsWithinCircle;
    }
}
