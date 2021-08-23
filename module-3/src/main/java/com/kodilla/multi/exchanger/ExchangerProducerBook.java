package com.kodilla.multi.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerProducerBook implements Runnable {

    private Exchanger<Book> exchanger;

    ExchangerProducerBook(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        Random random = new Random(10);
        int randNum = random.nextInt();
        try {
            exchanger.exchange(new Book("Title number " + randNum, "Author number " + randNum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
