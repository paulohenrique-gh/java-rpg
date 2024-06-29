import models.base.Character;
import models.base.Enemy;

public class Battle {
    private Character playerCharacter;
    private Enemy enemy;
    private Character[] turnOrder;

    public Battle(Character playerCharacter, Enemy enemy) {
        this.playerCharacter = playerCharacter;
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Character getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Character playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public void generateTurnOrder() {
        if (Math.random() < 0.5) {
            this.turnOrder = new Character[] {this.playerCharacter, this.enemy};
        } else {
            this.turnOrder = new Character[] {this.enemy, this.playerCharacter};
        }
    }
}
