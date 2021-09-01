package com.multi.simple;

public class Counter extends Thread {

    @Override
    public void run() {
        for (int n = 0; n < 20; n++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ", Current value: " + n);
        }
    }
}