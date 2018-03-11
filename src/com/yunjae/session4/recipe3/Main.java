package com.yunjae.session4.recipe3;


import java.util.concurrent.PriorityBlockingQueue;

/**
 *  Using Blocking Thread-Safe Queue Ordered by Priority
 */
public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();

        Thread taskThreads[] = new Thread[5];

        for(int i=0; i<taskThreads.length; i++) {
            Task task = new Task(i, queue);
            taskThreads[i] = new Thread(task);
        }

        for(int i=0; i<taskThreads.length; i++) {
            taskThreads[i].start();
        }

        for(int i=0; i<taskThreads.length; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Queues Size: %d\n", queue.size());
        for(int i=0; i<taskThreads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s Priority %d\n", event.getThread(), event.getPriority());
        }

        System.out.printf("Main: Queue size: %d\n", queue.size());
        System.out.println("Main: End of the program");

    }
}
