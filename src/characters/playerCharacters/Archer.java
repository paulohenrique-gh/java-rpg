package characters.playerCharacters;

import characters.base.Character;
import actions.base.SkillAction;
import actions.skills.PhysicalSkill;
import items.Item;
import statusEffects.Poison;

public class Archer extends Character {
    private int dexterity;

    public Archer() {
        super();
        this.setMaxHitPoints(100);
        this.setCurHitPoints(100);
        this.setMaxMagicPoints(70);
        this.setCurMagicPoints(70);
        this.setAttack(9);
        this.setDefense(5);
        this.setResFire(5);
        this.setResIce(4);
        this.setResThunder(5);
        this.setSkills();
        this.setDexterity(9);
        this.setItems();
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    private void setSkills() {
        SkillAction arrows = new PhysicalSkill("Chuva de Flechas", 10, 5);
        SkillAction tripleAttack = new PhysicalSkill("Ataque Triplo", this.getAttack() * 3, 10);

        this.addSkill(arrows);
        this.addSkill(tripleAttack);
    }

    private void setItems() {
        Item poisonBomb = new Item("Bomba de Veneno", "Causa dano no alvo a cada rodada por 3 rodadas", new Poison());

        this.addItem(poisonBomb);
    }

    public static String getClassDescription() {
        return "Uma caçadora com a mira fatal";
    }

    @Override
    public String toString() {
        return "Archer{" +
                "dexterity=" + dexterity +
                ", name='" + name + '\'' +
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
