package ru.app.model.answer.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Database;
import ru.app.database.Repository;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository implements Repository<Answer> {
    @InjectByType
    Database database;

    @Override
    public Answer findOne(int id) {
        return database.getAnswer(id);
    }

    @Override
    public List<Answer> findAll() {
        return new ArrayList<>(database.getAnswers().values());
    }

    @Override
    public Answer create(Answer newEntity) {
        return database.setAnswer(newEntity);
    }
}
