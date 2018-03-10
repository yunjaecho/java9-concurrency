package com.yunjae.session3.recipe9;

import java.util.concurrent.Flow;

public class Consumer2 implements Flow.Subscriber<Item> {
    private Flow.Subscription subscription;


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.printf("%s: Consumer 2: Subscription received\n", Thread.currentThread().getName());
        System.out.printf("%s: Consumer 2: Item requested\n", Thread.currentThread().getName());
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Item item) {
        System.out.printf("%s: Consumer 2 Item received\n", Thread.currentThread().getName());
        System.out.printf("Consumer 2 title : %s , content \n", item.getTitle(), item.getContent());
        subscription.request(1);
    }

    @Override
    public void onError(Throwable exception) {
        System.out.printf("%s: Consumer2 : Error\n", Thread.currentThread().getName());
        exception.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.printf("%s: Consumer2 : Completed\n", Thread.currentThread().getName());
    }
}
