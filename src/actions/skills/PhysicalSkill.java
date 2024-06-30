package actions.skills;

import actions.base.SkillAction;

public class PhysicalSkill extends SkillAction {
    public PhysicalSkill(String name, int baseDamage, int mpCost) {
        super();
        this.name = name;
        this.baseDamage = baseDamage;
        this.mpCost = mpCost;
    }
}
