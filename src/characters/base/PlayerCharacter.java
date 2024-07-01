package characters.base;

import controllers.UserInterface;

public class PlayerCharacter extends Character {
    protected int exp;
    protected int level;
    protected int expToNextLevel;

    public PlayerCharacter() {
        super();
        this.exp = 0;
        this.level = 1;
        this.expToNextLevel = this.level * 20;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public void setExpToNextLevel(int expToNextLevel) {
        this.expToNextLevel = expToNextLevel;
    }

    public void updateExp(int expOnKill) {
       this.setExp(this.getExp() + expOnKill);

        while (this.getExp() >= this.getExpToNextLevel()) {
            this.setExp(this.getExp() - this.getExpToNextLevel());
            this.updateAttributes();
            this.levelUp();
            this.setExpToNextLevel(this.getLevel() * 20);
        }
    }

    private void levelUp() {
        this.setLevel(this.getLevel() + 1);
        UserInterface.printLevelUp(this);
    }

    private void updateAttributes() {
        this.setMaxHitPoints((int) (this.getMaxHitPoints() + this.getMaxHitPoints() * 0.1));
        this.setCurHitPoints((int) (this.getCurHitPoints() + this.getCurHitPoints() * 0.1));
        this.setMaxMagicPoints((int) (this.getMaxMagicPoints() + this.getMaxMagicPoints() * 0.1));
        this.setCurMagicPoints((int) (this.getCurMagicPoints() + this.getCurMagicPoints() * 0.1));
        this.setAttack(this.getAttack() + this.getLevel());
        this.setDefense(this.getDefense() + this.getLevel());
        this.setResFire(this.getResFire() + this.getLevel());
        this.setResIce(this.getResIce() + this.getLevel());
        this.setResLight(this.getResLight() + this.getLevel());
    }
}
