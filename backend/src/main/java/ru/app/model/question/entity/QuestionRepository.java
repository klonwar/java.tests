package ru.app.model.question.entity;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Repository;
import ru.app.database.mysql.SQLExecutor;
import ru.app.model.answer.entity.AnswerRepository;
import ru.app.model.test.entity.Test;

import java.util.List;

public class QuestionRepository implements Repository<Question> {
    @InjectByType
    private AnswerRepository answerRepository;

    @InjectByType
    private QuestionExtractor questionExtractor;

    @InjectByType
    private SQLExecutor sqlExecutor;

    @Override
    public Question findOne(int id) {
        var items = this.executeQuery(String.format(
                "select * from question where id = %d", id
        ));
        return items.size() > 0 ? items.get(0) : null;
    }

    @Override
    public List<Question> findAll() {
        return this.executeQuery("select * from question");
    }

    public List<Question> findForTest(Test test) {
        return this.executeQuery(String.format("select * from question_to_test\n" +
                "inner join question\n" +
                "on question_id = question.id\n" +
                "where test_id = %d", test.getId()));
    }

    @Override
    public Question create(Question newEntity) {
        return null;
    }

    @SneakyThrows
    public List<Question> executeQuery(String query) {
        var questions = sqlExecutor.executeQuery(query, questionExtractor);

        for (var question : questions) {
            question.setAnswers(
                    answerRepository.findForQuestion(question)
            );
            question.setCorrectAnswer(
                    answerRepository.findCorrectForQuestion(question)
            );
        }

        return questions;
    }
}
