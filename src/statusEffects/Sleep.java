package statusEffects;

import characters.base.Character;
import controllers.Battle;
import statusEffects.base.StatusEffect;

public class Sleep extends StatusEffect {
    private int maxActiveTurns;
    private int remainingActiveTurns;

    public Sleep() {
        super("Sono", 0);
        this.maxActiveTurns = 3;
        this.remainingActiveTurns = 3;
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
            targetCharacter.setAsleep(false);
            return;
        }

        if (this.isFirstTurnAfterStatusApplication(targetCharacter)) {
            targetCharacter.setAsleep(true);
        }

        if (!targetCharacter.equals(Battle.getAtiveCharacter())) {
            return;
        }

        this.setRemainingActiveTurns(this.getRemainingActiveTurns() - 1);
        if (this.isExpired()) {
            this.cleanEffect(targetCharacter);
        }

        this.logSleep(targetCharacter);
    }

    public void logSleep(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        System.out.println("================================================");
        System.out.println(targetName + " está dormindo");
        System.out.println("================================================");
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setAsleep(false);
        targetCharacter.setCurrentStatus(null);
    }
}
