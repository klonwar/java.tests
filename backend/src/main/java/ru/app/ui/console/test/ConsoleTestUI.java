package ru.app.ui.console.test;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.answer.entity.Answer;
import ru.app.model.test.entity.Test;
import ru.app.model.test.service.TestService;
import ru.app.ui.QuestionUI;
import ru.app.ui.TestUI;
import ru.app.ui.console.ConsoleSlice;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTestUI extends ConsoleSlice implements TestUI {
    @InjectByType
    private TestService testService;

    @InjectByType
    private QuestionUI questionUI;

    @Override
    public Test askForTest() {
        System.out.println("-@ Выберите тест из списка (введите цифру):");
        var tests = testService.getTestList();

        return askElementInList(tests, Test::getTitle);
    }

    @Override
    public List<Answer> startTest(Test test) {
        var questions = test.getQuestions();
        List<Answer> userAnswers = new ArrayList<>();
        System.out.println("-@ Начинается тест \"" + test.getTitle() + "\"");
        int number = 0;
        int maxNumber = questions.size();
        for (var question : questions) {
            number++;
            System.out.println("-@ Вопрос " + number + " / " + maxNumber);
            userAnswers.add(questionUI.askQuestion(question));
        }
        return userAnswers;
    }

}
