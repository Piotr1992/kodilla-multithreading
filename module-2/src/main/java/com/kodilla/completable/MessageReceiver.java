package com.kodilla.completable;

import com.kodilla.completable.homework.Book;

import java.util.concurrent.CompletableFuture;

import static com.kodilla.util.SleepUtil.sleep;

public class MessageReceiver {

    public CompletableFuture<String> receive() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for message...");
            sleep(5);
            return "Hello";
        });
    }

    public CompletableFuture<Book> waiting() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for book...");
            sleep(7);
            return new Book("title", "author", 1987, "");
        });
    }

}