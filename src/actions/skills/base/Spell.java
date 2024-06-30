package actions.skills.base;

import actions.base.SkillAction;

public abstract class Spell extends SkillAction {
    public Spell(String name, int baseDamage, int mpCost) {
        super();
        this.setMpCost(mpCost);
        this.setName(name);
        this.setType("Magia");
        this.setBaseDamage(baseDamage);
    }
}
