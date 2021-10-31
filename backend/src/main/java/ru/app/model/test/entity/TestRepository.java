package ru.app.model.test.entity;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Repository;
import ru.app.database.mysql.SQLExecutor;
import ru.app.model.question.entity.QuestionRepository;

import java.util.List;

public class TestRepository implements Repository<Test> {
    @InjectByType
    private QuestionRepository questionRepository;

    @InjectByType
    private TestExtractor testExtractor;

    @InjectByType
    private SQLExecutor sqlExecutor;

    @Override
    public Test findOne(int id) {
        var items = this.executeQuery(String.format(
                "select * from test where id = %d", id
        ));

        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    @SneakyThrows
    public List<Test> findAll() {
        return this.executeQuery("select * from test");
    }

    @Override
    public Test create(Test newEntity) {
        return null;
    }

    @SneakyThrows
    public List<Test> executeQuery(String query) {
        var tests = sqlExecutor.executeQuery(query, testExtractor);

        for (var test : tests) {
            test.setQuestions(
                    questionRepository.findForTest(test)
            );
        }

        return tests;
    }
}
