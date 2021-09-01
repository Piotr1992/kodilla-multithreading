package com.kodilla.producerconsumer.database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Database {

    private List<Customer> customerList = new ArrayList<>();

    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotEmpty = lock.newCondition();
    private final Condition bufferNotFull = lock.newCondition();

    private static final int CAPACITY = 5;

    public void insert() throws InterruptedException {
        lock.lock();
        try {
            while (customerList.size() == CAPACITY) {
                System.out.println("[PRODUCER] Waiting - database is full");
                bufferNotEmpty.await();
            }

            Customer customer = new Customer("John", "Kowalski");
            customerList.add(customer);
            System.out.println("[PRODUCER] Added to database: " + customerList.get(0).hashCode());

            System.out.println("[SIGNAL] Database is not empty from now");
            bufferNotFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void select() throws InterruptedException {
        lock.lock();
        try {
            while (customerList.size() == 0) {
                System.out.println("[CONSUMER] Waiting - no customers in database");
                bufferNotFull.await();
            }

            System.out.println("[CONSUMER] Consumed customer: " + customerList.get(0).hashCode());
            customerList.clear();

            System.out.println("[SIGNAL] Database may be empty from now");
            bufferNotEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
