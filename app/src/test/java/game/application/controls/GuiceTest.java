package game.application.controls;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import game.application.initialization.BasicModule;

class GuiceTest {

    @Test
    void injectorCreation() {
        try {
            Guice.createInjector(new BasicModule());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}