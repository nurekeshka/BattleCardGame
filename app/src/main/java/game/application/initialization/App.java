package game.application.initialization;

import game.application.controls.Guice;
import game.application.controls.Injector;
import game.presentation.frames.MainFrame;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        MainFrame main = injector.getInstance(MainFrame.class);
        main.init();
    }
}
