package statusEffects;

import characters.base.Character;

public class Poison {
    private String name;
    private int tickDamage;
    private int remainingActiveTurns;

    public Poison() {
        this.name = "Veneno";
        this.tickDamage = 2;
        this.remainingActiveTurns = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTickDamage() {
        return tickDamage;
    }

    public void setTickDamage(int tickDamage) {
        this.tickDamage = tickDamage;
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
        targetCharacter.setCurHitPoints(targetCharacter.getCurHitPoints() - this.tickDamage);
        this.setRemainingActiveTurns(this.remainingActiveTurns - 1);
        if (this.getRemainingActiveTurns() <= 0) this.cleanEffect(targetCharacter);
        this.logTickDamage(targetCharacter, prevHp);
    }

    private void logTickDamage(Character targetCharacter, int prevHp) {
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
