package models.base;

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
    protected int resFire;
    protected int resIce;
    protected int resThunder;
    protected BattleAction currentAction;

    public Character() {
        this.skillList = new ArrayList<SkillAction>();
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

    public BattleAction getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(BattleAction currentAction) {
        this.currentAction = currentAction;
    }

    public void addSkill(SkillAction skill) {
        this.skillList.add(skill);
    }

    public List<SkillAction> getSkillList() {
        return this.skillList;
    }

    private int calculateDamage() {
        // TODO
        return 0;
    }

    public void performAction(Character targetCharacter) {
        this.currentAction.perform(this, targetCharacter);
    }
}
