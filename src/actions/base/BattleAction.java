package actions.base;

import characters.base.Character;

public abstract class BattleAction {
    public abstract void perform(Character activeCharacter, Character targetCharacter);
}
