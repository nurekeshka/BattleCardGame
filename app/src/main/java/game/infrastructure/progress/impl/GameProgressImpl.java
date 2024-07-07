package game.infrastructure.progress.impl;

import game.infrastructure.progress.GameProgress;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameProgressImpl implements GameProgress {
    private static Path gameSavePath = Paths.get("src", "main", "resources", "saves", "progress.json");

    public boolean exists() {
        return GameProgressImpl.gameSavePath.toFile().exists();
    }
}
