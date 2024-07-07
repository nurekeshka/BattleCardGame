package game.application.initialization;

import game.application.controls.AbstractModule;
import game.domain.repositories.CardsRepository;
import game.domain.repositories.impl.CardsRepositoryImpl;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.logic.impl.GameLogicImpl;
import game.infrastructure.progress.GameSaver;
import game.infrastructure.progress.impl.GameSaverImpl;
import game.presentation.components.panels.FinalPanel;
import game.presentation.components.panels.GamePanel;
import game.presentation.components.panels.MenuPanel;
import game.presentation.frames.MainFrame;

public class BasicModule extends AbstractModule {
    @Override
    public void configure() {
        bind(CardsRepository.class, CardsRepositoryImpl.class);
        bind(GameLogic.class, GameLogicImpl.class);
        bind(GameSaver.class, GameSaverImpl.class);
        bind(MainFrame.class, MainFrame.class);
        bind(GamePanel.class, GamePanel.class);
        bind(MenuPanel.class, MenuPanel.class);
        bind(FinalPanel.class, FinalPanel.class);
    }
}
