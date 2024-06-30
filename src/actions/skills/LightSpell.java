package actions.skills;

import characters.base.Character;
import actions.skills.base.Spell;

public class LightSpell extends Spell {
    public LightSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Luz");
    }

    @Override
    public int calculateDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResLight() * activeCharacter.getDamageModifier());
    }
}
