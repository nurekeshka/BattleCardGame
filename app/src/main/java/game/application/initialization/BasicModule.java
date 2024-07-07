package game.application.initialization;

import game.application.controls.AbstractModule;
import game.domain.repositories.CardsRepository;
import game.domain.repositories.impl.CardsRepositoryImpl;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.logic.impl.GameLogicImpl;
import game.infrastructure.progress.GameSaver;
import game.infrastructure.progress.impl.GameSaverImpl;
import game.presentation.frames.GameFrame;
import game.presentation.frames.MainFrame;

public class BasicModule extends AbstractModule {
    @Override
    public void configure() {
        bind(CardsRepository.class, CardsRepositoryImpl.class);
        bind(GameLogic.class, GameLogicImpl.class);
        bind(GameSaver.class, GameSaverImpl.class);
        bind(GameFrame.class, GameFrame.class);
        bind(MainFrame.class, MainFrame.class);
    }
}
