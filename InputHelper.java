import java.util.NoSuchElementException;
import java.util.Scanner;

public final class InputHelper {
    private InputHelper() {
    }

    // Read a whole line so numeric choices work alongside names and other text input.
    public static int readChoice(Scanner sc, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum choice must not exceed maximum choice.");
        }

        while (true) {
            if (!sc.hasNextLine()) {
                throw new NoSuchElementException("Input closed.");
            }

            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // Invalid text and oversized numbers should prompt again.
            }

            System.out.print("Please enter a whole number from " + min + " to " + max + ": ");
        }
    }
}
