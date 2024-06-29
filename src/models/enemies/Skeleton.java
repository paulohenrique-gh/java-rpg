package models.enemies;

import models.base.RegularMob;

public class Skeleton extends RegularMob {
    @Override
    public String toString() {
        return "Skeleton{" +
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
