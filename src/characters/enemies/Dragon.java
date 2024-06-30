package characters.enemies;

import characters.enemies.base.Boss;

public class Dragon extends Boss {
    public Dragon() {
        super();
        this.setName("Dragão");
        this.setMaxHitPoints(100);
        this.setCurHitPoints(100);
        this.setAttack(15);
        this.setDefense(6);
        this.setResFire(5);
        this.setResIce(-1);
        this.setResThunder(4);
        this.setResLight(3);
        this.setType("Chefe");
        this.setExp(100);
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                ", maxHitPoints=" + maxHitPoints +
                ", curHitPoints=" + curHitPoints +
                ", maxMagicPoints=" + maxMagicPoints +
                ", curMagicPoints=" + curMagicPoints +
                ", attack=" + attack +
                ", defense=" + defense +
                ", skillList=" + skillList +
                ", resFire=" + resFire +
                ", resIce=" + resIce +
                ", resThunder=" + resThunder +
                ", resLight=" + resLight +
                ", currentAction=" + currentAction +
                ", damageModifier=" + damageModifier +
                '}';
    }
}
