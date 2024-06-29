package models.playerCharacters;

import models.base.Character;

public class Mage extends Character {
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
