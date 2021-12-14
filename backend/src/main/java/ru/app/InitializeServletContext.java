package ru.app;

import lombok.SneakyThrows;
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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;

public class InitializeServletContext implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Class.forName("com.mysql.jdbc.Driver");

        ApplicationContext context = Application.run("ru.app", new HashMap<>() {{
            put(UI.class, ConsoleUI.class);

            put(Module.class, MainModule.class);

            put(QuestionUI.class, ConsoleQuestionUI.class);
            put(TestUI.class, ConsoleTestUI.class);
            put(MainMenuUI.class, ConsoleMainMenu.class);
            put(ResultsUI.class, ConsoleResultUI.class);
        }});

        servletContextEvent.getServletContext().setAttribute("ApplicationContext", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

