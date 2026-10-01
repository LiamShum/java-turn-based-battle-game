

public class Pokemon {

    

    // attributes of every pokemon
    private final String name;
    private final double maxHealth;
    private final String type; // their element type, decides of 1.5x damage

    private double currentHealth;
    private double attack; // attack damage
    private double speed; // decides who's turn is first

    // Constructor
    public Pokemon(String name, double maxHealth, String type, double attack, double speed) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.type = type;

        this.attack = attack;
        this.speed = speed;
    } // Pokemon()

    // getters
    public double getHealth() {
        return currentHealth;
    }
    public double getSpeed() {
        return speed;
    }
    public String getType() {
        return type;
    }
    // setters

    public void damage(double dmg) {
        currentHealth -= dmg;
    }
    public String getName() {
        return name;
    } // getName()

} // Pokemon
