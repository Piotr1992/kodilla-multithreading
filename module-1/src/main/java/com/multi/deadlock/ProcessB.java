package com.multi.deadlock;

public class ProcessB implements Runnable {
    private static final Object lock = new Object();
    @Override
    public void run() {
        try {
            synchronized (lock) {
                Thread.sleep(50);
                System.out.println("Process B, part 1");
                Thread.sleep(50);
                System.out.println("Process B, part 2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}