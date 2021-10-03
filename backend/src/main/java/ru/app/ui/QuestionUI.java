package ru.app.ui;

import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.answer.entity.Answer;
import ru.app.model.question.entity.Question;

@Singleton
public interface QuestionUI {
    /**
     * Задаем вопрос, получаем ответ
     * */
    Answer askQuestion(Question question);
}
