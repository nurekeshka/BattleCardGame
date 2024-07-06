package game.application.initialization;

import game.application.controls.Guice;
import game.application.controls.Injector;
import game.infrastructure.logic.GameLogic;
import game.presentation.frames.GameFrame;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        GameFrame frame = injector.getInstance(GameFrame.class);
        frame.init();
        GameLogic glogic = injector.getInstance(GameLogic.class);
        glogic.start();
    }
}
