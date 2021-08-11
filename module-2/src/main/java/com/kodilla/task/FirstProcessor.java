package com.kodilla.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class FirstProcessor {

    public Future<Integer> process(int x) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Start FIRST processing...");
            sleep(9);
            System.out.println("End FIRST processing!");
            return x * 1000;
        });
    }
}