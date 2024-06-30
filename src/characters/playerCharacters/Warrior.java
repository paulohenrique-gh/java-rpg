package characters.playerCharacters;

import actions.base.SkillAction;
import characters.base.Character;
import actions.skills.Heal;
import items.base.Item;
import statusEffects.Poison;

public class Warrior extends Character {
    public Warrior() {
        super();
        this.setMaxHitPoints(100);
        this.setCurHitPoints(100);
        this.setMaxMagicPoints(30);
        this.setCurMagicPoints(30);
        this.setAttack(9);
        this.setDefense(5);
        this.setResFire(5);
        this.setResIce(4);
        this.setResThunder(5);
        this.setSkills();
        this.setItems();
    }

    private void setSkills() {
        SkillAction weakHeal = new Heal("Cura Fraca", 20, 5);

        this.addSkill(weakHeal);
    }

    private void setItems() {
        Item poisonBomb = new Item("Bomba de Veneno", 0, "Causa dano no alvo a cada rodada", new Poison());

        this.addItem(poisonBomb);
    }

    public static String getClassDescription() {
        return "Um herói com excelência em combate corpo-a-corpo";
    }

    @Override
    public String toString() {
        return "Warrior{" +
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
