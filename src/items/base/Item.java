package items.base;

import statusEffects.base.StatusEffect;

public class Item {
    private String name;
    private String description;
    private StatusEffect statusEffect;

    public Item(String name, String description, StatusEffect effect) {
        this.name = name;
        this.description = description;
        this.statusEffect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEffect getStatusEffect() {
        return this.statusEffect;
    }

    public void setStatusEffect(StatusEffect effect) {
        this.statusEffect = effect;
    }
}
