package models.playerCharacters;

import models.base.Character;

public class Cleric extends Character {
    public static String getClassDescription() {
        return "Uma curandeira com habilidades de expurgar mortos-vivos";
    }

    @Override
    public String toString() {
        return "Cleric{" +
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
