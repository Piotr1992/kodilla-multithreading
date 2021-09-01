package com.kodilla.completable;

import com.kodilla.completable.homework.Book;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static com.kodilla.util.SleepUtil.sleep;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final MessageReceiver messageBook = new MessageReceiver();

        final CompletableFuture<Book> futureMessageBook = messageBook.waiting()
                .thenApply(book -> {
                    book.setCaption("Signature");
                    return book;
                });
        sleep(1);
        System.out.println("Doing something else");
        Book book = futureMessageBook.get();

        System.out.println(book);


/*        final MessageReceiver messageReceiver = new MessageReceiver();
        final CompletableFuture<Void> futureMessage = messageReceiver.receive()
                .thenApply(String::toUpperCase)
                .thenAccept(message -> System.out.println("Message is " + message));
        sleep(1);
        System.out.println("Doing something else");
        futureMessage.get();            */

    }
}