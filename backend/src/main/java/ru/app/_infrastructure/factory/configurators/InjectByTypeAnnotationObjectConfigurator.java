package ru.app._infrastructure.factory.configurators;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app._infrastructure.application.ApplicationContext;

import java.lang.reflect.Field;


public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        // Автоматически создадим объекты и запишем в поля, помеченные @InjectByType
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }
    }
}
