package models.skills;

import models.base.Character;
import models.base.SkillAction;

public class Spell extends SkillAction {
    private int mpCost;

    public Spell(String name, int baseDamage, int mpCost) {
        super();
        this.mpCost = mpCost;
        this.setName(name);
        this.setType("Magia");
        this.setBaseDamage(baseDamage);
    }

    @Override
    public int getMpCost() {
        return mpCost;
    }

    @Override
    public void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    //    @Override
//    public void perform(Character activeCharacter, Character targetCharacter) {
//        if (activeCharacter.getCurMagicPoints() < this.getMpCost()) {
//            this.logNoMp(activeCharacter.getName());
//            return;
//        }
//
//        int prevHp = targetCharacter.getCurHitPoints();
//        int prevMp = activeCharacter.getCurMagicPoints();
//        targetCharacter.setCurHitPoints(prevHp + targetCharacter.getDefense() - activeCharacter.getAttack());
//        activeCharacter.setCurMagicPoints(prevMp - this.getMpCost());
//
//        this.logSkillUsage(activeCharacter, targetCharacter, prevHp, targetCharacter.getCurHitPoints());
//    }
//
//    private void logSkillUsage(Character activeCharacter, Character targetCharacter, int prevHp, int prevMp) {
//        String activeName = activeCharacter.getName();
//        String targetName = targetCharacter.getName();
//        int curHp = targetCharacter.getCurHitPoints();
//        int curMp = activeCharacter.getCurMagicPoints();
//
//        System.out.println("================================================");
//        System.out.println(activeName + " usou " + this.getName() + " em " + targetName);
//        System.out.println(activeName + " causou " + (prevHp - curHp) + " de dano");
//        System.out.println(targetName + " tem " + curHp + " pontos de vida");
//        System.out.println(activeName + " tem " + curMp + " pontos de magia");
//        System.out.println("================================================");
//    }
//
//    private void logNoMp(String activeName) {
//        System.out.println(activeName + " tentou usar " + this.getName());
//        System.out.println(activeName + " não tem pontos de magia suficientes");
//    }
}
