package ru.app.model.result.service;

import ru.app._infrastructure.Service;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.result.entity.Result;
import ru.app.model.result.entity.ResultBuilder;
import ru.app.model.result.entity.ResultRepository;
import ru.app.model.test.entity.Test;

import java.util.List;

public class ResultService implements Service {
    @InjectByType
    private ResultRepository resultRepository;

    public Result saveResult(Test test, int score) {
        return resultRepository.create((new ResultBuilder()).test(test).score(score).build());
    }

    public List<Result> findForTest(Test test) {
        return resultRepository.findForTest(test);
    }

    public int getAverageScoreForTest(Test test) {
        var results = this.findForTest(test);
        int sum = 0;
        for (var item : results) {
            var score = item.getScore();
            sum += score;
        }
        return (results.size() != 0) ? sum / results.size() : 0;
    }

    public Result getById(Integer id) {
        return resultRepository.findOne(id);
    }
}
