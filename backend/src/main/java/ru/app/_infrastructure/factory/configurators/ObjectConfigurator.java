package ru.app._infrastructure.factory.configurators;

import ru.app._infrastructure.application.ApplicationContext;


public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
