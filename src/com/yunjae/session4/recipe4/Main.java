package com.yunjae.session4.recipe4;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Event> queue = new DelayQueue<>();

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

        do {
            int counter = 0;
            Event event;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while(event != null);
            System.out.printf("At %s you are read %d event\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while(queue.size() > 0);
    }
}
