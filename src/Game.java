import models.base.Character;
import models.base.Enemy;

import java.util.List;

public class Game {
    private Character playerCharacter;
    private List<Enemy> enemies;

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

    public void start() {
        for (Enemy enemy : this.enemies) {
            Battle battle = new Battle(playerCharacter, enemy);

            battle.start();
            Character winner = battle.getWinner();

            if (winner != this.getPlayerCharacter()) {
                System.out.println("Você perdeu!");
                break;
            }

            System.out.println("Você venceu essa batalha");
        }

        System.out.println("fim do jogo");
    }
}
