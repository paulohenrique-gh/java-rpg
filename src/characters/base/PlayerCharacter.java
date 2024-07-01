package characters.base;

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
            this.setLevel(this.getLevel() + 1);
            this.setExpToNextLevel(this.getLevel() * 20);
        }
    }
}
