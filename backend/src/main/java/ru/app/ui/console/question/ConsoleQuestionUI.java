package ru.app.ui.console.question;

import ru.app.model.answer.entity.Answer;
import ru.app.model.question.entity.Question;
import ru.app.ui.QuestionUI;
import ru.app.ui.console.ConsoleSlice;

public class ConsoleQuestionUI extends ConsoleSlice implements QuestionUI {
    @Override
    public Answer askQuestion(Question question) {
        System.out.println("-@@ " + question.getContent());
        var answers = question.getAnswers();

        return askElementInList(answers, Answer::getContent);
    }
}
