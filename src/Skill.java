public class Skill {
    private String name;
    private String description;
    private String type;
    private int baseDamage;

    public Skill(String name, String description, String type, int baseDamage) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.baseDamage = baseDamage;
    }

    public Skill() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
