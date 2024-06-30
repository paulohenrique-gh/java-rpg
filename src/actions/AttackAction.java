package actions;

import actions.base.BattleAction;
import characters.base.Character;

public class AttackAction extends BattleAction {
    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        int prevHp = targetCharacter.getCurHitPoints();
        targetCharacter.setCurHitPoints(prevHp + targetCharacter.getDefense() - activeCharacter.getAttack());
        this.logAction(activeCharacter, targetCharacter, prevHp);
    }

    private void logAction(Character activeCharacter, Character targetCharacter, int prevHp) {
        String activeName = activeCharacter.getName();
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(activeName + " atacou " + targetName);
        System.out.println(activeName + " causou " + (prevHp - curHp) + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
        System.out.println("================================================");
    }
}
