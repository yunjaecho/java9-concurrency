package com.yunjae.session1.recipe8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        ResultTask resultTask[] = new ResultTask[5];

        for (int i = 0; i < 5; i++) {
            ExecutableTask executableTask = new ExecutableTask("Task"+ i);
            resultTask[i] = new ResultTask(executableTask);
            executor.submit(resultTask[i]);
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            resultTask[i].cancel(true);
        }

        for (int i = 0; i < 5; i++) {
            try {
                if (!resultTask[i].isCancelled()) {
                    System.out.printf("%s\n", resultTask[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
