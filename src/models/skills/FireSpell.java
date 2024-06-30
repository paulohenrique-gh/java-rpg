package models.skills;

import models.base.Character;
import models.skills.base.Spell;

public class FireSpell extends Spell {
    public FireSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Fogo");
    }

    @Override
    public int calculateElementalDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResFire() * activeCharacter.getDamageModifier());
    }
}
