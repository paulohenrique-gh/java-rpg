package models.base;

public class SkillAction extends BattleAction {
    protected String name;
    protected String type;
    protected int baseDamage;
    protected int mpCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getMpCost() {
        return mpCost;
    }

    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public int calculateDamage(Character activeCharacter, Character targetCharacter) {
        return (int) (this.getBaseDamage() - targetCharacter.getDefense() * activeCharacter.getDamageModifier());
    }

    @Override
    public void perform(Character activeCharacter, Character targetCharacter) {
        if (activeCharacter.getCurMagicPoints() < this.getMpCost()) {
            this.logNoMp(activeCharacter.getName());
            return;
        }

        int prevHp = targetCharacter.getCurHitPoints();
        int prevMp = activeCharacter.getCurMagicPoints();
        targetCharacter.setCurHitPoints(prevHp - this.calculateDamage(activeCharacter, targetCharacter));
        activeCharacter.setCurMagicPoints(prevMp - this.getMpCost());

        this.logSkillUsage(activeCharacter, targetCharacter, prevHp, targetCharacter.getCurHitPoints());
    }

    protected void logSkillUsage(Character activeCharacter, Character targetCharacter, int prevHp, int prevMp) {
        String activeName = activeCharacter.getName();
        String targetName = targetCharacter.getName();
        int curHp = targetCharacter.getCurHitPoints();
        int curMp = activeCharacter.getCurMagicPoints();

        System.out.println("================================================");
        System.out.println(activeName + " usou " + this.getName() + " em " + targetName);
        System.out.println(activeName + " causou " + (prevHp - curHp) + " de dano");
        System.out.println(targetName + " tem " + curHp + " pontos de vida");
        System.out.println(activeName + " tem " + curMp + " pontos de magia");
        System.out.println("================================================");
    }

    protected void logNoMp(String activeName) {
        System.out.println(activeName + " tentou usar " + this.getName());
        System.out.println(activeName + " não tem pontos de magia suficientes");
    }
}
