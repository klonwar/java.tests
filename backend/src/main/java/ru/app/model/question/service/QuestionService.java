package ru.app.model.question.service;

import ru.app._infrastructure.Service;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.question.entity.QuestionRepository;

@Singleton
public class QuestionService implements Service {
    @InjectByType
    private QuestionRepository questionRepository;

    @PostConstruct
    private void init() {

    }
}
