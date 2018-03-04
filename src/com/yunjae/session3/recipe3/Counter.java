package com.yunjae.session3.recipe3;

import lombok.Data;

@Data
public class Counter {
    private String value;
    private int counter;

    public Counter() {
        counter = 1;
    }

    public void increment() {
        counter++;
    }
}
