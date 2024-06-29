package models.base;

public abstract class BattleAction {
    public abstract void perform(Character activeCharacter, Character targetCharacter);

    protected void resetNegativeHp(Character targetCharacter) {
        if (targetCharacter.getHitPoints() < 0) {
            targetCharacter.setHitPoints(0);
        }
    }
}
