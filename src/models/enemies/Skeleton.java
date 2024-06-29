package models.enemies;

import models.base.RegularMob;

public class Skeleton extends RegularMob {
    public Skeleton() {
        super();
        this.setName("Esqueleto");
        this.setMaxHitPoints(45);
        this.setCurHitPoints(45);
        this.setAttack(8);
        this.setDefense(4);
        this.setResFire(-3);
        this.setResIce(5);
        this.setResThunder(2);
        this.setType("Inimigo comum");
        this.setExp(35);
    }

    @Override
    public String toString() {
        return "Skeleton{" +
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
