package com.paulocardoso.api.event;

import java.util.Set;

public interface Subscribable<E extends Event> {

   void handle(E event);

    Set<Class<?>> supports();
}
