package models.playerCharacters;

import models.base.Character;

public class Archer extends Character {
    public static String getClassDescription() {
        return "Uma caçadora com a mira fatal";
    }

    @Override
    public String toString() {
        return "Archer{" +
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
