package ru.app.model.question.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.app.database.Entity;
import ru.app.model.answer.entity.Answer;

import java.util.List;

public class Question implements Entity {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private Integer points;
    @Getter
    @Setter
    private List<Answer> answers;
    @Getter
    @Setter
    private Answer correctAnswer;
}
