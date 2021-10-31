package ru.app.model.answer.entity;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Repository;
import ru.app.database.mysql.SQLExecutor;
import ru.app.model.question.entity.Question;

import java.util.List;

public class AnswerRepository implements Repository<Answer> {
    @InjectByType
    private AnswerExtractor answerExtractor;

    @InjectByType
    private SQLExecutor sqlExecutor;

    @Override
    public Answer findOne(int id) {
        var items = this.executeQuery(String.format(
                "select * from answer where id = %d", id
        ));
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public List<Answer> findAll() {
        return this.executeQuery("select * from answer");
    }

    public List<Answer> findForQuestion(Question question) {
        return this.executeQuery(String.format("select * from answer_to_question\n" +
                "inner join answer\n" +
                "on answer_id = answer.id\n" +
                "where question_id = %d", question.getId()));
    }

    public Answer findCorrectForQuestion(Question question) {
        var items = this.executeQuery(String.format("select * from answer_to_question\n" +
                "inner join answer\n" +
                "on answer_id = answer.id\n" +
                "where question_id = %d and\n" +
                "is_correct = 1", question.getId()));

        return items.size() > 0 ? items.get(0) : null;
    }


    @Override
    public Answer create(Answer newEntity) {
        return null;
    }

    @SneakyThrows
    public List<Answer> executeQuery(String query) {
        return sqlExecutor.executeQuery(query, answerExtractor);
    }

}
