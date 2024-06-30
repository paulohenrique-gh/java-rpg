package actions;

import actions.base.BattleAction;
import characters.base.Character;
import characters.enemies.base.Boss;

public class EscapeAction extends BattleAction {
    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        if (targetCharacter instanceof Boss) {
            this.logFailure(activeCharacter.getName());
            return;
        }

        this.logSuccess(activeCharacter.getName());
    }

    private void logFailure(String name) {
        System.out.println("================================================");
        System.out.println(name + " tentou fugir da batalha mas não conseguiu");
        System.out.println("================================================");
    }

    private void logSuccess(String activeName) {
        System.out.println("================================================");
        System.out.println(activeName + " fugiu da batalha");
        System.out.println("================================================");
    }
}
