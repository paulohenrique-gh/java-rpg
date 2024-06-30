package models.playerCharacters;

import models.base.Character;
import models.base.SkillAction;
import models.skills.FireSpell;
import models.skills.IceSpell;
import models.skills.ThunderSpell;

public class Mage extends Character {
    private int intelligence;

    public Mage() {
        super();
        this.intelligence = 9;
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
        SkillAction fire = new FireSpell("Tempestade de Fogo", 12, 15);
        SkillAction ice = new IceSpell("Nevasca", 12, 15);
        SkillAction thunder = new ThunderSpell("Raio de Odin", 12, 15);

        this.addSkill(fire);
        this.addSkill(ice);
        this.addSkill(thunder);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static String getClassDescription() {
        return "Um sábio capaz de conjurar as forças da natureza";
    }

    @Override
    public String toString() {
        return "Mage{" +
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
