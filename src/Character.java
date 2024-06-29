import java.util.ArrayList;
import java.util.List;

public class Character {
    protected String name;
    protected int hitPoints;
    protected int strength;
    protected int defense;
    protected List<Skill> skillList;
    protected int resFire;
    protected int resIce;
    protected int resThunder;

    public Character() {
        this.skillList = new ArrayList<Skill>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public void addSkill(Skill skill) {
        this.skillList.add(skill);
    }
}
