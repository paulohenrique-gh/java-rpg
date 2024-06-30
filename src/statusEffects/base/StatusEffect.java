package statusEffects.base;

import characters.base.Character;

public abstract class StatusEffect {
    protected String name;
    protected int tickDamage;

    protected StatusEffect(String name, int tickDamage) {
        this.name = name;
        this.tickDamage = tickDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTickDamage() {
        return tickDamage;
    }

    public void setTickDamage(int tickDamage) {
        this.tickDamage = tickDamage;
    }

    public abstract void tick(Character character);
}
