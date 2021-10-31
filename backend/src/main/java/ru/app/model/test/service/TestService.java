package ru.app.model.test.service;

import ru.app._infrastructure.Service;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.answer.entity.Answer;
import ru.app.model.question.entity.Question;
import ru.app.model.test.entity.Test;
import ru.app.model.test.entity.TestRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class TestService implements Service {
    @InjectByType
    private TestRepository testRepository;

    @PostConstruct
    private void init() {

    }

    public List<Test> getTestList() {
        return testRepository.findAll();
    }

    public int getTestScore(Test test) {
        int score = 0;
        for (var item : test.getQuestions()) {
            score += item.getPoints();
        }
        return score;
    }

    public int countScore(Test test, List<Answer> answers) {
        List<Question> questions = test.getQuestions();
        List<Answer> correctAnswers = questions.stream().map(Question::getCorrectAnswer).collect(Collectors.toList());

        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            var question = questions.get(i);
            var answer = answers.get(i);
            var correctAnswer = correctAnswers.get(i);

            if (Objects.equals(answer.getId(), correctAnswer.getId())) {
                score += question.getPoints();
            }
        }

        return score;
    }


}
