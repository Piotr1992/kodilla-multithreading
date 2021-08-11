package com.kodilla.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final FirstProcessor firstProcessor = new FirstProcessor();
        final SecondProcessor secondProcessor = new SecondProcessor();
        final Future<Integer> futureFirstResult = firstProcessor.process(9);
        final Future<Integer> futureSecondResult = secondProcessor.process(9);

        while (!futureFirstResult.isDone() && !futureSecondResult.isDone()) {
            System.out.println("Executing something yet FIRST...");
            System.out.println("Executing something yet SECOND...");
            sleep(1);
        }

        final Integer resultFirst = futureFirstResult.get();
        System.out.println("Result FIRST -> " + resultFirst);
        final Integer resultSecond = futureSecondResult.get();
        System.out.println("Result SECOND -> " + resultSecond);
    }
}