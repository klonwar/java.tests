package ru.app.model.test.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.question.entity.Question;

import java.util.List;

public class TestBuilder {
    @InjectByType
    private Test question;

    public TestBuilder() {
    }

    public TestBuilder id(Integer val) {
        question.setId(val);
        return this;
    }

    public TestBuilder title(String val) {
        question.setTitle(val);
        return this;
    }

    public TestBuilder questions(List<Question> val) {
        question.setQuestions(val);
        return this;
    }

    public Test build() {
        return question;
    }
}
