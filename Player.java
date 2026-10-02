/**
 * This class is for the Player object that holds name and arraylist of their Pokemon team
 */
import java.util.ArrayList;
public class Player {
    // attributes
    private final String name;
    private ArrayList<Pokemon> team;
    public Player(String name) {
        this.name = name;
        team = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }
    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    // add to team
    public void addPokemon(Pokemon pokemon) {
        team.add(pokemon);
    }
}
