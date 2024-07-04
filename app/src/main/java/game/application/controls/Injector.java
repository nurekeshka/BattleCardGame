package game.application.controls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Injector {
    private final Map<Class<?>, Class<?>> map;

    public Injector(Map<Class<?>, Class<?>> map) {
        this.map = map;
    }

    public <T> T getInstance(Class<T> type) {
        Class<?> clazz = this.map.get(type);

        if (clazz == null) {
            throw new IllegalArgumentException("No implementation registered for: " + type.getName());
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        T instance = null;

        try {
            for (Constructor<?> constructor : constructors) {
                Class<?>[] paramTypes = constructor.getParameterTypes();

                Object[] params = new Object[paramTypes.length];

                for (int i = 0; i < paramTypes.length; i++) {
                    params[i] = this.getInstance(paramTypes[i]);
                }

                instance = type.cast(constructor.newInstance(params));
            }

            if (instance == null) {
                throw new InjectionException("None of the constructors match the Guice");
            }

            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectionException(e.toString() + " on the class : " + clazz.getName(), e);
        }
    }
}