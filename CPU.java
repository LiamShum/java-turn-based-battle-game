
/**
 * This class makes the CPU the player will go against
 */
public class CPU extends Player {

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

    public CPU(Player player) {
        super("CPU");
        int teamSize = player.getTeamSize();

        for(int n = 0; n < teamSize; n++) {
            Pokemon pokemon = createRandomPokemon();
            addPokemon(pokemon);
        }
    }
}
