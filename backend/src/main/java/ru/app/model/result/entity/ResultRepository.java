package ru.app.model.result.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Database;
import ru.app.database.Repository;
import ru.app.model.test.entity.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultRepository implements Repository<Result> {
    @InjectByType
    Database database;

    @Override
    public Result findOne(int id) {
        return database.getResult(id);
    }

    @Override
    public List<Result> findAll() {
        return new ArrayList<>(database.getResults().values());
    }

    @Override
    public Result create(Result newEntity) {
        var maxIdOptional = database.getResults().keySet().stream().max(Integer::compare);
        int newId = 1;
        if (maxIdOptional.isPresent()) {
            newId = maxIdOptional.get() + 1;
        }
        newEntity.setId(newId);
        return database.setResult(newEntity);
    }

    public List<Result> findForTest(Test test) {
        List<Result> forTest = new ArrayList<>();
        for (var res : this.findAll()) {
            if (Objects.equals(res.getTest().getId(), test.getId()))
                forTest.add(res);
        }
        return forTest;
    }
}
