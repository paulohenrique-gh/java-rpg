package statusEffects;

import characters.base.Character;
import statusEffects.base.StatusEffect;

public class Burning extends StatusEffect {
    private int remainingActiveTurns;

    public Burning() {
        super("Em Chamas", 1);
        this.remainingActiveTurns = 3;
    }

    public int getRemainingActiveTurns() {
        return remainingActiveTurns;
    }

    public void setRemainingActiveTurns(int remainingActiveTurns) {
        this.remainingActiveTurns = remainingActiveTurns;
    }

    public void tick(Character targetCharacter) {
        if (this.getRemainingActiveTurns() <= 0) return;

        int prevHp = targetCharacter.getCurHitPoints();
        targetCharacter.setCurHitPoints(prevHp - this.getTickDamage());
        this.setRemainingActiveTurns(this.getRemainingActiveTurns() - 1);
        if (this.getRemainingActiveTurns() == 0) this.cleanEffect(targetCharacter);
        this.logTickDamage(targetCharacter);
    }

    private void logTickDamage(Character targetCharacter) {
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(targetName + " está em chamas e sofreu " + this.getTickDamage() + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setCurrentStatus(null);
    }
}
