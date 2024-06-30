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
    private static int currentRound;
    private static Character ativeCharacter;

    public Battle(Character playerCharacter, Enemy enemy) {
        this.playerCharacter = playerCharacter;
        this.enemy = enemy;
        this.turnOrder = new ArrayList<>(Arrays.asList(playerCharacter, enemy));
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

    public static int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int roundNumber) {
        currentRound = roundNumber;
    }

    public static Character getAtiveCharacter() {
        return ativeCharacter;
    }

    public void setAtiveCharacter(Character character) {
        ativeCharacter = character;
    }

    public void start(UserInterface ui) {
        generateTurnOrder();

        Character winner = null;

        while (winner == null) {
            BattleAction action = ui.chooseAction();

            Character character1 = this.turnOrder.get(0);
            Character character2 = this.turnOrder.get(1);
            character1.setCurrentAction(action);
            character2.setCurrentAction(action);

            startTurn(character1, character2);
            this.notifyTurnEnd();

            winner = this.validateWinner(character1, character2);
            if (winner != null) break;

            startTurn(character2, character1);
            this.setCurrentRound(getCurrentRound() + 1);
            this.notifyTurnEnd();

            winner = this.validateWinner(character2, character1);

            if (action instanceof EscapeAction) break;
        }

        this.setWinner(winner);
        this.setCurrentRound(0);
    }

    private void startTurn(Character activeCharacter, Character targetCharacter) {
        this.setAtiveCharacter(activeCharacter);
        activeCharacter.performAction(targetCharacter);
    }

    private void notifyTurnEnd() {
        for (Character character : this.turnOrder) {
            character.onTurnEnd();
        }
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
