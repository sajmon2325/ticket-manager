package com.opensourcedev.ticketmanager.service;

import java.util.Set;

public interface CrudInterface<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void deleteById(ID id);

}
