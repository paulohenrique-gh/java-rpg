package characters.enemies;

import characters.base.Enemy;

public class Goblin extends Enemy {
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
        this.setResLight(2);
        this.setType("Inimigo comum");
        this.setExp(20);
    }

    @Override
    public String toString() {
        return "Goblin{" +
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
