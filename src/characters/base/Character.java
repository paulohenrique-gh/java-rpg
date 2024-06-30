package characters.base;

import actions.base.BattleAction;
import actions.base.SkillAction;
import items.Item;
import statusEffects.Sleep;
import statusEffects.base.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Character {
    protected String name;
    protected int maxHitPoints;
    protected int curHitPoints;
    protected int maxMagicPoints;
    protected int curMagicPoints;
    protected int attack;
    protected int defense;
    protected List<SkillAction> skillList;
    protected List<Item> itemList;
    protected int resFire;
    protected int resIce;
    protected int resThunder;
    protected int resLight;
    protected BattleAction currentAction;
    protected double damageModifier;
    protected StatusEffect currentStatus;
    protected boolean isAsleep;

    public Character() {
        this.skillList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        this.damageModifier = 1.0;
        this.isAsleep = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getCurHitPoints() {
        return curHitPoints;
    }

    public void setCurHitPoints(int curHitPoints) {
        this.curHitPoints = curHitPoints;

        if (this.curHitPoints > this.maxHitPoints) this.curHitPoints = this.maxHitPoints;
        if (this.curHitPoints < 0) this.curHitPoints = 0;
    }

    public int getMaxMagicPoints() {
        return maxMagicPoints;
    }

    public void setMaxMagicPoints(int maxMagicPoints) {
        this.maxMagicPoints = maxMagicPoints;
    }

    public int getCurMagicPoints() {
        return curMagicPoints;
    }

    public void setCurMagicPoints(int curMagicPoints) {
        this.curMagicPoints = curMagicPoints;

        if (this.curMagicPoints > this.maxMagicPoints) this.curMagicPoints = this.maxMagicPoints;
        if (this.curMagicPoints < 0) this.curMagicPoints = 0;
    }

    public void setSkillList(List<SkillAction> skillList) {
        this.skillList = skillList;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResFire() {
        return resFire;
    }

    public void setResFire(int resFire) {
        this.resFire = resFire;
    }

    public int getResIce() {
        return resIce;
    }

    public void setResIce(int resIce) {
        this.resIce = resIce;
    }

    public int getResThunder() {
        return resThunder;
    }

    public void setResThunder(int resThunder) {
        this.resThunder = resThunder;
    }

    public int getResLight() {
        return resLight;
    }

    public void setResLight(int resLight) {
        this.resLight = resLight;
    }

    public BattleAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(BattleAction currentAction) {
        this.currentAction = currentAction;
    }

    public boolean isAsleep() {
        return isAsleep;
    }

    public void setAsleep(boolean asleep) {
        isAsleep = asleep;
    }

    public void addSkill(SkillAction skill) {
        this.skillList.add(skill);
    }

    public List<SkillAction> getSkillList() {
        return this.skillList;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public StatusEffect getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(StatusEffect currentStatus) {
        this.currentStatus = currentStatus;
    }

    private int calculateAttackDamage(Character targetCharacter) {
        int damage = this.getAttack() - targetCharacter.getDefense();

        if (damage < 0) damage = 0;

        return (int) (damage * this.getDamageModifier());
    }

    public void performAction(Character targetCharacter) {
        if (this.isAsleep()) return;

        this.currentAction.perform(this, targetCharacter);
    }

    public void onTurnEnd() {
        if (this.currentStatus == null) return;

        this.currentStatus.tick(this);
    }
}
