package actions;

import actions.base.BattleAction;
import characters.base.Character;

public class EscapeAction extends BattleAction {
    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        this.logSuccess(activeCharacter.getName());
    }

    private void logSuccess(String activeName) {
        System.out.println("================================================");
        System.out.println(activeName + " fugiu da batalha");
        System.out.println("================================================");
    }
}
