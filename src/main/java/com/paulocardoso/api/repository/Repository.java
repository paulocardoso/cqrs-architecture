package com.paulocardoso.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repository<T> {

    private List<T> repository;

    public Repository() {
        repository = new ArrayList<T>();
    }

    public void save(T t){
        repository.add(t);
    }

    public List<T> getEntities(){
        return Collections.unmodifiableList(repository);
    }


}
