package com.multi.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int phaseNum = phaser.getPhase();

        new PhasedTask(phaser, 0);
        new PhasedTask(phaser, 1);
        new PhasedTask(phaser, 2);
        new PhasedTask(phaser, 3);
        new PhasedTask(phaser, 4);

        System.out.println("Phase " + phaseNum + " - begin");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " reached");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " reached");

        phaser.arriveAndAwaitAdvance();
        phaseNum = phaser.getPhase();
        System.out.println("Phase " + phaseNum + " reached");

        phaser.arriveAndDeregister();

        while (!phaser.isTerminated()) {
            // do nothing, just wait
        }
        System.out.println("Work is finished");
    }
}