import models.base.BattleAction;
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

    public void start(UserInterface ui) {
        generateTurnOrder();

        Character winner = null;

        BattleAction action = ui.chooseAction();

        while (winner == null) {
            Character character1 = this.turnOrder.get(0);
            Character character2 = this.turnOrder.get(1);

            startTurn(character1, character2);

            winner = this.validateWinner(character1, character2);
            if (winner != null) break;

            startTurn(character2, character1);

            winner = this.validateWinner(character2, character1);
        }

        this.setWinner(winner);
    }

    private void startTurn(Character activeCharacter, Character targetCharacter, String action) {
        activeCharacter.attack(targetCharacter);
    }


    private Character validateWinner(Character activeCharacter, Character targetCharacter) {
        if (activeCharacter.getHitPoints() <= 0) {
            return targetCharacter;
        }
        if (targetCharacter.getHitPoints() <= 0) {
            return activeCharacter;
        }

        return null;
    }
}
