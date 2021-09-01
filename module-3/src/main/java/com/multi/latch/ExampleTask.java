package com.multi.latch;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class ExampleTask implements Runnable {

    private CountDownLatch theLatch;
    private Instant someTime;

    public ExampleTask(CountDownLatch theLatch) {
        this.theLatch = theLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {

        for (int n = 0; n < 5; n++) {
            someTime = Instant.ofEpochMilli(
                    ThreadLocalRandom.current().nextLong(500, 2000)
            );
            doTask();
        }
    }

    private void doTask() {
        System.out.println("Running the task");
        theLatch.countDown();
        System.out.println("someTime = " + someTime);
    }
}