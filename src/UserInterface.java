import models.actions.AttackAction;
import models.actions.EscapeAction;
import models.base.BattleAction;
import models.base.Character;
import models.playerCharacters.Archer;
import models.playerCharacters.Cleric;
import models.playerCharacters.Mage;
import models.playerCharacters.Warrior;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Character selectedCharacter;

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
                    selectedCharacter = new Warrior();
                    break;
                case "2":
                    selectedCharacter = new Mage();
                    break;
                case "3":
                    selectedCharacter = new Cleric();
                    break;
                case "4":
                    selectedCharacter = new Archer();
                    break;
                default: {
                    System.out.println("Opção inválida\n");
                    continue;
                }
            }

            this.chooseName();

            break;
        }
    }

    public void chooseName() {
        System.out.println("Digite um nome para o seu personagem: ");
        String name = scanner.nextLine();
        this.selectedCharacter.setName(name);
    }

    public BattleAction chooseAction() {
        BattleAction action = null;

        while (action == null) {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Atacar\n");
            System.out.println("2 - Fugir\n");

            String chosenOption = scanner.nextLine();

            switch(chosenOption) {
                case "1":
                    action = new AttackAction();
                    break;
                case "2":
                    action = new EscapeAction();
                    break;
                default:
                    System.out.println("Opção inválida");;
            };
        }

        return action;
    }

    public Character getSelectedCharacter() {
        return this.selectedCharacter;
    }

}
