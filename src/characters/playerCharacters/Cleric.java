package characters.playerCharacters;

import actions.base.SkillAction;
import actions.skills.Heal;
import actions.skills.LightSpell;
import characters.base.PlayerCharacter;
import items.Item;
import statusEffects.Sleep;

public class Cleric extends PlayerCharacter {
    private int faith;

    public Cleric() {
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
        this.setItems();
        this.setFaith(9);
    }

    private void setSkills() {
        SkillAction heal = new Heal("Cura", 50, 10);
        SkillAction divineLight = new LightSpell("Luz Divina", 10, 15);

        this.addSkill(heal);
        this.addSkill(divineLight);
    }

    private void setItems() {
        Item sleepPowder = new Item("Pó Sonífero", "Faz o alvo dormir por 3 turnos ou até ser atacado", new Sleep());

        this.addItem(sleepPowder);
    }

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public static String getClassDescription() {
        return "Uma curandeira com habilidades de expurgar mortos-vivos";
    }

    @Override
    public String toString() {
        return "Cleric{" +
                "faith=" + faith +
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
                ", currentAction=" + currentAction +
                '}';
    }
}
