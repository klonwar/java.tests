package ru.app.database;

import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.answer.entity.Answer;
import ru.app.model.question.entity.Question;
import ru.app.model.result.entity.Result;
import ru.app.model.test.entity.Test;

import java.util.Map;

@Singleton
public interface Database {
    Map<Integer, Question> getQuestions();

    Map<Integer, Answer> getAnswers();

    Map<Integer, Test> getTests();

    Map<Integer, Result> getResults();

    Question getQuestion(int id);

    Question setQuestion(Question question);

    Answer getAnswer(int id);

    Answer setAnswer(Answer answer);

    Test getTest(int id);

    Test setTest(Test test);

    Result getResult(int id);

    Result setResult(Result result);
}
