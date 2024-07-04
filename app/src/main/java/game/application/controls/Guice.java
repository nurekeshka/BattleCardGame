package game.application.controls;

public class Guice {
    public static Injector createInjector(AbstractModule module) {
        return new Injector(module.map);
    }
}