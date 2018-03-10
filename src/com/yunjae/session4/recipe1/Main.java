package com.yunjae.session4.recipe1;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();

        Thread threads[] = new Thread[100];

        for(int i=0; i < threads.length; i++) {
            AdTask task = new AdTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        System.out.printf("Main: %d AdTask threads have bean launched\n", threads.length);

        for(int i=0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main : size of the list %d\n", list.size());

        for(int i=0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        System.out.printf("Main: %d PollTask threads have bean launched\n", threads.length);

        for(int i=0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main : size of the list %d\n", list.size());

    }
}
