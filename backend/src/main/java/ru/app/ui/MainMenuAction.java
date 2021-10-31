package ru.app.ui;

import lombok.Getter;

public enum MainMenuAction {
    CHOOSE_TEST("Решить тест"),
    SEE_RESULTS("Посмотреть результаты");

    @Getter
    private final String label;

    MainMenuAction(String label) {
        this.label = label;
    }
}
