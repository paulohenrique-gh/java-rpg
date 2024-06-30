package characters.base;

import actions.AttackAction;
import actions.base.BattleAction;

public class Enemy extends Character {
    private String type;
    private int exp;

    @Override
    public void setCurrentAction(BattleAction currentAction) {
        currentAction = new AttackAction();
        this.currentAction = currentAction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
