package ru.app.model.question.entity;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Database;
import ru.app.database.Repository;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository implements Repository<Question> {
    @InjectByType
    Database database;

    @Override
    public Question findOne(int id) {
        return database.getQuestion(id);
    }

    @Override
    public List<Question> findAll() {
        return new ArrayList<>(database.getQuestions().values());
    }

    @Override
    public Question create(Question newEntity) {
        return database.setQuestion(newEntity);
    }
}
