package models.playerCharacters;

import models.base.SkillAction;
import models.base.Character;
import models.skills.Heal;

public class Warrior extends Character {
    public Warrior() {
        super();
        this.setMaxHitPoints(100);
        this.setCurHitPoints(100);
        this.setMaxMagicPoints(30);
        this.setCurMagicPoints(30);
        this.setAttack(9);
        this.setDefense(5);
        this.setResFire(5);
        this.setResIce(4);
        this.setResThunder(5);
        this.setSkills();
    }

    private void setSkills() {
        SkillAction weakHeal = new Heal("Cura Fraca", 20, 5);

        this.addSkill(weakHeal);
    }

    public static String getClassDescription() {
        return "Um herói com excelência em combate corpo-a-corpo";
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", maxHitPoints=" + maxHitPoints +
                ", curHitPoints=" + curHitPoints +
                ", maxMagicPoints=" + maxMagicPoints +
                ", curMagicPoints=" + curMagicPoints +
                ", attack=" + attack +
                ", defense=" + defense +
                ", skillList=" + skillList +
                ", resFire=" + resFire +
                ", resIce=" + resIce +
                ", resThunder=" + resThunder +
                ", currentAction=" + currentAction +
                '}';
    }
}
