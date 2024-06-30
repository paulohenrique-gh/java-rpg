package actions.skills;

import characters.base.Character;
import actions.skills.base.Spell;

public class FireSpell extends Spell {
    public FireSpell(String name, int baseDamage, int mpCost) {
        super(name, baseDamage, mpCost);
        this.setType("Fogo");
    }

    @Override
    public int calculateDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getResFire() * activeCharacter.getDamageModifier());
    }
}
