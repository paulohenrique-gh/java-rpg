package statusEffects;

import characters.base.Character;

public class Poison {
    private int tickDamage;

    public Poison() {
        this.tickDamage = 2;
    }

    public int getTickDamage() {
        return tickDamage;
    }

    public void setTickDamage(int tickDamage) {
        this.tickDamage = tickDamage;
    }

    public void tick(Character targetCharacter) {
        int prevHp = targetCharacter.getCurHitPoints();
        targetCharacter.setCurHitPoints(targetCharacter.getCurHitPoints() - this.tickDamage);
        this.logTickDamage(targetCharacter, prevHp);
    }

    private void logTickDamage(Character targetCharacter, int prevHp) {
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();

        System.out.println("================================================");
        System.out.println(targetName + " está envenado e sofreu " + this.getTickDamage() + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
    }
}
