package com.yunjae.session4.recipe1;

import java.util.concurrent.ConcurrentLinkedDeque;

public class AdTask implements Runnable {
    private final ConcurrentLinkedDeque<String> list;

    public AdTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i=0; i<10000; i++) {
            list.add(name + ": Element " + i);
        }

    }
}
