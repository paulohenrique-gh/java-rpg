package statusEffects;

import characters.base.Character;
import statusEffects.base.StatusEffect;

public class Stun extends StatusEffect {
    private boolean isApplied;

    public Stun() {
        super("Atordoamento", 0);
        this.isApplied = false;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    @Override
    public void tick(Character targetCharacter) {
        if (this.isApplied()) return;

        targetCharacter.setCurrentStatus(null);
        this.setApplied(true);
        this.logStun(targetCharacter);
    }

    private void logStun(Character targetCharacter) {
        String targetName = targetCharacter.getName();

        System.out.println("================================================");
        System.out.println(targetName + " está atordado e não toma ação");
        System.out.println("================================================");
    }
}
