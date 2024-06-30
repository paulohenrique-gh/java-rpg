import actions.AttackAction;
import actions.EscapeAction;
import actions.base.BattleAction;
import characters.base.Character;
import actions.base.SkillAction;
import characters.playerCharacters.Archer;
import characters.playerCharacters.Cleric;
import characters.playerCharacters.Mage;
import characters.playerCharacters.Warrior;

import java.util.List;
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
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar habilidade");
            System.out.println("3 - Fugir");

            String chosenOption = scanner.nextLine();

            switch (chosenOption) {
                case "1":
                    action = new AttackAction();
                    break;
                case "2":
                    action = this.chooseSkill();
                    break;
                case "3":
                    action = new EscapeAction();
                    break;
                default:
                    System.out.println("Opção inválida");
                    ;
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

    public Character getSelectedCharacter() {
        return this.selectedCharacter;
    }

}
