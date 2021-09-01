package com.kodilla.threads.homework;

public class ThreadCreator implements Runnable {

    private final int num;

    public ThreadCreator(int num) {
        this.num = num;
        new Thread(() -> run());            //      new Thread(this::run);      new Thread(this);
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread number " + num);
        if (num != 50) {
            final Thread thread = new com.kodilla.threads.ThreadCreator(num + 1);
            thread.start();
        }
    }
}