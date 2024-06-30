package actions.base;

import characters.base.Character;
import items.base.Item;
import statusEffects.Poison;

public class ItemAction extends BattleAction {
    private Item item;

    public ItemAction(Item item) {
        this.item = item;
    }

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        targetCharacter.setCurrentStatus(this.item.getEffect());
        this.logItemUsage(activeCharacter, targetCharacter);
    }

    private void logItemUsage(Character activeCharacter, Character targetCharacter) {
        String activeName = activeCharacter.getName();
        String targetName = targetCharacter.getName();

        System.out.println("================================================");
        System.out.println(activeName + " usou " + this.item.getName() + " e causou " + this.item.getEffect() + " em " + targetName);
        System.out.println("================================================");
    }
}
