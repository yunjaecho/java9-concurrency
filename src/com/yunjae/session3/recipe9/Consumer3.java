package com.yunjae.session3.recipe9;

import java.util.concurrent.Flow;

public class Consumer3 implements Flow.Subscriber<Item> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.printf("%s: Consumer 3: Subscription received\n", Thread.currentThread().getName());
        System.out.printf("%s: Consumer 3: No Item requested\n", Thread.currentThread().getName());
        subscription.request(3);
    }

    @Override
    public void onNext(Item item) {
        System.out.printf("%s: Consumer 3 Item received\n", Thread.currentThread().getName());
        System.out.printf("Consumer 3 title : %s , content \n", item.getTitle(), item.getContent());
    }

    @Override
    public void onError(Throwable exception) {
        System.out.printf("%s: Consumer3 : Error\n", Thread.currentThread().getName());
        exception.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.printf("%s: Consumer3 : Completed\n", Thread.currentThread().getName());
    }
}
