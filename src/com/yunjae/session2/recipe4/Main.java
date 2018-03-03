package com.yunjae.session2.recipe4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Throwing Exception int the Tasks
 * Method to detect exception and its kind
 * Checked Exception
 *   - Doesn't include throws declaration
 *     Include code to handle exception
 *     Specified in throw clause Caught inside method
 * Unchecked Exception
 *   - Not specified or caught
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];

        Task task = new Task(array, 0, 100);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        pool.shutdown();

        //Wait for the finalization of the task
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // isCompletedAbnormally return boolean (if this task threw an exception or was cancelled)
        if (task.isCompletedAbnormally()) {
            System.out.println("Main: An exception has occurred");
            System.out.printf("Main: %s\n", task.getException());
        }

        System.out.printf("Main: Result: %d", task.join());
    }
}
