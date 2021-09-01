package com.kodilla.future;

import com.kodilla.util.SleepUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Processor {

    public Future<Integer> process(int x) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Processor started processing");
            SleepUtil.sleep(5);
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }
}