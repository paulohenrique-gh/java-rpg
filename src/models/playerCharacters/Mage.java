package models.playerCharacters;

import models.base.Character;

public class Mage extends Character {
    private int intelligence;

    public Mage() {
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
        this.setIntelligence(9);
    }

    private void setSkills() {
//        SkillAction fire = new Spell()
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
