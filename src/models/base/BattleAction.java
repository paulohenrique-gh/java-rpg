package models.base;

public abstract class BattleAction {
    public abstract void perform(Character activeCharacter, Character targetCharacter);
}
