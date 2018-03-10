package com.yunjae.session4.recipe1;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask implements Runnable {
    private final ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        list.pollFirst();
        list.pollLast();
    }
}
