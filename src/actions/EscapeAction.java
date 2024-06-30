package actions;

import actions.base.BattleAction;
import characters.base.Character;

public class EscapeAction extends BattleAction {
    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        this.log(activeCharacter.getName());
    }

    private void log(String activeName) {
        System.out.println("================================================");
        System.out.println(activeName + " fugiu da batalha");
        System.out.println("================================================");
    }
}
