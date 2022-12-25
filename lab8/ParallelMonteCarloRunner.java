package lab8;

import java.util.Scanner;

public class ParallelMonteCarloRunner {
    public static final long iterations = 1000000000;

    public static void main(String[] args) {
        System.out.print("Введіть кількість потоків: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfThreads = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        ParallelMonteCarloPi monteCarloPi = new ParallelMonteCarloPi(numberOfThreads);
        double pi = monteCarloPi.countPi();

        System.out.println("PI is " + pi);
        System.out.println("THREADS " + numberOfThreads);
        System.out.println("ITERATIONS " + iterations);
        System.out.println("TIME " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
