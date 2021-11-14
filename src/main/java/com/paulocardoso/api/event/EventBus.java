package com.paulocardoso.api.event;

import java.util.List;

public interface EventBus {

    void register(Subscribable subscribable);

    void dispatch(Event<?> event);

    List<Subscribable> getSubscribers();
}
