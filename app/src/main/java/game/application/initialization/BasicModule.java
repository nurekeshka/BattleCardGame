package game.application.initialization;

import game.application.controls.AbstractModule;
import game.domain.repositories.CardsRepository;
import game.domain.repositories.impl.CardsRepositoryImpl;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.logic.impl.GameLogicImpl;
import game.infrastructure.progress.GameSaver;

public class BasicModule extends AbstractModule {
    @Override
    public void configure() {
        bind(CardsRepository.class, CardsRepositoryImpl.class);
        bind(GameLogic.class, GameLogicImpl.class);
        bind(GameSaver.class, GameLogicImpl.class);
    }
}
