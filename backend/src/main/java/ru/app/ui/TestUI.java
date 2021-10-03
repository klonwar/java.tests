package ru.app.ui;

import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.answer.entity.Answer;
import ru.app.model.test.entity.Test;

import java.util.List;

@Singleton
public interface TestUI {
    /**
     * Выбираем тест из списка всех
     * */
    Test askForTest();

    /**
     * Проведение теста. Задаем все вопросы из теста, получаем ответы на каждый из них.
     * Задавание вопроса нужно делегировать в QuestionUI
     * */
    List<Answer> startTest(Test test);
}
