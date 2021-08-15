package com.kodilla.completable;

import com.kodilla.completable.homework.Book;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static com.kodilla.util.SleepUtil.sleep;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final MessageReceiver messageBook = new MessageReceiver();

        final CompletableFuture<Void> futureMessageBook = messageBook.waiting()
                .thenApply(Book::getCaption)
                .thenAccept(message -> new Book("title", "author", 2000, ""));
        sleep(1);
        System.out.println("Doing something else");
        futureMessageBook.get();

        Book book = messageBook.waiting().get();

        book.setCaption("Jan Kowalski");

        System.out.println(book.getCaption());

//        System.out.println(messageBook.waiting().get().getCaption());

/*        final MessageReceiver messageReceiver = new MessageReceiver();
        final CompletableFuture<Void> futureMessage = messageReceiver.receive()
                .thenApply(String::toUpperCase)
                .thenAccept(message -> System.out.println("Message is " + message));
        sleep(1);
        System.out.println("Doing something else");
        futureMessage.get();                            */

    }
}