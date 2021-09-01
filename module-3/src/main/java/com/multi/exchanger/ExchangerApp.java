package com.multi.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerApp {

    public static void main(String[] args) {

//          TASK
        Exchanger<Book> exchanger = new Exchanger<>();

        new ExchangerConsumerBook(exchanger);
        new ExchangerProducerBook(exchanger);



//          EXAMPLE
/*        Exchanger<String> exchanger = new Exchanger<>();

        new ExchangerConsumer(exchanger);
        new ExchangerProducer(exchanger);           */

    }
}