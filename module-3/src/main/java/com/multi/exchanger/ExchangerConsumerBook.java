package com.multi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerConsumerBook implements Runnable {

    private Exchanger<Book> exchanger;

    ExchangerConsumerBook(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Book book = exchanger.exchange(new Book("", ""));
            System.out.println(book);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
