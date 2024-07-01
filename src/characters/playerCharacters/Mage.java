package characters.playerCharacters;

import characters.base.Character;
import actions.base.SkillAction;
import actions.skills.FireSpell;
import actions.skills.IceSpell;
import actions.skills.ThunderSpell;
import items.Item;
import statusEffects.Burning;

public class Mage extends Character {
    private int intelligence;

    public Mage() {
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
        this.setIntelligence(9);
        this.setItems();
    }

    private void setSkills() {
        SkillAction fire = new FireSpell("Tempestade de Fogo", 12, 15);
        SkillAction ice = new IceSpell("Nevasca", 12, 15);
        SkillAction thunder = new ThunderSpell("Raio de Odin", 12, 15);

        this.addSkill(fire);
        this.addSkill(ice);
        this.addSkill(thunder);
    }

    private void setItems() {
        Item fireBrand = new Item("Marca de Fogo", "Causa dano de fogo no alvo a cada turno por 3 turnos", new Burning());

        this.addItem(fireBrand);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static String getClassDescription() {
        return "Um sábio capaz de conjurar as forças da natureza";
    }

    @Override
    public String toString() {
        return "Mage{" +
                "intelligence=" + intelligence +
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
