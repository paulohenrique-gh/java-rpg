package models.skills;

import models.base.Character;
import models.base.SkillAction;
import models.enemies.Skeleton;

public class Heal extends SkillAction {
    private int mpCost;

    public Heal(String name, int baseDamage, int mpCost) {
        super();
        this.mpCost = mpCost;
        this.setName(name);
        this.setType("Magia");
        this.setBaseDamage(baseDamage);
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        if (activeCharacter.getCurMagicPoints() < this.getMpCost()) {
            this.logNoMp(activeCharacter.getName());
            return;
        }

        int damage = this.getBaseDamage();
        if (targetCharacter instanceof Skeleton) {
            damage = -damage;
        } else {
            targetCharacter = activeCharacter;
        }
        int prevHp = targetCharacter.getCurHitPoints();
        int prevMp = activeCharacter.getCurMagicPoints();
        targetCharacter.setCurHitPoints(prevHp + damage);
        activeCharacter.setCurMagicPoints(prevMp - this.getMpCost());

        this.logSkillUsage(activeCharacter, targetCharacter, prevHp, prevMp);
    }

    @Override
    protected void logSkillUsage(Character activeCharacter, Character targetCharacter, int prevHp, int prevMp) {
        String activeName = activeCharacter.getName();
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();
        int curMp = targetCharacter.getCurMagicPoints();

        System.out.println("================================================");
        System.out.println(activeName + " usou " + this.getName() + " em si mesmo");
        System.out.println(activeName + " recuperou " + Math.abs(prevHp - curHp) + " pontos de vida");
        System.out.println(activeName + " tem " + curHp + " pontos de vida");
        System.out.println(activeName + " tem " + curMp + " pontos de magia");
        System.out.println("================================================");
    }
}
