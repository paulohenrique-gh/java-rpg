package models.playerCharacters;

import models.Skill;
import models.base.Character;

public class Warrior extends Character {
    public Warrior() {
        super();
        this.hitPoints = 100;
        this.attack = 9;
        this.defense = 8;
        this.resFire = 5;
        this.resIce = 4;
        this.resThunder = 5;
        this.setSkills();
    }

    private void setSkills() {
        Skill skill1 = new Skill("Jogar pedra", "físico", 5);

        this.addSkill(skill1);
    }

    public static String getClassDescription() {
        return "Um herói com excelência em combate corpo-a-corpo";
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + attack +
                ", defense=" + defense +
                ", skillList=" + skillList +
                ", resFire=" + resFire +
                ", resIce=" + resIce +
                ", resThunder=" + resThunder +
                '}';
    }
}
