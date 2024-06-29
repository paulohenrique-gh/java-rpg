package models.playerCharacters;

import models.base.Character;
import models.base.SkillAction;
import models.skills.Heal;
import models.skills.Spell;

public class Cleric extends Character {
    private int faith;

    public Cleric() {
        super();
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
        this.setFaith(9);
    }

    private void setSkills() {
        SkillAction heal = new Heal("Heal", 50, 10);
        SkillAction divineLight = new Spell("Divine Light", 10, 15);

        this.addSkill(heal);
        this.addSkill(divineLight);
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public static String getClassDescription() {
        return "Uma curandeira com habilidades de expurgar mortos-vivos";
    }

    @Override
    public String toString() {
        return "Cleric{" +
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
