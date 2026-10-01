public class Pokemon {
    // attributes of every pokemon
    private final String name;
    private final double maxHealth;
    private final String type; // their element type, decides of 1.5x damage

    private double currentHealth;
    private double attack; // attack damage
    private double speed; // decides who's turn is first
    
    public Pokemon(String name, double maxHealth, String type, double attack, double speed) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.type = type;
   
        this.attack = attack;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

}