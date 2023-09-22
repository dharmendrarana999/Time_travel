import java.util.Random;
import java.util.Scanner;

public class TimeTravelAdventure {

    static Scanner scanner = new Scanner(System.in);
    static int playerHealth = 100;
    static int playerGold = 0;
    static int score = 0;
    static boolean hasMap = false;
    static boolean hasCompass = false;
    static boolean hasKey = false;

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║   Welcome to Time Travel Game!   ║");
        System.out.println("║    Explore, Collect, and Win!    ║");
        System.out.println("╚══════════════════════════════════╝");

        while (playerHealth > 0) {
            showOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    travelToPrehistoricEra();
                    break;
                case 2:
                    travelToMedievalEra();
                    break;
                case 3:
                    travelToFuture();
                    break;
                case 4:
                    displayStats();
                    break;
                case 5:
                    heal();
                    break;
                case 6:
                    upgradeTimeMachine();
                    break;
                case 7:
                    useMap();
                    break;
                case 8:
                    useCompass();
                    break;
                case 9:
                    useKey();
                    break;
                case 10:
                    saveTheFuture();
                    break;
                case 11:
                    System.out.println("Thanks for playing! Your final score is: " + score);
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Game over! Your health reached zero. Your final score is: " + score);
    }

    static void showOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Travel to the Prehistoric Era");
        System.out.println("2. Travel to the Medieval Era");
        System.out.println("3. Travel to the Future");
        System.out.println("4. Display Stats");
        System.out.println("5. Heal (+20 health, cost: 50 gold)");
        System.out.println("6. Upgrade Time Machine (cost: 150 gold)");
        System.out.println("7. Use Map (if available)");
        System.out.println("8. Use Compass (if available)");
        System.out.println("9. Use Key (if available)");
        System.out.println("10. Save the Future (requires 500 gold)");
        System.out.println("11. Quit");
        System.out.print("Enter your choice: ");
    }

    static void travelToPrehistoricEra() {
        System.out.println("\nYou are now in the Prehistoric Era.");
        int randomEvent = new Random().nextInt(5);
        if (randomEvent == 0) {
            System.out.println("You discover a dinosaur skeleton and collect a valuable artifact.");
            playerGold += 50;
        } else if (randomEvent == 1) {
            System.out.println("A saber-toothed tiger attacks you! You lose 20 health.");
            playerHealth -= 20;
        } else if (randomEvent == 2 && !hasMap) {
            System.out.println("You find an ancient map that may be useful in future travels.");
            hasMap = true;
        } else if (randomEvent == 3) {
            System.out.println("You stumble upon a hidden cave with a stash of gold coins!");
            playerGold += 100;
        } else {
            System.out.println("You are amazed by the majestic landscapes of the prehistoric era.");
            playerHealth += 15;
        }
        playerHealth -= 10;
        score += 10;
    }

    static void travelToMedievalEra() {
        System.out.println("\nYou find yourself in the Medieval Era.");
        int randomEvent = new Random().nextInt(5);
        if (randomEvent == 0) {
            System.out.println("You help a knight defeat a dragon and receive a reward.");
            playerGold += 100;
        } else if (randomEvent == 1) {
            System.out.println("You are caught in a peasant uprising. You lose 30 health.");
            playerHealth -= 30;
        } else if (randomEvent == 2 && !hasCompass) {
            System.out.println("You acquire a compass that may help you navigate better.");
            hasCompass = true;
        } else if (randomEvent == 3) {
            System.out.println("You participate in a grand feast at the king's castle and gain popularity.");
            playerGold += 50;
        } else {
            System.out.println("You witness a jousting tournament and bet on the winning knight.");
            playerGold += 30;
        }
        playerHealth -= 20;
        score += 20;
    }

    static void travelToFuture() {
        System.out.println("\nWelcome to the Future.");
        int randomEvent = new Random().nextInt(5);
        if (randomEvent == 0) {
            System.out.println("You encounter advanced technology and gain knowledge.");
            playerGold += 30;
        } else if (randomEvent == 1) {
            System.out.println("You stumble into a post-apocalyptic wasteland. You lose 10 health.");
            playerHealth -= 10;
        } else if (randomEvent == 2 && hasMap) {
            System.out.println("You use the ancient map to find a hidden treasure worth 200 gold!");
            playerGold += 200;
        } else if (randomEvent == 3) {
            System.out.println("You meet a group of friendly future dwellers who share their food with you.");
            playerHealth += 25;
        } else {
            System.out.println("You explore an advanced library and discover valuable research papers.");
            playerGold += 40;
        }
        playerHealth -= 5;
        score += 15;
    }

    static void displayStats() {
        System.out.println("\nPlayer Stats:");
        System.out.println("Health: " + playerHealth);
        System.out.println("Gold: " + playerGold);
        System.out.println("Score: " + score);
        System.out.println("Inventory:");
        if (hasMap) {
            System.out.println("- Map");
        }
        if (hasCompass) {
            System.out.println("- Compass");
        }
        if (hasKey) {
            System.out.println("- Key");
        }
    }

    static void heal() {
        if (playerGold >= 50) {
            System.out.println("\nYou use 50 gold to heal (+20 health).");
            playerHealth += 20;
            playerGold -= 50;
        } else {
            System.out.println("\nYou don't have enough gold to heal.");
        }
    }

    static void upgradeTimeMachine() {
        if (playerGold >= 150) {
            System.out.println("\nYou try to upgrade your time machine, but it seems to be at its maximum capacity.");
        } else {
            System.out.println("\nYou don't have enough gold to upgrade your time machine.");
        }
    }

    static void useMap() {
        if (hasMap) {
            System.out.println("\nYou use the map to find your way. It comes in handy!");
            score += 10;
        } else {
            System.out.println("\nYou don't have a map. Keep exploring to find one.");
        }
    }

    static void useCompass() {
        if (hasCompass) {
            System.out.println("\nYou use the compass to navigate effectively.");
            score += 10;
        } else {
            System.out.println("\nYou don't have a compass. Keep exploring to find one.");
        }
    }

    static void useKey() {
        if (hasKey) {
            System.out.println("\nYou use the key to unlock a hidden treasure chest!");
            playerGold += 250;
            hasKey = false;
        } else {
            System.out.println("\nYou don't have a key. Keep exploring to find one.");
        }
    }

    static void saveTheFuture() {
        if (playerGold >= 500) {
            System.out.println("\nCongratulations! You've saved the future by investing 500 gold.");
            System.out.println("You win the game with a score of: " + score);
            System.exit(0);
        } else {
            System.out.println("\nYou need 500 gold to save the future. Keep exploring!");
        }
    }
}
