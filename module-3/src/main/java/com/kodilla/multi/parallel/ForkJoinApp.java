package com.kodilla.multi.parallel;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApp {

    public static void main(String[] args) {

//      Task 3.2

        List<Country> countries = Countries.randomCountries(15);

        ForkJoinPool thePool = new ForkJoinPool();

        Long result = thePool.invoke(new CountryProcessTask(countries));

        System.out.println(result);



/*      Example

        List<Book> books = Books.randomBooks(1000);
        ForkJoinPool thePool = new ForkJoinPool();
        Long result = thePool.invoke(new BookProcessTask(books));
        System.out.println(result);                     */



    }
}