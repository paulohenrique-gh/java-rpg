package models.skills;

import models.base.Character;
import models.skills.base.Spell;

public class IceSpell extends Spell {
    public IceSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Gelo");
    }

    @Override
    public int calculateDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResIce() * activeCharacter.getDamageModifier());
    }
}
