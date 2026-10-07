
import java.util.ArrayList;
import java.util.Map;
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
            do { 
                System.out.println("1. Attack\n2. Switch Pokemon\n3. My Pokemon Info\n4. CPU Pokemon Info\n5. Team Info");
                pick = sc.nextInt();
                if(pick==1) {
                    attack();
                }
                if(pick==2) {
                    switchPokemon();
                }
                if(pick==3) {
                    currentPokemon.toString();
                }
                if(pick==4) {
                    cpuCurrentPokemon.toString();
                }
                if(pick==5) {
                    player.printTeamStats();
                }
            } while (pick == 3 || pick == 4 || pick==5);
            
        }
    }

    // methods

    // switch pokemon in your team
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

    // checking for element, returns damage
    public double elementDamage(String attacktype, Pokemon defender ) {
        double multiplier1 = Typechart.getMultiplier(attacktype, defender.getType1());
        double multiplier2 = Typechart.getMultiplier(attacktype, defender.getType2());

        return multiplier1*multiplier2;
    }

    public void attack() {
        // Convert set into a list so we can access items by index
        ArrayList<Map.Entry<String, Double>> moveList = new ArrayList<>(currentPokemon.getMoves().entrySet());
        System.out.println("Pick your move!");
        for(int n = 0; n < moveList.size(); n++) {
            Map.Entry<String, Double> entry = moveList.get(n); // map entry keeps all moves as pairs
            System.out.println((n+1) + ". " + entry.getKey() + " - " + entry.getValue());
            int movePick = sc.nextInt() - 1;
        }
    }
}
