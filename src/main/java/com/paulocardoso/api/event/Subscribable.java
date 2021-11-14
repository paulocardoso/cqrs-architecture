package com.paulocardoso.api.event;

import java.util.Set;

public interface Subscribable<C> {

   void handle(Event<?> event);

    Set<Class<?>> supports();
}
