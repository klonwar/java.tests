package ru.app.database.hardcoded;

import lombok.Getter;
import lombok.ToString;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app._infrastructure.annotations.Singleton;
import ru.app._infrastructure.application.ApplicationContext;
import ru.app.database.Database;
import ru.app.model.answer.entity.Answer;
import ru.app.model.answer.entity.AnswerBuilder;
import ru.app.model.question.entity.Question;
import ru.app.model.question.entity.QuestionBuilder;
import ru.app.model.result.entity.Result;
import ru.app.model.test.entity.Test;
import ru.app.model.test.entity.TestBuilder;

import java.util.ArrayList;
import java.util.Map;

@Singleton
@ToString
public class HardcodedDatabase implements Database {
    @InjectByType
    private ApplicationContext context;

    @InjectByType
    @Getter
    private Map<Integer, Question> questions;
    @InjectByType
    @Getter
    private Map<Integer, Answer> answers;
    @InjectByType
    @Getter
    private Map<Integer, Test> tests;
    @InjectByType
    @Getter
    private Map<Integer, Result> results;

    private void initAnswers() {
        answers.put(
                1,
                context.getObject(AnswerBuilder.class)
                        .id(1)
                        .content("Да")
                        .build()
        );

        answers.put(
                2,
                context.getObject(AnswerBuilder.class)
                        .id(2)
                        .content("Нет")
                        .build()
        );

        answers.put(
                3,
                context.getObject(AnswerBuilder.class)
                        .id(3)
                        .content("Не знаю")
                        .build()
        );
        answers.put(
                4,
                context.getObject(AnswerBuilder.class)
                        .id(4)
                        .content("Дима")
                        .build()
        );
        answers.put(
                5,
                context.getObject(AnswerBuilder.class)
                        .id(5)
                        .content("Вася")
                        .build()
        );
    }

    private void initQuestions() {
        questions.put(
                1,
                context.getObject(QuestionBuilder.class)
                        .id(1)
                        .content("2 + 2 = 5 ?")
                        .points(10)
                        .answers(new ArrayList<>() {{
                            add(answers.get(1));
                            add(answers.get(2));
                            add(answers.get(3));
                        }})
                        .correctAnswer(answers.get(2))
                        .build()
        );
        questions.put(
                2,
                context.getObject(QuestionBuilder.class)
                        .id(2)
                        .content("5 + 4 = 9 ?")
                        .points(10)
                        .answers(new ArrayList<>() {{
                            add(answers.get(1));
                            add(answers.get(2));
                            add(answers.get(3));
                        }})
                        .correctAnswer(answers.get(1))
                        .build()
        );
        questions.put(
                3,
                context.getObject(QuestionBuilder.class)
                        .id(3)
                        .content("Это предложение ложно")
                        .points(10)
                        .answers(new ArrayList<>() {{
                            add(answers.get(1));
                            add(answers.get(2));
                            add(answers.get(3));
                        }})
                        .correctAnswer(answers.get(3))
                        .build()
        );
        questions.put(
                4,
                context.getObject(QuestionBuilder.class)
                        .id(4)
                        .content("Как зовут автора этой программы?")
                        .points(10)
                        .answers(new ArrayList<>() {{
                            add(answers.get(4));
                            add(answers.get(5));
                            add(answers.get(3));
                        }})
                        .correctAnswer(answers.get(4))
                        .build()
        );
    }

    private void initTests() {
        tests.put(
                1,
                context.getObject(TestBuilder.class)
                        .id(1)
                        .title("Математика")
                        .questions(new ArrayList<>() {{
                            add(questions.get(1));
                            add(questions.get(2));
                        }})
                        .build()
        );
        tests.put(
                2,
                context.getObject(TestBuilder.class)
                        .id(2)
                        .title("Разные вопросы")
                        .questions(new ArrayList<>() {{
                            add(questions.get(3));
                            add(questions.get(4));
                        }})
                        .build()
        );
        tests.put(
                3,
                context.getObject(TestBuilder.class)
                        .id(3)
                        .title("Все вопросы")
                        .questions(new ArrayList<>() {{
                            add(questions.get(1));
                            add(questions.get(2));
                            add(questions.get(3));
                            add(questions.get(4));
                        }})
                        .build()
        );
    }

    @PostConstruct
    private void init() {
        // На 1 атту хардкод

        this.initAnswers();
        this.initQuestions();
        this.initTests();
    }

    @Override
    public Question getQuestion(int id) {
        return questions.get(id);
    }

    @Override
    public Answer getAnswer(int id) {
        return answers.get(id);
    }

    @Override
    public Test getTest(int id) {
        return tests.get(id);
    }

    @Override
    public Question setQuestion(Question question) {
        return questions.put(question.getId(), question);
    }

    @Override
    public Answer setAnswer(Answer answer) {
        return answers.put(answer.getId(), answer);
    }

    @Override
    public Test setTest(Test test) {
        return tests.put(test.getId(), test);
    }

    @Override
    public Result getResult(int id) {
        return results.get(id);
    }

    @Override
    public Result setResult(Result result) {
        return results.put(result.getId(), result);
    }
}
