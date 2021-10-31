package ru.app.model.answer.entity;

import ru.app._infrastructure.annotations.InjectByType;

public class AnswerBuilder {
    private final Answer answer = new Answer();

    public AnswerBuilder() {
    }

    public AnswerBuilder id(Integer val) {
        answer.setId(val);
        return this;
    }

    public AnswerBuilder content(String val) {
        answer.setContent(val);
        return this;
    }

    public Answer build() {
        return answer;
    }
}
