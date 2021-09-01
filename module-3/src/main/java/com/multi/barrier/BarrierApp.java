package com.multi.barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class BarrierApp {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        int sumaA = 1000,
            sumaB = 0,
            iterator = 0;

        Random random = new Random();

        for (int n = 0; n < 5; n++) {
            launchTheThread(barrier, n);
            sumaA = 1000;
            sumaB = 0;
            iterator = 0;
            while (sumaA > sumaB) {
                iterator++;
                sumaA += random.nextInt(10);
                sumaB += random.nextInt(50);
                System.out.println("Iteracja pętli numer: " + iterator + "; sumaA: " + sumaA + "; sumaB: " + sumaB);
            }
        }

    }

    private static void launchTheThread(CyclicBarrier barrier, int number) {
        new PartialStep(barrier, number);
    }
}