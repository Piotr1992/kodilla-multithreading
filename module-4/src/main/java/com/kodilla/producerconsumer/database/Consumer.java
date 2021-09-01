package com.kodilla.producerconsumer.database;

import java.util.Random;

public class Consumer extends Thread {

    private final Database database;

    public Consumer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        int counter = 0;
        final Random random = new Random();
        try {
            while (counter < 3) {
                database.select();
                Thread.sleep(random.nextInt(1000));
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}