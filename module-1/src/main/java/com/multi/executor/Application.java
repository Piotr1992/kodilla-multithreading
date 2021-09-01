package com.multi.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

/*        for (int n = 0; n < 1000; n++) {
            executor.submit(new Task());
        }           */

        int[] firstTab = new int[100000];
        int[] secondTab = new int[100000];
        long[] resultTab = new long[100000];

        for (int n = 0; n < 100000; n++) {
            firstTab[n] = n;
            secondTab[n] = n;
        }

        for (int n = 0; n < 100000; n++) {
            resultTab[n] = firstTab[n] * secondTab[n];
            executor.submit(new Task(), resultTab);
        }

        executor.shutdown();

/*
 *
 *           int 	 ->   zakres liczb wynosi od -2,147,483,648 do 2,147,483,647
 *           long	 ->   zakres liczb wynosi od -9,223,372,036,854,775,808 do 9,223,372,036,854,775,807
 *           ponieważ
 *           100,000 INT   *   100,000 INT   =   10,000,000,000 LONG
 *
 * */

    }
}