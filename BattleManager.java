import java.util.ArrayList;

public class BattleManager {
    private ArrayList<Character> characters = new ArrayList<>();

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public void initializeCharacters(){
        ArrayList<Character> characters = new ArrayList<>();
        characters.add(new Character("Darrius","warrior",150,10,35,40));
        characters.add(new Character("Frost","mage",100,7,20,35));
        characters.add(new Character("Kratos","archer",120,9,25,45));
        characters.add(new Character("Nitara","mage",105,8,15,50));
        setCharacters(characters);
    }

    public void displayCharacters(){
        ArrayList<Character> characters = getCharacters();
        for (Character character : characters){
            if(character.getPlayerAssigned()==0){
                System.out.println("Name: " + character.getName() + " Category: " + character.getCategory() + " Health: " + character.getLifePoints() + " Power attack: " + character.getAttackPower() + " Special power: " + character.getSpecialPower() + " Strength: " + character.getStrength() + " Speed: " + character.getSpeed());
            }
        }
    }

    public boolean validateCharacter(String characterName) throws CharacterNotFoundException {
        ArrayList<Character> characters = getCharacters();
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(characterName)) {
                return true;
            }
        }
        throw new CharacterNotFoundException("The character " + characterName + " was not found");
    }

    public Character assignPlayerToCharacter(String characterName, int player) throws CharacterNotFoundException{
        ArrayList<Character> characters = getCharacters();
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(characterName) && character.getPlayerAssigned() == 0) {
                character.setPlayerAssigned(player);
                setCharacters(characters);
                System.out.println("Player " + player + " chose " + character.getName());
                return character;
            }
        }
        throw new CharacterNotFoundException("The character " + characterName + " was not found or was already chosen by other player");
    }

    public Character attack(Character player, Character target) throws InvalidActionException {
        target.setLifePoints(target.getLifePoints() - player.getAttackPower());
        System.out.println(player.getName() + " attacked " + target.getName() + ", causing " + player.getAttackPower() + " points of damage");
        return target;
    }

    public Character useSpecialAbility(Character player, Character target) throws InvalidActionException {
        target.setLifePoints(target.getLifePoints() - player.getSpecialPower());
        System.out.println(player.getName() + " attacked " + target.getName() + " with special power, causing " + player.getSpecialPower() + " points of damage");
        return target;
    }
}
