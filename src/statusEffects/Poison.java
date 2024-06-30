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

    private boolean isExpired() {
        return this.getRemainingActiveRounds() <= 0;
    }

    private int applyDamage(Character targetCharacter) {
        int prevHp = targetCharacter.getCurHitPoints();
        int damageApplied = this.tickDamage;
        targetCharacter.setCurHitPoints(prevHp - damageApplied);

        return damageApplied;
    }

    @Override
    public void tick(Character targetCharacter) {
        if (this.isExpired() || this.isSameRound()) return;

        int damageTaken = applyDamage(targetCharacter);
        this.setRemainingActiveRounds(this.remainingActiveRounds - 1);
        if (this.isExpired()) this.cleanEffect(targetCharacter);
        this.setLastActiveRound(Battle.getCurrentRound());
        this.logTickDamage(targetCharacter, damageTaken);
    }

    private void logTickDamage(Character targetCharacter, int damageTaken) {
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(targetName + " está envenado e sofreu " + damageTaken + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
        System.out.println("================================================");
    }

    private void cleanEffect(Character targetCharacter) {
        targetCharacter.setCurrentStatus(null);
    }
}
