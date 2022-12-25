package lab8;

public class ParallelMonteCarloPi {
    private final int numberOfThreads;

    public ParallelMonteCarloPi(int t) {
        this.numberOfThreads = t;
    }

    public double countPi() {
        int totalPointsWithinCircle = 0;
        long IterationsPerThread = ParallelMonteCarloRunner.iterations / numberOfThreads;
        PiThread[] threads = new PiThread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            PiThread t = new PiThread(IterationsPerThread);
            t.start();
            threads[i] = t;
        }

        for (PiThread t : threads) {
            try {
                t.join();
            }
            catch (InterruptedException ignored) {
            }
        }

        for (PiThread t : threads) {
            totalPointsWithinCircle += t.getPointsWithinCircle();
        }

        return (double) 4 * totalPointsWithinCircle / (IterationsPerThread * numberOfThreads);
    }
}
