package ru.app.model.result.entity;

import ru.app.model.test.entity.Test;

public class ResultBuilder {
    private final Result result = new Result();

    public ResultBuilder() {
    }

    public ResultBuilder id(Integer val) {
        result.setId(val);
        return this;
    }

    public ResultBuilder score(Integer val) {
        result.setScore(val);
        return this;
    }

    public ResultBuilder testId(Integer val) {
        result.setTestId(val);
        return this;
    }

    public ResultBuilder test(Test val) {
        result.setTest(val);
        if (val != null && val.getId() != null)
            result.setTestId(val.getId());
        return this;
    }

    public Result build() {
        return result;
    }
}
