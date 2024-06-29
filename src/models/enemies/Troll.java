package models.enemies;

import models.base.RegularMob;

public class Troll extends RegularMob {
    @Override
    public String toString() {
        return "Troll{" +
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
