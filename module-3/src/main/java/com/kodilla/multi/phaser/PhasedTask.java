package com.kodilla.multi.phaser;

import java.util.concurrent.Phaser;

public class PhasedTask implements Runnable {
    private Phaser phaser;
    private int number;

    PhasedTask(Phaser phaser, int number) {
        this.phaser = phaser;
        this.number = number;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Process number " + number + " phase 0 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 1 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 2 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " phase 3 entered");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();

        System.out.println("Process number " + number + " finish reached");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
    }
}