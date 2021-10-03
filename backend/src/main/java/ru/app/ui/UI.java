package ru.app.ui;

import ru.app._infrastructure.annotations.Singleton;

@Singleton
public interface UI extends TestUI, QuestionUI, MainMenuUI, ResultsUI {
    boolean askForConfirmation(String text);
}
