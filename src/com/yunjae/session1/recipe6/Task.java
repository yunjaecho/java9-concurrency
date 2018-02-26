package com.yunjae.session1.recipe6;

import java.util.Date;

public class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Executed at : %s\n", name, new Date());
    }
}
