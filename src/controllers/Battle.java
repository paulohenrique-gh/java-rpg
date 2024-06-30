package controllers;

import actions.EscapeAction;
import actions.base.BattleAction;
import characters.base.Character;
import characters.base.Enemy;

import java.util.*;

public class Battle {
    private Character playerCharacter;
    private Enemy enemy;
    private List<Character> turnOrder;
    private Character winner;
    private static int currentTurn;
    private static int currentRound;

    public Battle(Character playerCharacter, Enemy enemy) {
        this.playerCharacter = playerCharacter;
        this.enemy = enemy;
        this.turnOrder = new ArrayList<>(Arrays.asList(playerCharacter, enemy));
        currentTurn = 0;
        currentRound = 0;
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

    public static int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int turnNumber) {
        currentTurn = turnNumber;
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int roundNumber) {
        currentRound = roundNumber;
    }

    public void start(UserInterface ui) {
        generateTurnOrder();

        Character winner = null;

        while (winner == null) {
            this.setCurrentRound(getCurrentRound() + 1);
            BattleAction action = ui.chooseAction();

            Character character1 = this.turnOrder.get(0);
            Character character2 = this.turnOrder.get(1);
            character1.setCurrentAction(action);
            character2.setCurrentAction(action);

            this.setCurrentTurn(getCurrentTurn() + 1);
            startTurn(character1, character2);

            winner = this.validateWinner(character1, character2);
            if (winner != null) break;

            this.setCurrentTurn(getCurrentTurn() + 1);
            startTurn(character2, character1);

            winner = this.validateWinner(character2, character1);

            if (action instanceof EscapeAction) break;

            notifyFinishedRound();
        }

        this.setWinner(winner);
        this.setCurrentRound(0);
        this.setCurrentTurn(0);
    }

    private void startTurn(Character activeCharacter, Character targetCharacter) {
        activeCharacter.performAction(targetCharacter);
    }

    private void notifyFinishedRound() {
        this.playerCharacter.statusRoundTickDamage();
        this.enemy.statusRoundTickDamage();
    }

    private Character validateWinner(Character activeCharacter, Character targetCharacter) {
        if (activeCharacter.getCurHitPoints() <= 0) {
            return targetCharacter;
        }
        if (targetCharacter.getCurHitPoints() <= 0) {
            return activeCharacter;
        }

        return null;
    }
}