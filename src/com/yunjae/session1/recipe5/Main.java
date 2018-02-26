package com.yunjae.session1.recipe5;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Main: String at : %s\n", new Date());

        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            executor.schedule(task, i+1, TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(2, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Core: Ends at: %s\n", new Date());
    }
}
