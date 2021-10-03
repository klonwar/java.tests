package ru.app.ui;

import lombok.Getter;

public enum MainMenuAction {
    CHOOSE_TEST("Выбрать тест"),
    SEE_RESULTS("Посмотреть результаты");

    @Getter
    private final String label;
    private MainMenuAction(String label) {
        this.label = label;
    }
}
