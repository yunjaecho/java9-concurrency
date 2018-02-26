package com.yunjae.executResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>(10);

        Random random = new Random();

        /*resultList.stream().map(s -> {
            return executor.submit(new FactorialClaculator(random.nextInt(10)));
        });*/

        for (int i = 0; i < 10; i++) {
            resultList.add(executor.submit(new FactorialClaculator(random.nextInt(10))));
        }


        do {
            System.out.printf("Main : Number Completed Taks:  %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d : %s\n", i, result.isDone());
            }

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size());

        System.out.printf("Main : executor.getCompletedTaskCount() : %d\n", executor.getCompletedTaskCount());
        System.out.printf("Main : Results\n");

        for (int i =0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;

            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Core: Task %d : %d\n", i, number);
        }

        executor.shutdown();


    }
}
