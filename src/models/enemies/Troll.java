package models.enemies;

import models.base.RegularMob;

public class Troll extends RegularMob {
    public Troll() {
        super();
        this.setName("Troll");
        this.setMaxHitPoints(60);
        this.setCurHitPoints(60);
        this.setAttack(9);
        this.setDefense(5);
        this.setResFire(4);
        this.setResIce(2);
        this.setResThunder(-4);
        this.setResLight(3);
        this.setType("Inimigo comum");
        this.setExp(50);
    }

    @Override
    public String toString() {
        return "Troll{" +
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
