package ru.app.model.test.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Database;
import ru.app.database.Repository;

import java.util.ArrayList;
import java.util.List;

public class TestRepository implements Repository<Test> {
    @InjectByType
    Database database;

    @Override
    public Test findOne(int id) {
        return database.getTest(id);
    }

    @Override
    public List<Test> findAll() {
        return new ArrayList<>(database.getTests().values());
    }

    @Override
    public Test create(Test newEntity) {
        return database.setTest(newEntity);
    }
}
