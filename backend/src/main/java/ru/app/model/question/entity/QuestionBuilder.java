package ru.app.model.question.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.answer.entity.Answer;

import java.util.List;

public class QuestionBuilder {
    @InjectByType
    private Question question;

    public QuestionBuilder() {
    }

    public QuestionBuilder id(Integer val) {
        question.setId(val);
        return this;
    }

    public QuestionBuilder content(String val) {
        question.setContent(val);
        return this;
    }

    public QuestionBuilder points(Integer val) {
        question.setPoints(val);
        return this;
    }

    public QuestionBuilder answers(List<Answer> val) {
        question.setAnswers(val);
        return this;
    }

    public QuestionBuilder correctAnswer(Answer val) {
        question.setCorrectAnswer(val);
        return this;
    }

    public Question build() {
        return question;
    }
}
