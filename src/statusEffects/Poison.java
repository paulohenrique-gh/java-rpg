package statusEffects;

import characters.base.Character;
import controllers.Battle;
import statusEffects.base.StatusEffect;

public class Poison extends StatusEffect {
    private int remainingActiveRounds;
    private int lastActiveRound;

    public Poison() {
        super("Veneno", 2);
        this.remainingActiveRounds = 3;
        this.lastActiveRound = 0;
    }

    public int getRemainingActiveRounds() {
        return remainingActiveRounds;
    }

    public void setRemainingActiveRounds(int remainingActiveRounds) {
        this.remainingActiveRounds = remainingActiveRounds;
    }

    public int getLastActiveRound() {
        return lastActiveRound;
    }

    public void setLastActiveRound(int lastActiveRound) {
        this.lastActiveRound = lastActiveRound;
    }

    private boolean isSameRound() {
        return this.getLastActiveRound() == Battle.getCurrentRound();
    }

    private boolean isRemainingRoundsEmpty() {
        return this.getRemainingActiveRounds() == 0;
    }

    @Override
    public void tick(Character targetCharacter) {
        if (this.isRemainingRoundsEmpty() || this.isSameRound()) return;

        int prevHp = targetCharacter.getCurHitPoints();
        targetCharacter.setCurHitPoints(prevHp - this.tickDamage);
        this.setRemainingActiveRounds(this.remainingActiveRounds - 1);
        if (this.getRemainingActiveRounds() <= 0) this.cleanEffect(targetCharacter);
        this.setLastActiveRound(Battle.getCurrentRound());
        this.logTickDamage(targetCharacter);
    }

    private void logTickDamage(Character targetCharacter) {
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(targetName + " está envenado e sofreu " + this.getTickDamage() + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setCurrentStatus(null);
    }
}
