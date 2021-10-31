package ru.app.model.test.entity;

import ru.app.model.question.entity.Question;

import java.util.List;

public class TestBuilder {
    private final Test test = new Test();

    public TestBuilder() {
    }

    public TestBuilder id(Integer val) {
        test.setId(val);
        return this;
    }

    public TestBuilder title(String val) {
        test.setTitle(val);
        return this;
    }

    public TestBuilder questions(List<Question> val) {
        test.setQuestions(val);
        return this;
    }

    public Test build() {
        return test;
    }
}
