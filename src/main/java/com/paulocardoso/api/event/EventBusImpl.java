package com.paulocardoso.api.event;

import com.paulocardoso.api.command.CommandHandler;

import java.util.*;

public class EventBusImpl implements EventBus {

    List<Subscribable> subscribers = new ArrayList<>();

    @Override
    public void register(Subscribable subscribable) {
        subscribers.add(subscribable);
    }

    @Override
    public void dispatch(Event<?> event) {
        subscribers.stream()
                .filter(subscriber -> subscriber.supports().contains(event.getClass()))
                .forEach(subscriber -> subscriber.handle(event));
    }

    @Override
    public List<Subscribable> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
    }
}
