import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * This class makes the CPU the player will go against, inherits the Player class
 */
public class CPU extends Player {

    private static final Random random = new Random();

    // list of random pokemon names
    private static final String[] names = {
        "Flamora", "Voltusk", "Aquadon", "Thornix", "Frostel",
        "Pyronox", "Zaplet", "Grumpleaf", "Rockoon", "Mistfang",
        "Emberjaw", "Glaciro", "Stormite", "Venomaw", "Terrabite",
        "Skyrend", "Mossling", "Shocktail", "Cindrake", "Bubblehorn",
        "Nightusk", "Lunaclaw", "Solafang", "Bramblet", "Magmutt",
        "Cryowisp", "Dusthorn", "Sparko", "Seaflare", "Ironimp",
        "Shadowlurk", "Bloomjaw", "Thunderox", "Pebblit", "Ashwing",
        "Frostfang", "Sludgehorn", "Windrake", "Toxipup", "Rootusk",
        "Blazeling", "Stormpaw", "Moonimp", "Crystalix", "Mudfang",
        "Sparkfin", "Thornclaw", "Infercub", "Aquafox", "Duskwing"
    };

    // constructor
    public CPU(Player player) {
        super("CPU");
        int teamSize = player.getTeam().size();

        for(int n = 0; n < teamSize; n++) { // adds random pokemon to CPU team
            Pokemon pokemon = createRandomPokemon();
            addPokemon(pokemon);
        }
    }

    // method to create random pokmeon
    public Pokemon createRandomPokemon() {
        // need all types
        ArrayList<String> types = MoveLibrary.getAllTypes();

        // pick random name
        String name = names[random.nextInt(names.length)];

        // get first random type
        int index1 = random.nextInt(types.size());
        String type1 = types.get(index1);
        
        // get second random type, not the same as the first
        int index2;
        do { 
            index2 = random.nextInt(types.size());
        } while (index1 == index2);
        String type2 = types.get(index2);

        // initialize the new pokemon
        Pokemon pokemon = new Pokemon(name, type1, type2);

        // get all available moves for the type
        HashMap<String, Double> availableMoves = MoveLibrary.getAvailableMoves(type1, type2);
        ArrayList<String> moveNames = new ArrayList<>(availableMoves.keySet()); // gets all names
        // loop to pick 4 random moves
        String moveName;
        int randomInt;
        for(int n = 0; n < 4; n++) { // loop to pick four random moves and removes ones that were already chosen to prevent duplicates
            randomInt = random.nextInt(moveNames.size());
            moveName = moveNames.get(randomInt);
            pokemon.setMove(moveName, availableMoves.get(moveName));
            moveNames.remove(randomInt);
        }

        return pokemon;
    }
}
