package com.yunjae.session2.recipe5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Title : Cancelling a Task
 *   Cancelling ForkJoningTask objects
 *   Execute object in a pool class - Cancel prior execution starts
 *   Doesn't provide method to cancel
 *     - Running task
 *     - Waiting task
 *   Can't cancel already execution task
 *
 *   Problem  - Doesn't cancel tasks that entered ForkJoinPool
 *   Solution - TaskManager class : Stores task, Cancel stored tasks
 *
 *   Task finds number - Cancels remaining tasks
 *   Not provided by fork/join framework
 *      - Auxiliary class implemented
 */
public class Main {
    public static void main(String[] args) {
        // Generate an array of 1000 integers
        ArrayGenerator generator = new ArrayGenerator();
        int[] array = generator.generatorArray(1000);

        // Create a TaskManger object
        TaskManager manager = new TaskManager();

        // Create a ForkJoinPool with the default constructor
        ForkJoinPool pool = new ForkJoinPool();

        // Create a task to process the array
        SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);

        //Execute the task
        pool.execute(task);

        // Shutdown the pool
        pool.shutdown();

        try {
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main: The program has finished");
    }
}
