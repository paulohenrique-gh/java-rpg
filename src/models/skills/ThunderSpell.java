package models.skills;

import models.base.Character;
import models.skills.base.Spell;

public class ThunderSpell extends Spell {
    public ThunderSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Raio");
    }

    @Override
    public int calculateDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResThunder() * activeCharacter.getDamageModifier());
    }
}
