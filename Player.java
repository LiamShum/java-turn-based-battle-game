/**
 * This class is for the Player object that holds name and arraylist of their Pokemon team
 */
import java.util.ArrayList;
public class Player {
    // attributes
    private final String name;
    private ArrayList<Pokemon> team;

    // constructor
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

    // print out team by number
    public void printTeam() {
        int count = 1;
        for(Pokemon pokemon : team) {
            System.out.println(count + ". " + pokemon.getName() + " - " + pokemon.getType());
            count++;
        }
    }
    // print team stats
        public void printTeamStats() {
        int count = 1;
        for(Pokemon pokemon : team) {
            System.out.println(count + ". " + pokemon.toString());
            count++;
        }
    }
}
