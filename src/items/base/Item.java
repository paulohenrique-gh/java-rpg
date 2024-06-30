package items.base;

import statusEffects.Poison;

public class Item {
    private String name;
    private int baseDamage;
    private String description;
    private Poison statusEffect;

    public Item(String name, int baseDamage, String description, Poison effect) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.description = description;
        this.statusEffect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Poison getStatusEffect() {
        return this.statusEffect;
    }

    public void setStatusEffect(Poison effect) {
        this.statusEffect = effect;
    }
}
