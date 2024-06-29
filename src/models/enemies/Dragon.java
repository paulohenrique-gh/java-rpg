package models.enemies;

import models.base.Boss;

public class Dragon extends Boss {
    public Dragon() {
        super();
        this.setName("Dragão");
        this.setHitPoints(100);
        this.setAttack(15);
        this.setDefense(6);
        this.setResFire(5);
        this.setResIce(-1);
        this.setResThunder(4);
        this.setType("Chefe");
        this.setExp(100);
    }

    @Override
    public String toString() {
        return "Dragon{" +
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
