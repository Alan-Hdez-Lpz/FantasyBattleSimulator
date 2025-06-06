public class Character {
    private String name;
    private String category;
    private int lifePoints;
    private int attackPower;
    private int specialPower;
    private int strength;
    private int speed;
    private int playerAssigned;

    public Character(){

    }

    public Character(String name, String category, int lifePoints, int attackPower, int strength, int speed) {
        this.name = name;
        this.category = category;
        this.lifePoints = lifePoints;
        this.attackPower = attackPower;
        this.specialPower = attackPower + strength + speed;
        this.strength = strength;
        this.speed = speed;
        this.playerAssigned = 0;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getSpecialPower() {
        return specialPower;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPlayerAssigned() {
        return playerAssigned;
    }

    public void setPlayerAssigned(int playerAssigned) {
        this.playerAssigned = playerAssigned;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
