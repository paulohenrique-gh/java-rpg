package statusEffects;

import characters.base.Character;
import controllers.Battle;
import statusEffects.base.StatusEffect;

public class Stun extends StatusEffect {
    private int maxActiveTurns;
    private int remainingActiveTurns;

    public Stun() {
        super("Atordoamento", 0);
        this.maxActiveTurns = 1;
        this.remainingActiveTurns = 1;
    }

    public int getMaxActiveTurns() {
        return maxActiveTurns;
    }

    public void setMaxActiveTurns(int maxActiveTurns) {
        this.maxActiveTurns = maxActiveTurns;
    }

    public int getRemainingActiveTurns() {
        return this.remainingActiveTurns;
    }

    public void setRemainingActiveTurns(int remainingActiveTurns) {
        this.remainingActiveTurns = remainingActiveTurns;
    }

    private boolean isExpired() {
        return this.getRemainingActiveTurns() <= 0;
    }

    private boolean isFirstTurnAfterStatusApplication(Character targetCharacter) {
        return this.getRemainingActiveTurns() == this.getMaxActiveTurns() &&
                !targetCharacter.isAsleep();
    }

    @Override
    public void tick(Character targetCharacter) {
        if (this.isExpired()) {
            targetCharacter.setStunned(false);
            return;
        }

        if (this.isFirstTurnAfterStatusApplication(targetCharacter)) {
            targetCharacter.setStunned(true);
        }

        if (!targetCharacter.equals(Battle.getAtiveCharacter())) {
            return;
        }

        this.setRemainingActiveTurns(this.getRemainingActiveTurns() - 1);
        if (this.isExpired()) {
            this.cleanEffect(targetCharacter);
        }

        this.logStun(targetCharacter);
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setStunned(false);
        targetCharacter.setCurrentStatus(null);
    }

    private void logStun(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        System.out.println("================================================");
        System.out.println(targetName + " está atordado e não toma ação");
        System.out.println("================================================");
    }
}
