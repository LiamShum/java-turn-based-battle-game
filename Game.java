
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
    private final Scanner sc;

    public Game(Player player, CPU cpu, Scanner sc) {
        this.player = player;
        this.cpu = cpu;
        this.sc = sc;
    }

    public void start() {
        // Player picks first Pokemon
        System.out.println("Choose your first Pokemon!");
        player.printTeam();
        int pick = InputHelper.readChoice(sc, 1, player.getSize()) - 1;
        // Remove chosen Pokemon from team and make it active
        currentPokemon = player.getTeam().remove(pick);
        // CPU picks random Pokemon
        cpuCurrentPokemon = cpu.randomChoice(null);
        if (cpuCurrentPokemon == null) {
            System.out.println("CPU has no Pokemon left. You win!");
            return;
        }

        System.out.println("You sent out " + currentPokemon.getName() + "!");

        System.out.println("CPU sent out " + cpuCurrentPokemon.getName() + "!");

        // Battle loop
        while (currentPokemon != null && cpuCurrentPokemon != null) {
            do {
                System.out.println("1. Attack\n2. Switch Pokemon\n3. My Pokemon Info\n4. CPU Pokemon Info\n5. Team Info");
                pick = InputHelper.readChoice(sc, 1, 5);
                if (pick == 1) {
                    attack();
                }
                if (pick == 2) {
                    if (player.getSize() > 0) {
                        switchPokemon();
                        cpuTurn();
                    } else {
                        System.out.println("No pokemon to switch with.");
                    }
                }
                if (pick == 3) {
                    System.out.println(currentPokemon);
                }
                if (pick == 4) {
                    System.out.println(cpuCurrentPokemon);
                }
                if (pick == 5) {
                    player.printTeamStats();
                }
            } while (pick == 3 || pick == 4 || pick == 5);

        }
    }

    // methods
    // switch pokemon in your team
    public void switchPokemon() {
        System.out.println("Pick the pokemon to swap with!");
        player.printTeam();
        int pick = InputHelper.readChoice(sc, 1, player.getSize()) - 1;
        // removing new pokemon on team
        Pokemon newPokemon = player.getTeam().remove(pick);

        // putting current pokemon back on team
        player.addPokemon(currentPokemon);

        currentPokemon = newPokemon;
        System.out.println("You switched to " + currentPokemon.getName() + "!");
    }

    // checking for element, returns damage
    public double elementDamage(String attacktype, Pokemon defender) {
        double multiplier1 = Typechart.getMultiplier(attacktype, defender.getType1());
        double multiplier2 = Typechart.getMultiplier(attacktype, defender.getType2());

        return multiplier1 * multiplier2;
    }

    public void attack() {
        // Convert set into a list so we can access items by index
        ArrayList<Map.Entry<String, Double>> moveList = new ArrayList<>(currentPokemon.getMoves().entrySet());
        if (moveList.isEmpty()) {
            System.out.println("This Pokemon has no moves.");
            return;
        }

        System.out.println("Pick your move!");
        for (int n = 0; n < moveList.size(); n++) {
            Map.Entry<String, Double> entry = moveList.get(n); // map entry keeps all moves as pairs
            System.out.println((n + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }

        System.out.print("Choose a move (1-" + moveList.size() + "): ");
        int movePick = InputHelper.readChoice(sc, 1, moveList.size()) - 1;
        boolean cpuFirst = cpuCurrentPokemon.getSpeed() > currentPokemon.getSpeed();
        Pokemon attackingPokemon = currentPokemon;
        if (cpuFirst) {
            cpuTurn();
            // A defeated Pokemon cannot use the move that was selected for it.
            if (currentPokemon != attackingPokemon) {
                return;
            }
        }

        Map.Entry<String, Double> selectedMove = moveList.get(movePick);  // gets move
        String moveType = MoveLibrary.getMoveType(selectedMove.getKey()); // finds move type
        double damage = selectedMove.getValue() * elementDamage(moveType, cpuCurrentPokemon);
        cpuCurrentPokemon.damage(damage);

        System.out.println(currentPokemon.getName() + " used " + selectedMove.getKey() + "!");
        System.out.println("Damage: " + damage);
        System.out.println(cpuCurrentPokemon.getName() + " has " + cpuCurrentPokemon.getHealth() + " HP remaining.");

        if (cpuCurrentPokemon.getHealth() == 0) {
            System.out.println(cpuCurrentPokemon.getName() + " has been defeated!");
            cpuCurrentPokemon = null;
            cpuTurn(); // Send out a replacement, or announce that the player won.
        } else if (!cpuFirst) {
            cpuTurn();
        }
    } // attack()

    private void cpuTurn() {
        Pokemon previousPokemon = cpuCurrentPokemon;
        cpuCurrentPokemon = cpu.randomChoice(cpuCurrentPokemon);

        if (cpuCurrentPokemon == null) {
            System.out.println("CPU has no Pokemon left. You win!");
            return;
        }

        // Sending out or switching Pokemon uses this CPU turn.
        if (cpuCurrentPokemon != previousPokemon) {
            System.out.println("CPU sent out " + cpuCurrentPokemon.getName() + "!");
            return;
        }

        ArrayList<Map.Entry<String, Double>> moveList = new ArrayList<>(cpuCurrentPokemon.getMoves().entrySet());
        if (moveList.isEmpty()) {
            System.out.println("CPU's Pokemon has no moves.");
            return;
        }

        Map.Entry<String, Double> selectedMove = moveList.get(random.nextInt(moveList.size()));
        String moveType = MoveLibrary.getMoveType(selectedMove.getKey());
        double damage = selectedMove.getValue() * elementDamage(moveType, currentPokemon);
        currentPokemon.damage(damage);

        System.out.println("CPU's " + cpuCurrentPokemon.getName() + " used " + selectedMove.getKey() + "!");
        System.out.println("Damage: " + damage);
        System.out.println(currentPokemon.getName() + " has " + currentPokemon.getHealth() + " HP remaining.");

        if (currentPokemon.getHealth() == 0) {
            System.out.println(currentPokemon.getName() + " has been defeated!");
            currentPokemon = null;
            if (player.getTeam().isEmpty()) {
                System.out.println("You have no Pokemon left. CPU wins!");
            } else {
                System.out.println("Choose your next Pokemon!");
                player.printTeam();
                int pick = InputHelper.readChoice(sc, 1, player.getSize()) - 1;
                currentPokemon = player.getTeam().remove(pick);
                System.out.println("You sent out " + currentPokemon.getName() + "!");
            }
        }
    }
}
