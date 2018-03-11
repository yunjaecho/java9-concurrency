package com.yunjae.session4.recipe3;

import lombok.Getter;

@Getter
public class Event implements Comparable<Event> {
    private final int thread;
    private final int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    @Override
    public int compareTo(Event o) {
        if (priority > o.getPriority()) {
            return -1;
        } else if (priority < o.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }
}
