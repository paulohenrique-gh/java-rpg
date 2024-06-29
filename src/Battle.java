import models.base.Character;
import models.base.Enemy;

import java.util.*;

public class Battle {
    private Character playerCharacter;
    private Enemy enemy;
    private List<Character> turnOrder;
    private Character winner;

    public Battle(Character playerCharacter, Enemy enemy) {
        this.playerCharacter = playerCharacter;
        this.enemy = enemy;
        this.turnOrder = new ArrayList<>(Arrays.asList(playerCharacter, enemy));
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Character getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Character playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public void setWinner(Character winner) {
        this.winner = winner;
    }

    public Character getWinner() {
        return this.winner;
    }

    private void generateTurnOrder() {
        Collections.shuffle(this.turnOrder);
    }

    public void start() {
        generateTurnOrder();

        Character winner = null;

        while (winner == null) {
            for (int i = 0; i < this.turnOrder.size(); i++) {
                Character activeCharacter = this.turnOrder.get(i);
                Character targetCharacter = this.turnOrder.get(i + 1);

                activeCharacter.attack(targetCharacter);

                if (this.getPlayerCharacter().getHitPoints() <= 0) {
                    System.out.println("game over");
                    winner = this.getEnemy();
                }
                if (this.getEnemy().getHitPoints() <= 0) {
                    System.out.println("fim da batalha");
                    winner = this.getPlayerCharacter();
                }
            }
        }

        this.setWinner(winner);
    }
}
