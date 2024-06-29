import models.base.Boss;
import models.base.Character;
import models.base.Enemy;
import models.base.RegularMob;
import models.enemies.Dragon;
import models.enemies.Goblin;
import models.enemies.Skeleton;
import models.enemies.Troll;
import models.playerCharacters.Archer;
import models.playerCharacters.Cleric;
import models.playerCharacters.Mage;
import models.playerCharacters.Warrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Character playerCharacter;
    Game game = new Game();

    public void mainMenu() {
        System.out.println("Bem-vindo ao Jogo!");


        while (true) {
            String classOptions = "Escolha uma classe: \n" +
                    "1 - Guerreiro: " + Warrior.getClassDescription() + "\n" +
                    "2 - Mago: " + Mage.getClassDescription() + "\n" +
                    "3 - Clérigo: " + Cleric.getClassDescription() + "\n" +
                    "4 - Arqueiro: " + Archer.getClassDescription();

            System.out.println(classOptions);

            String chosenOption = scanner.nextLine();

            switch (chosenOption) {
                case "1":
                    playerCharacter = new Warrior();
                    break;
                case "2":
                    playerCharacter = new Mage();
                    break;
                case "3":
                    playerCharacter = new Cleric();
                    break;
                case "4":
                    playerCharacter = new Archer();
                    break;
                default: {
                    System.out.println("Opção inválida\n");
                    continue;
                }
            }

            this.chooseName();
            this.game.setPlayerCharacter(playerCharacter);
            this.setGameEnemies();
            this.game.start();

            break;
        }
    }

    public void chooseName() {
        System.out.println("Digite um nome para o seu personagem: ");
        String name = scanner.nextLine();
        playerCharacter.setName(name);
    }

    public void setGameEnemies() {
        RegularMob enemy1 = new Goblin();
//        RegularMob enemy2 = new Skeleton();
//        RegularMob enemy3 = new Troll();
//        Boss boss = new Dragon();

//        this.game.setEnemies(new ArrayList<Enemy>(Arrays.asList(enemy1, enemy2, enemy3, boss)));
        this.game.setEnemies(new ArrayList<Enemy>(List.of(enemy1)));
    }
}
