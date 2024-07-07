package game.application.initialization;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Test
    void initializationTest() {
        try {
            new Application();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
