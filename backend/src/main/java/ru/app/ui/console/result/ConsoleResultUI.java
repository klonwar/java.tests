package ru.app.ui.console.result;

import ru.app._infrastructure.annotations.InjectByType;
import ru.app.model.result.service.ResultService;
import ru.app.model.test.entity.Test;
import ru.app.ui.ResultsUI;
import ru.app.ui.console.ConsoleSlice;

public class ConsoleResultUI extends ConsoleSlice implements ResultsUI {
    @InjectByType
    private ResultService resultService;

    @Override
    public void showResults(Test test) {
        var results = resultService.findForTest(test);
        System.out.println("-@ Результаты для теста \"" + test.getTitle() + "\":");

        for (var item : results) {
            System.out.println("   - " + item.getScore());
        }

        System.out.println("-@ Всего: " + results.size() + ", средний резульат: " + resultService.getAverageScoreForTest(test));
    }
}
