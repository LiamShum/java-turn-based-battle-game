
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // creates player object and name
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Trainer!");
        System.out.print("What is your name?");
        System.out.println();
        String name = sc.nextLine();
        Player player = new Player(name);

        // Steps to create team
        System.out.println("Hello, " + name + ". Please create your team. You may have up to 6 Pokemon.");
        int count = 0;
        String input;
        do {
            // Ask for Pokemon name
            System.out.print("Enter Pokemon Name: ");
            String pokemonName = sc.nextLine();

            // Print all types
            ArrayList<String> types = MoveLibrary.getAllTypes();
            for (int n = 0; n < types.size(); n++) {
                System.out.println((n + 1) + ". " + types.get(n));
            }

            // Pick first type
            System.out.print("Pick # of your first type: ");
            int firstElement = Integer.parseInt(sc.nextLine()) - 1;
            String element1 = types.get(firstElement);
            // pick second type
            int secondElement;
            do { // loop to make sure you cant pick same type twice
                System.out.print("Pick # of your second type: ");
                secondElement = Integer.parseInt(sc.nextLine()) - 1;
                if (secondElement == firstElement) {
                    System.out.println("You cannot pick the same type twice.");
                }
            } while (secondElement == firstElement);
            String element2 = types.get(secondElement);

            Pokemon pokemon = new Pokemon(pokemonName, element1, element2);

            // Get available moves
            HashMap<String, Double> availableMoves = MoveLibrary.getAvailableMoves(element1, element2);
            ArrayList<String> moveNames = new ArrayList<>(availableMoves.keySet());

            // Pick 4 moves
            for (int n = 0; n < 4; n++) {
                System.out.println("\nAvailable Moves:");
                for (int i = 0; i < moveNames.size(); i++) {
                    String moveName = moveNames.get(i);
                    System.out.println((i + 1) + ". " + moveName + " - " + availableMoves.get(moveName) + " damage");
                }
                System.out.print("Pick move #" + (n + 1) + ": ");
                int move = Integer.parseInt(sc.nextLine()) - 1;
                String moveName = moveNames.get(move);
                pokemon.setMove(moveName, availableMoves.get(moveName));
                // Prevent choosing the same move twice
                moveNames.remove(move);
            }
            player.addPokemon(pokemon);
            count++;
            if (count < 6) {
                System.out.print("\nPress q to finish, or Enter to create another Pokemon: ");
                input = sc.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    break;
                }
            }
        } while (count < 6);
        // End of team creation
    }
}
