package ru.app.model.result.entity;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Repository;
import ru.app.database.mysql.SQLExecutor;
import ru.app.model.test.entity.Test;
import ru.app.model.test.entity.TestRepository;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository implements Repository<Result> {
    @InjectByType
    private TestRepository testRepository;

    @InjectByType
    private ResultExtractor resultExtractor;

    @InjectByType
    private SQLExecutor sqlExecutor;

    @Override
    public Result findOne(int id) {
        return null;
    }

    @Override
    public List<Result> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Result create(Result newEntity) {
        var newEntityId = sqlExecutor.executeUpdate(String.format(
                "insert into result (score, test_id)\n" +
                        "values (%d, %d)",
                newEntity.getScore(), newEntity.getTestId()
        ));
        newEntity.setId(newEntityId);
        return newEntity;
    }

    public List<Result> findForTest(Test test) {
        return this.executeQuery(String.format("select * from result\n" +
                "where test_id = %d", test.getId()));
    }

    @SneakyThrows
    public List<Result> executeQuery(String query) {
        var results = sqlExecutor.executeQuery(query, resultExtractor);

        for (var result : results) {
            result.setTest(
                    testRepository.findOne(result.getTestId())
            );
        }

        return results;
    }
}
