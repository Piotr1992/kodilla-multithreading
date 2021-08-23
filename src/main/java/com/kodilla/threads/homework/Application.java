package com.kodilla.threads.homework;

public class Application {

    public static void main(String[] args) {
        final ThreadCreator threadCreator = new ThreadCreator(1);
        threadCreator.run();            //.start();
    }
}
