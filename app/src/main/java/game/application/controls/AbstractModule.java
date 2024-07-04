package game.application.controls;

import java.util.Map;
import java.util.HashMap;

public abstract class AbstractModule {
    public final Map<Class<?>, Class<?>> map = new HashMap<>();

    protected AbstractModule() {
        this.configure();
    }

    public abstract void configure();

    public void bind(Class<?> clazz, Class<?> to) {
        this.map.put(clazz, to);
    }
}