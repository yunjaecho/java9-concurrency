package com.yunjae.session1.recipe8;

import java.util.concurrent.FutureTask;

public class ResultTask extends FutureTask<String> {
    private final String name;

    public ResultTask(ExecutableTask callable) {
        super(callable);
        this.name = callable.getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been cancelled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }
        super.done();
    }

    @Override
    public boolean isDone() {
        return super.isDone();
    }
}
