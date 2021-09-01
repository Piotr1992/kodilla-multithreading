package com.multi.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

//public class DbManager implements Runnable {
public class FileManager implements Runnable {

    private static int counter;
    private static Semaphore semaphore = new Semaphore(10);             //          5

    @Override
    public void run() {
        try {
            semaphore.acquire();
//            connect();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

//    private void connect() throws InterruptedException {
    private void download() throws InterruptedException {
        Random random = new Random();
//        synchronized (DbManager.class) {
        synchronized (FileManager.class) {
            counter++;
//            System.out.println("There is/are " + counter + " connections");
            System.out.println("Download " + counter + " files");
        }
        Thread.sleep(random.nextInt(100));
//        synchronized (DbManager.class) {
        synchronized (FileManager.class) {
            counter--;
        }
    }
}