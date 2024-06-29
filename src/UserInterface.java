import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Character playerCharacter;

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

            break;
        }
    }

    public void chooseName() {
        System.out.println("Digite um nome para o seu personagem: ");
        String name = scanner.nextLine();
        playerCharacter.setName(name);
    }
}
