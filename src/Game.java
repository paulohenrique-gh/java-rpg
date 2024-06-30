import characters.base.Character;
import characters.base.Enemy;
import characters.enemies.Goblin;
import characters.enemies.Skeleton;
import characters.enemies.Troll;
import characters.enemies.Dragon;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Character playerCharacter;
    private List<Enemy> enemies;
    private UserInterface ui;

    public Game() {
       this.ui = new UserInterface();
       this.setEnemies();
    }

    public Character getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Character playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public void setEnemies() {
        Enemy enemy1 = new Goblin();
        Enemy enemy2 = new Skeleton();
        Enemy enemy3 = new Troll();
        Enemy boss = new Dragon();

        this.enemies = new ArrayList<>(List.of(enemy1, enemy2, enemy3, boss));
    }

    public void start() {
        this.ui.mainMenu();
        this.setPlayerCharacter(this.ui.getSelectedCharacter());

        for (Enemy enemy : this.enemies) {
            Battle battle = new Battle(playerCharacter, enemy);

            System.out.println("Você se depara com um " + enemy.getName());
            battle.start(this.ui);
            Character winner = battle.getWinner();

            if (winner == enemy) {
                System.out.println("Você perdeu!");
                break;
            } else if (winner == this.getPlayerCharacter()) {
                System.out.println("Você venceu essa batalha!");
            }
        }

        System.out.println("Fim do jogo");
    }
}
