package models.enemies;

import models.base.RegularMob;

public class Goblin extends RegularMob {
    @Override
    public String toString() {
        return "Goblin{" +
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
