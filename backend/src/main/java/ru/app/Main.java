package ru.app;

import ru.app._infrastructure.application.Application;
import ru.app._infrastructure.application.ApplicationContext;
import ru.app.database.Database;
import ru.app.database.hardcoded.HardcodedDatabase;
import ru.app.model.answer.entity.Answer;
import ru.app.model.answer.entity.AnswerBuilder;
import ru.app.model.answer.entity.AnswerRepository;
import ru.app.model.answer.service.AnswerService;
import ru.app.model.question.entity.Question;
import ru.app.model.question.entity.QuestionBuilder;
import ru.app.model.question.entity.QuestionRepository;
import ru.app.model.question.service.QuestionService;
import ru.app.model.result.entity.Result;
import ru.app.model.result.entity.ResultBuilder;
import ru.app.model.result.entity.ResultRepository;
import ru.app.model.result.service.ResultService;
import ru.app.model.test.entity.Test;
import ru.app.model.test.entity.TestBuilder;
import ru.app.model.test.entity.TestRepository;
import ru.app.model.test.service.TestService;
import ru.app.module.MainModule;
import ru.app.module.Module;
import ru.app.ui.*;
import ru.app.ui.console.ConsoleUI;
import ru.app.ui.console.main_menu.ConsoleMainMenu;
import ru.app.ui.console.question.ConsoleQuestionUI;
import ru.app.ui.console.result.ConsoleResultUI;
import ru.app.ui.console.test.ConsoleTestUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Настроим контекст
        ApplicationContext context = Application.run("ru.app", new HashMap<>() {{
            put(List.class, ArrayList.class);
            put(Map.class, HashMap.class);

            put(Module.class, MainModule.class);

            put(UI.class, ConsoleUI.class);
            put(QuestionUI.class, ConsoleQuestionUI.class);
            put(TestUI.class, ConsoleTestUI.class);
            put(MainMenuUI.class, ConsoleMainMenu.class);
            put(ResultsUI.class, ConsoleResultUI.class);

            put(Database.class, HardcodedDatabase.class);

            put(Question.class, Question.class);
            put(QuestionBuilder.class, QuestionBuilder.class);
            put(QuestionService.class, QuestionService.class);
            put(QuestionRepository.class, QuestionRepository.class);

            put(Answer.class, Answer.class);
            put(AnswerBuilder.class, AnswerBuilder.class);
            put(AnswerService.class, AnswerService.class);
            put(AnswerRepository.class, AnswerRepository.class);

            put(Test.class, Test.class);
            put(TestBuilder.class, TestBuilder.class);
            put(TestService.class, TestService.class);
            put(TestRepository.class, TestRepository.class);

            put(Result.class, Result.class);
            put(ResultBuilder.class, ResultBuilder.class);
            put(ResultService.class, ResultService.class);
            put(ResultRepository.class, ResultRepository.class);
        }});

        // Запустим наш главный модуль
        context.getObject(Module.class);
    }
}
