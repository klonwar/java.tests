package ru.app.model.test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.app.database.Entity;
import ru.app.model.question.entity.Question;

import java.util.List;

@ToString
public class Test implements Entity {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private List<Question> questions;
}
