import java.util.Random;
import java.util.Scanner;
public class Game {
    private final Player player;
    private final CPU cpu;
    private static final Random random = new Random();

    public Game(Player player, CPU cpu) {
        this.player = player;
        this.cpu = cpu;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
            // player picks first pokemon
            System.out.println("Choose your first pokemon!");
            player.printTeam();
            int pick = sc.nextInt();
            // cpu picks random pokemon
            int randomnum = random.nextInt(cpu.getTeam().size());

            Pokemon currentPokemon = player.getTeam().get(pick - 1);
            Pokemon cpuPokemon = cpu.getTeam().get(randomnum);
        // loop that runs until someones team is gone

        while(!(player.getTeam().size() == 0) || !(cpu.getTeam().size() == 0)) {
            
        }
    }
}