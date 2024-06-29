import java.util.List;

public class Warrior extends Character {
    public Warrior() {
        super();
        this.hitPoints = 100;
        this.strength = 9;
        this.defense = 8;
        this.resFire = 5;
        this.resIce = 4;
        this.resThunder = 5;
    }

    public static String getClassDescription() {
        return "Um herói com excelência em combate corpo-a-corpo";
    }
}
