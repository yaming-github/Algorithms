package algrorithm;

import java.util.Scanner;

public class Test {
    public static double time(String alg, Integer[] a, int N) {
        long startTime = System.nanoTime();
        if (alg.equals("Insertion"))
            Insertion.sort(a);
        if (alg.equals("Merge"))
            Merge.sort(a);
        if (alg.equals("MergeBU"))
            MergeBU.sort(a);
        if (alg.equals("Quick"))
            Quick.sort(a);
        if (alg.equals("Quick3way"))
            Quick3way.sort(a, 0, N);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static double timeRandomInput(String alg, int N) {
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int t = 0; t < 10; t++) {

            for (int i = 0; i < N; i++)
                a[i] = (int) (1 + Math.random() * 50);
            total += time(alg, a, N);
        }
        return total / 10;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Merge";
        String alg3 = "MergeBU";
        String alg4 = "Quick";
        String alg5 = "Quick3Way";
        System.out.println("Please input the length of the sort:");
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.println("Insertion total time is:" + timeRandomInput(alg1, N));
        System.out.println("Merge total time is:" + timeRandomInput(alg2, N));
        System.out.println("MergeBU total time is:" + timeRandomInput(alg3, N));
        System.out.println("Quick total time is:" + timeRandomInput(alg4, N));
        System.out.println("Quick3way total time is:" + timeRandomInput(alg5, N));
    }

}
