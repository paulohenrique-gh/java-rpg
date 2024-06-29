package models.skills;

import models.base.Character;
import models.base.SkillAction;
import models.enemies.Skeleton;

public class WeakHeal extends SkillAction {
    private boolean isSkeleton;

    public WeakHeal() {
        super();
        this.setIsSkeleton(false);
        this.setName("Cura Fraca");
        this.setType("Magia");
        this.setBaseDamage(20);
    }

    public boolean isSkeleton() {
        return isSkeleton;
    }

    public void setIsSkeleton(boolean isSkeleton) {
        this.isSkeleton = isSkeleton;
    }

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        int damage = this.getBaseDamage();
        if (targetCharacter instanceof Skeleton) {
            this.setIsSkeleton(true);
            damage = -damage;
        } else {
            targetCharacter = activeCharacter;
        }
        int prevHp = targetCharacter.getCurHitPoints();
        targetCharacter.setCurHitPoints(prevHp + damage);

        this.logSkillUsage(activeCharacter.getName(), targetCharacter.getName(), prevHp, targetCharacter.getCurHitPoints());
    }

    private void logSkillUsage(String activeName, String targetName, int prevHp, int curHp) {
        System.out.println("================================================");
        if (this.isSkeleton()) {
            System.out.println(activeName + " usou " + this.getName() + " em " + targetName);
            System.out.println(activeName + " causou " + (prevHp - curHp) + " de dano");
            System.out.println(targetName + " tem " + curHp + " pontos de vida");
        } else {
            System.out.println(activeName + " usou " + this.getName() + " em si mesmo");
            System.out.println(activeName + " recuperou " + Math.abs(prevHp - curHp) + " pontos de vida");
            System.out.println(activeName + " tem " + curHp + " pontos de vida");
        }
        System.out.println("================================================");
    }
}
