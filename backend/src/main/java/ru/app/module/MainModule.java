package ru.app.module;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app.model.answer.entity.Answer;
import ru.app.model.result.service.ResultService;
import ru.app.model.test.entity.Test;
import ru.app.model.test.service.TestService;
import ru.app.ui.MainMenuAction;
import ru.app.ui.UI;

import java.util.List;

public class MainModule implements Module {
    @InjectByType
    private UI ui;

    @InjectByType
    private TestService testService;

    @InjectByType
    private ResultService resultService;

    @PostConstruct
    private void init() {
        for (; ; ) {
            this.handleMainMenuAction();
        }
    }

    private void testProcess() {
        Test chosenTest = ui.askForTest();
        List<Answer> answers = ui.startTest(chosenTest);

        int score = testService.countScore(chosenTest, answers);
        System.out.println("-@ Ваш результат (в баллах): " + score + " / " + testService.getTestScore(chosenTest));

        // Сохраним
        resultService.saveResult(chosenTest, score);
    }

    private void showResults() {
        Test chosenTest = ui.askForTest();
        ui.showResults(chosenTest);
    }

    private void handleMainMenuAction() {
        MainMenuAction mma = ui.askMainMenuAction();
        switch (mma) {
            case CHOOSE_TEST:
                this.testProcess();
                break;
            case SEE_RESULTS:
                this.showResults();
                break;
        }
    }
}
