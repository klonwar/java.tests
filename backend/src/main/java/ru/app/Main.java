package ru.app;

import ru.app._infrastructure.application.Application;
import ru.app._infrastructure.application.ApplicationContext;
import ru.app.module.MainModule;
import ru.app.module.Module;
import ru.app.ui.*;
import ru.app.ui.console.ConsoleUI;
import ru.app.ui.console.main_menu.ConsoleMainMenu;
import ru.app.ui.console.question.ConsoleQuestionUI;
import ru.app.ui.console.result.ConsoleResultUI;
import ru.app.ui.console.test.ConsoleTestUI;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.app", new HashMap<>() {{
            put(UI.class, ConsoleUI.class);

            put(Module.class, MainModule.class);

            put(QuestionUI.class, ConsoleQuestionUI.class);
            put(TestUI.class, ConsoleTestUI.class);
            put(MainMenuUI.class, ConsoleMainMenu.class);
            put(ResultsUI.class, ConsoleResultUI.class);
        }});

        // Запустим наш главный модуль
        context.getObject(Module.class);
    }
}
