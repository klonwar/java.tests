package ru.app.model.answer.service;

import ru.app._infrastructure.Service;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app._infrastructure.annotations.Singleton;
import ru.app.model.answer.entity.AnswerRepository;

@Singleton
public class AnswerService implements Service {
    @InjectByType
    private AnswerRepository answerRepository;

    @PostConstruct
    private void init() {

    }
}
