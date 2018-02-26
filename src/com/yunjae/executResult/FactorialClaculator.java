package com.yunjae.executResult;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialClaculator implements Callable<Integer> {

    private final Integer number;

    public FactorialClaculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;

        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i ++) {
                result*= i;
                TimeUnit.MILLISECONDS.sleep(10);
            }
        }
        return result;
    }
}
