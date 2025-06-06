import java.util.Scanner;

public class FantasyBattleSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BattleManager battleManager = new BattleManager();
        Character characterPlayer1 = new Character();
        Character characterPlayer2 = new Character();
        try {
            battleManager.initializeCharacters();

            System.out.println("Player 1, Choose one of the following characters:");
            battleManager.displayCharacters();
            String player1Character = scanner.nextLine();
            if(battleManager.validateCharacter(player1Character)){
                characterPlayer1 = battleManager.assignPlayerToCharacter(player1Character,1);
            }

            System.out.println("Player 2, Choose one of the following characters:");
            battleManager.displayCharacters();
            String player2Character = scanner.nextLine();
            if(battleManager.validateCharacter(player2Character)){
                characterPlayer2 = battleManager.assignPlayerToCharacter(player2Character,2);
            }

            System.out.println("Battle starts!!! " + characterPlayer1.getName().toUpperCase() + " VS " + characterPlayer2.getName().toUpperCase());
            boolean winnerExist=false;
            do{
                System.out.println("Player 1....which action do you want to do? (attack/special): ");
                String action = scanner.nextLine();

                if ("attack".equalsIgnoreCase(action)) {
                    characterPlayer2 = battleManager.attack(characterPlayer1, characterPlayer2);
                } else if ("special".equalsIgnoreCase(action)) {
                    characterPlayer2 = battleManager.useSpecialAbility(characterPlayer1, characterPlayer2);
                } else {
                    throw new InvalidActionException("Invalid action: " + action);
                }

                if(characterPlayer2.getLifePoints()<=0){
                    System.out.println(characterPlayer2.getName() + "KO, The player 1 WON!");
                    break;
                } else {
                    System.out.println("Current status:");
                    System.out.println("Player " + characterPlayer1.getPlayerAssigned() + " - Character: " + characterPlayer1.getName() + " Health: " + characterPlayer1.getLifePoints());
                    System.out.println("Player " + characterPlayer2.getPlayerAssigned() + " - Character: " + characterPlayer2.getName() + " Health: " + characterPlayer2.getLifePoints());
                }

                System.out.println("Player 2....which action do you want to do? (attack/special): ");
                action = scanner.nextLine();

                if ("attack".equalsIgnoreCase(action)) {
                    characterPlayer1 = battleManager.attack(characterPlayer2, characterPlayer1);
                } else if ("special".equalsIgnoreCase(action)) {
                    characterPlayer1 = battleManager.useSpecialAbility(characterPlayer2, characterPlayer1);
                } else {
                    throw new InvalidActionException("Invalid action: " + action);
                }

                if(characterPlayer1.getLifePoints()<=0){
                    System.out.println(characterPlayer1.getName() + "KO, The player 2 WON!");
                    winnerExist=true;
                } else {
                    System.out.println("Current status:");
                    System.out.println("Player " + characterPlayer2.getPlayerAssigned() + " - Character: " + characterPlayer2.getName() + " Health: " + characterPlayer2.getLifePoints());
                    System.out.println("Player " + characterPlayer1.getPlayerAssigned() + " - Character: " + characterPlayer1.getName() + " Health: " + characterPlayer1.getLifePoints());
                }
            }while (!winnerExist);

        } catch (CharacterNotFoundException | InvalidActionException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("GAME OVER");
            scanner.close();
            battleManager.initializeCharacters();
        }
    }
}
