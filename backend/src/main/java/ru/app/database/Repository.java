package ru.app.database;

import ru.app.database.mysql.SQLExecutor;

import java.util.List;

public interface Repository<T extends Entity>  {
    T findOne(int id);

    List<T> findAll();

    T create(T newEntity);

    List<T> executeQuery(String query);
}
