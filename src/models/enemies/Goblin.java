package models.enemies;

import models.base.RegularMob;

public class Goblin extends RegularMob {
    public Goblin() {
        super();
        this.setName("Goblin");
        this.setMaxHitPoints(30);
        this.setCurHitPoints(30);
        this.setAttack(6);
        this.setDefense(2);
        this.setResFire(1);
        this.setResIce(3);
        this.setResThunder(3);
        this.setType("Inimigo comum");
        this.setExp(20);
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "name='" + name + '\'' +
                ", maxHitPoints=" + maxHitPoints +
                ", curHitPoints=" + curHitPoints +
                ", attack=" + attack +
                ", defense=" + defense +
                ", skillList=" + skillList +
                ", resFire=" + resFire +
                ", resIce=" + resIce +
                ", resThunder=" + resThunder +
                ", currentAction=" + currentAction +
                '}';
    }
}
