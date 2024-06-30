package actions.base;

import characters.base.Character;
import items.Item;

public class ItemAction extends BattleAction {
    private Item item;

    public ItemAction(Item item) {
        this.item = item;
    }

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        targetCharacter.setCurrentStatus(this.item.getStatusEffect());
        activeCharacter.removeItem(this.item);
        this.logItemUsage(activeCharacter, targetCharacter);
    }

    private void logItemUsage(Character activeCharacter, Character targetCharacter) {
        String activeName = activeCharacter.getName();
        String targetName = targetCharacter.getName();
        String statusName = this.item.getStatusEffect().getName();

        System.out.println("================================================");
        System.out.println(activeName + " usou " + this.item.getName() + " e causou " + statusName + " em " + targetName);
        System.out.println("================================================");
    }
}
