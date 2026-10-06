
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Player player;
    private final CPU cpu;

    private Pokemon currentPokemon;
    private Pokemon cpuCurrentPokemon;

    private static final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    public Game(Player player, CPU cpu) {
        this.player = player;
        this.cpu = cpu;
    }

    public void start() {
        // Player picks first Pokemon
        System.out.println("Choose your first Pokemon!");
        player.printTeam();
        int pick = sc.nextInt() - 1;
        // Remove chosen Pokemon from team and make it active
        currentPokemon = player.getTeam().remove(pick);
        // CPU picks random Pokemon
        int randomNum = random.nextInt(cpu.getTeam().size());
        cpuCurrentPokemon = cpu.getTeam().remove(randomNum);

        System.out.println("You sent out " + currentPokemon.getName() + "!");

        System.out.println("CPU sent out " + cpuCurrentPokemon.getName() + "!");

        // Battle loop
        while (currentPokemon != null && cpuCurrentPokemon != null) {
        }
    }

    // methods
    public void switchPokemon() {
        System.out.println("Pick the pokemon to swap with!");
        player.printTeam();
        int pick = sc.nextInt() - 1;
        // removing new pokemon on team
        Pokemon newPokemon = player.getTeam().remove(pick);

        // putting current pokemon back on team
        player.addPokemon(currentPokemon);

        currentPokemon = newPokemon;
        System.out.println("You switched to " + currentPokemon.getName() + "!");
    }
}
