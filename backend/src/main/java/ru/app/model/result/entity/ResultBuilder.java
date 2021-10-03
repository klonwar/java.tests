package ru.app.model.result.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.test.entity.Test;

public class ResultBuilder {
    @InjectByType
    private Result result;

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

    public ResultBuilder test(Test val) {
        result.setTest(val);
        return this;
    }

    public Result build() {
        return result;
    }
}
