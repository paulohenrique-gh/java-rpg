package statusEffects;

import characters.base.Character;
import statusEffects.base.StatusEffect;

public class Burning extends StatusEffect {
    private int remainingActiveTurns;

    public Burning() {
        super("Queimadura", 1);
        this.remainingActiveTurns = 3;
    }

    public int getRemainingActiveTurns() {
        return remainingActiveTurns;
    }

    public void setRemainingActiveTurns(int remainingActiveTurns) {
        this.remainingActiveTurns = remainingActiveTurns;
    }

    public int applyDamage(Character targetCharacter) {
        int prevHp = targetCharacter.getCurHitPoints();
        int damageApplied = this.getTickDamage() + targetCharacter.getResFire();
        targetCharacter.setCurHitPoints(prevHp - damageApplied);

        return damageApplied;
    }

    @Override
    public void tick(Character targetCharacter) {
        if (this.getRemainingActiveTurns() <= 0) return;

        int damageTaken = applyDamage(targetCharacter);
        this.setRemainingActiveTurns(this.getRemainingActiveTurns() - 1);
        if (this.getRemainingActiveTurns() == 0) this.cleanEffect(targetCharacter);
        this.logTickDamage(targetCharacter, damageTaken);
    }

    private void logTickDamage(Character targetCharacter, int damageTaken) {
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(targetName + " está em chamas e sofreu " + damageTaken + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
        System.out.println("================================================");
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setCurrentStatus(null);
    }
}
