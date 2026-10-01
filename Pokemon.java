
import java.util.HashMap;

public class Pokemon {

    // attributes of every pokemon
    private final String name;
    private final double maxHealth = 500;
    private final String type1; // their element type, decides of 1.5x damage
    private final String type2; // their element type, decides of 1.5x damage

    private double currentHealth;
    //private double attack;
    private int speed; // decides who's turn is first

    // moveset
    private HashMap<String, Double> moves;

    // Constructor
    public Pokemon(String name, double maxHealth, String type1, String type2) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.speed = (int) (Math.random() * 51);
        moves = new HashMap<>();
    } // Pokemon()

    // getters
    public double getHealth() {
        return currentHealth;
    }

    public double getSpeed() {
        return speed;
    }

    public String getType() {
        return type1 + ", " + type2;
    }
    // setters

    public void setMove(String moveName, double damage) {
        if (moves.size() < 4) {
            moves.put(moveName, damage);
        }
    }

    public void damage(double dmg) {
        currentHealth -= dmg;
    }

    public String getName() {
        return name;
    } // getName()

} // Pokemon
