public class UserInterface {
    public void mainMenu() {
        while (true) {
            String welcomeText = "Bem-vindo ao jogo!\n\n" +
                    "Escolha uma classe: \n" +
                    "1 - Guerreiro: " + Warrior.getClassDescription() + "\n" +
                    "2 - Mago: " + Mage.getClassDescription() + "\n" +
                    "3 - Clérigo: " + Cleric.getClassDescription() + "\n" +
                    "4 - Arqueiro: " + Archer.getClassDescription();

            System.out.println(welcomeText);

            break;
        }
    }
}
