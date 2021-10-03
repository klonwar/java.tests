package ru.app._infrastructure.factory;

import lombok.SneakyThrows;
import ru.app._infrastructure.factory.configurators.ObjectConfigurator;
import ru.app._infrastructure.annotations.PostConstruct;
import ru.app._infrastructure.application.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class ObjectFactory {
    private final ApplicationContext context;
    private final List<ObjectConfigurator> configurators = new ArrayList<>();


    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        // Найдем все конфигураторы и добавим
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }


    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {

        T t = create(implClass);

        configure(t);

        invokeInit(implClass, t);

        return t;

    }

    private <T> void invokeInit(Class<T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        // Вызовем методы, которые нужно вызвать после создания и конфигурации объекта
        // .getDeclaredMethods() или .getMethods() ...?
        for (Method method : implClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.setAccessible(true);
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        // Конфигурация с помощью наших конфигураторов
        configurators.forEach(objectConfigurator -> objectConfigurator.configure(t, context));
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // Создание инстанса класса
        return implClass.getDeclaredConstructor().newInstance();
    }
}




