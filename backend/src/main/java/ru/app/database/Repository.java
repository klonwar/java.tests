package ru.app.database;

import java.util.List;

public interface Repository<T extends Entity> {
    T findOne(int id);
    List<T> findAll();
    T create(T newEntity);
}
