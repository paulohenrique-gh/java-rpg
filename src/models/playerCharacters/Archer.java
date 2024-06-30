package models.playerCharacters;

import models.base.Character;
import models.base.SkillAction;
import models.skills.PhysicalSkill;

public class Archer extends Character {
    private int dexterity;

    public Archer() {
        super();
        this.dexterity = 9;
        this.setMaxHitPoints(100);
        this.setCurHitPoints(100);
        this.setMaxMagicPoints(70);
        this.setCurMagicPoints(70);
        this.setAttack(9);
        this.setDefense(5);
        this.setResFire(5);
        this.setResIce(4);
        this.setResThunder(5);
        this.setSkills();
    }

    private void setSkills() {
        SkillAction arrows = new PhysicalSkill("Chuva de Flechas", 10, 5);
        SkillAction tripleAttack = new PhysicalSkill("Ataque Triplo", this.getAttack() * 3, 10);

        this.addSkill(arrows);
        this.addSkill(tripleAttack);
    }

    public static String getClassDescription() {
        return "Uma caçadora com a mira fatal";
    }

    @Override
    public String toString() {
        return "Archer{" +
                "name='" + name + '\'' +
                ", hitPoints=" + maxHitPoints +
                ", strength=" + attack +
                ", defense=" + defense +
                ", skillList=" + skillList +
                ", resFire=" + resFire +
                ", resIce=" + resIce +
                ", resThunder=" + resThunder +
                '}';
    }
}
