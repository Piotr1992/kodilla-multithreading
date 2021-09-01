package com.multi.deadlock;

public class ProcessA implements Runnable {
    private static final Object lock = new Object();
    @Override
    public void run() {
        try {
            synchronized (lock) {
                Thread.sleep(50);
                System.out.println("Process A, part 1");
                Thread.sleep(50);
                System.out.println("Process A, part 2");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}