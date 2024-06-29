package models.actions;

import models.base.BattleAction;
import models.base.Character;

public class AttackAction extends BattleAction {

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        int prevHp = targetCharacter.getHitPoints();
        targetCharacter.setHitPoints(prevHp + targetCharacter.getDefense() - activeCharacter.getAttack());
        this.resetNegativeHp(targetCharacter);
        this.logAction(activeCharacter.getName(), targetCharacter.getName(), prevHp, targetCharacter.getHitPoints());
    }

    private void logAction(String activeName, String targetName, int prevHp, int curHp) {
        System.out.println("================================================");
        System.out.println(activeName + " atacou " + targetName);
        System.out.println(activeName + " causou " + (prevHp - curHp) + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
        System.out.println("================================================");
    }
}
