package controllers;

import actions.AttackAction;
import actions.EscapeAction;
import actions.base.BattleAction;
import actions.base.ItemAction;
import characters.base.Character;
import actions.base.SkillAction;
import characters.playerCharacters.Archer;
import characters.playerCharacters.Cleric;
import characters.playerCharacters.Mage;
import characters.playerCharacters.Warrior;
import items.Item;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Character selectedCharacter;

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
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar habilidade");
            System.out.println("3 - Usar item");
            System.out.println("4 - Fugir");

            String chosenOption = scanner.nextLine();

            switch (chosenOption) {
                case "1":
                    action = new AttackAction();
                    break;
                case "2":
                    if (this.selectedCharacter.getCurMagicPoints() <= 0) {
                        System.out.println(this.selectedCharacter.getName() + " não tem pontos de magia");
                        break;
                    }
                    action = this.chooseSkill();
                    break;
                case "3":
                    if (this.selectedCharacter.getItemList().isEmpty()) {
                        System.out.println(this.selectedCharacter.getName() + " não tem items");
                        break;
                    }
                    action = this.chooseItem();
                    break;
                case "4":
                    action = new EscapeAction();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            ;
        }

        return action;
    }

    private SkillAction chooseSkill() {
        SkillAction skill = null;

        while (skill == null) {
            System.out.println("Escolha uma habilidade:\n");
            List<SkillAction> skills = this.selectedCharacter.getSkillList();
            for (int i = 0; i < skills.size(); i++) {
                System.out.println((i + 1) + " - " + skills.get(i).getName());
            }

            String chosenOption = scanner.nextLine();

            try {
                int option = Integer.parseInt(chosenOption);
                if (option >= 1 && option <= skills.size()) {
                    skill = skills.get(option - 1);
                } else {
                    System.out.println("Opção inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }
        }

        return skill;
    }

    private ItemAction chooseItem() {
        Item item = null;

        while (item == null) {
            System.out.println("Escolha um item:\n");
            List<Item> items = this.selectedCharacter.getItemList();
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + " - " + items.get(i).getName());
            }

            String chosenOption = scanner.nextLine();

            try {
                int option = Integer.parseInt(chosenOption);
                if (option >= 1 && option <= items.size()) {
                    item = items.get(option - 1);
                } else {
                    System.out.println("Opção inválida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }
        }
        return new ItemAction(item);
    }

    public Character getSelectedCharacter() {
        return this.selectedCharacter;
    }

    public void printBattleHeader() {
        System.out.println("\n================================================");
        System.out.println("                  NOVA BATALHA                  ");
        System.out.println("================================================\n");
    }

    public void printGameOver() {
        System.out.println("\n================================================");
        System.out.println("                    GAME OVER                       ");
        System.out.println("================================================\n");
    }

}
