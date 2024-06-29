package models.actions;

import models.base.BattleAction;
import models.base.Character;

public class EscapeAction extends BattleAction {
    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        this.log(activeCharacter.getName());
    }

    private void log(String activeName) {
        System.out.println(activeName + " fugiu da batalha");
    }
}
