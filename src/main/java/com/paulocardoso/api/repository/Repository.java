package com.paulocardoso.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository<T> {

    private List<T> entities;

    public Repository() {
        entities = new ArrayList<T>();
    }

    public void save(T t){
        entities.add(t);
    }

    public List<T> getEntities(){
        return Collections.unmodifiableList(entities);
    }


}
