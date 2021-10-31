package ru.app.model.answer.entity;

import lombok.Getter;
import lombok.Setter;
import ru.app.database.Entity;

public class Answer implements Entity {
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String content;
}
