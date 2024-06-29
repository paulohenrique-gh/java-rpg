import models.base.Character;
import models.base.Enemy;

import java.util.List;

public class Game {
    private Character playerCharacter;
    private List<Enemy> enemies;
    private Character[] turnOrder;

    public Character getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Character playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
