package ru.app.ui.console;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.answer.entity.Answer;
import ru.app.model.question.entity.Question;
import ru.app.model.test.entity.Test;
import ru.app.ui.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI {
    @InjectByType
    private QuestionUI questionUI;

    @InjectByType
    private TestUI testUI;

    @InjectByType
    private MainMenuUI mainMenu;

    @InjectByType
    private ResultsUI resultsUI;

    @Override
    public boolean askForConfirmation(String text) {
        System.out.println("-? " + text + " (y/n)");
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();

        return i.charAt(0) == 'y' || i.charAt(0) == 'Y';
    }

    @Override
    public Test askForTest() {
        return testUI.askForTest();
    }

    @Override
    public List<Answer> startTest(Test test) {
        return testUI.startTest(test);
    }

    @Override
    public Answer askQuestion(Question question) {
        return questionUI.askQuestion(question);
    }

    @Override
    public MainMenuAction askMainMenuAction() {
        return mainMenu.askMainMenuAction();
    }

    @Override
    public void showResults(Test test) {
        resultsUI.showResults(test);
    }
}
