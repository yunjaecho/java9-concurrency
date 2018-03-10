package com.yunjae.session3.recipe9;

import java.util.concurrent.Flow;

public class Consumer1 implements Flow.Subscriber<Item> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.printf("%s: Consumer 1: Subscription received\n", Thread.currentThread().getName());
        System.out.printf("%s: Consumer 1: Item requested\n", Thread.currentThread().getName());
    }

    @Override
    public void onNext(Item item) {
        System.out.printf("%s: Consumer 1 Item received\n", Thread.currentThread().getName());
        System.out.printf("Consumer title : %s , content \n", item.getTitle(), item.getContent());
    }

    @Override
    public void onError(Throwable exception) {
        System.out.printf("%s: Consumer1 : Error\n", Thread.currentThread().getName());
        exception.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.printf("%s: Consumer1 : Completed\n", Thread.currentThread().getName());
    }
}
