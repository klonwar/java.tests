package ru.app.model.result.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.app.database.Entity;
import ru.app.model.test.entity.Test;

@ToString
public class Result implements Entity {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer score;
    @Getter
    @Setter
    private Test test;
}
