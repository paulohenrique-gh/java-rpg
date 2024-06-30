package models.skills;

import models.base.Character;
import models.skills.base.Spell;

public class LightSpell extends Spell {
    public LightSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Luz");
    }

    @Override
    public int calculateElementalDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResLight() * activeCharacter.getDamageModifier());
    }
}
