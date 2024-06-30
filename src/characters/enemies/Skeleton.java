package characters.enemies;

import characters.base.Enemy;

public class Skeleton extends Enemy {
    public Skeleton() {
        super();
        this.setName("Esqueleto");
        this.setMaxHitPoints(45);
        this.setCurHitPoints(45);
        this.setAttack(8);
        this.setDefense(4);
        this.setResFire(1);
        this.setResIce(5);
        this.setResThunder(2);
        this.setResLight(-3);
        this.setType("Inimigo comum");
        this.setExp(35);
    }

    @Override
    public String toString() {
        return "Skeleton{" +
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
