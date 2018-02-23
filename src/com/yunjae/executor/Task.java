package com.yunjae.executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private final Date initDate;
    private final String name;

    public Task(String name) {
        initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Create on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s: Create on: %s\n", Thread.currentThread().getName(), name, new Date());

        try {
            Long duration = (long)(Math.random() * 10);
            System.out.printf("%s Task %s Doing as task during %d seconds\n", Thread.currentThread().getName(), name, duration);

            TimeUnit.SECONDS.sleep(duration);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finish on: %s\n", Thread.currentThread().getName(), new Date(), name);
    }
}
