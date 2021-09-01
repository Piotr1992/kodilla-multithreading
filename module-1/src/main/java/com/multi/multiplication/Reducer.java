package com.multi.multiplication;

public class Reducer {
    private int counter;

    public synchronized void multiply(int value) {
        counter *= value;
    }

    public int getCounter() {
        return counter;
    }
}