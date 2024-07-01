package controllers;

import characters.base.Character;
import characters.base.Enemy;
import characters.base.PlayerCharacter;
import characters.enemies.Goblin;
import characters.enemies.Skeleton;
import characters.enemies.Troll;
import characters.enemies.Dragon;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private PlayerCharacter playerCharacter;
    private List<Enemy> enemies;
    private UserInterface ui;

    public Game() {
       this.ui = new UserInterface();
       this.setEnemies();
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
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

        Battle battle = null;

        for (Enemy enemy : this.enemies) {
            battle = new Battle(this.playerCharacter, enemy);
            this.ui.printBattleHeader();

            System.out.println(this.playerCharacter.getName() + " se depara com um " + enemy.getName());
            battle.start(this.ui);
            Character winner = battle.getWinner();

            if (winner == enemy) {
                this.ui.printGameOver();
                break;
            } else if (winner == this.getPlayerCharacter()) {
                System.out.println("Você venceu essa batalha!");
            }
        }

        if (battle != null && battle.getWinner().equals(this.playerCharacter)) {
            this.ui.printGameFinished();
        }
    }
}
