package ru.app.ui;

import ru.app.model.test.entity.Test;

public interface ResultsUI {
    /**
     * Показываем все результаты по указанному тесту
     * */
    void showResults(Test test);
}
