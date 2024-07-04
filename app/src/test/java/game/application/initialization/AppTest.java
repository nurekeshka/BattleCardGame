package game.application.initialization;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void initializationTest() {
        try {
            new App();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
