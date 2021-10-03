package ru.app._infrastructure.application;

import lombok.Getter;
import lombok.Setter;
import ru.app._infrastructure.annotations.Singleton;
import ru.app._infrastructure.factory.ObjectFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class ApplicationContext {
    @Setter
    private ObjectFactory factory;
    @Getter
    private final Config config;
    private final Map<Class, Object> cache = new ConcurrentHashMap<>();

    public ApplicationContext(Config config) {
        this.config = config;

        // Хочу получать контекст аннотацией
        cache.put(ApplicationContext.class, this);
    }

    public <T> T getObject(Class<T> type) {
        // Из кэша можно достать синглтон, если это он
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }

        T t = factory.createObject(implClass);

        // В кэш положим синглтоны
        if (type.isAnnotationPresent(Singleton.class) || implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
