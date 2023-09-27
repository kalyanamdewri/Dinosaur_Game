import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Dinosaur {
	
	// ANSI escape codes for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    public static void animateRoar() throws InterruptedException {
        System.out.print("ROAR!");
        TimeUnit.SECONDS.sleep(1);  // wait for 1 second
        System.out.print("\033[1A");  // Move cursor up one line
        System.out.print("\033[2K");  // Clear the line
    }

	
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println(ANSI_YELLOW + "      T-REX VS TRICEROTOPS      ");
        System.out.println("********************************" + ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);

        System.out.println(ANSI_GREEN + "         ___");
        System.out.println("         __/__|__\\___");
        System.out.println("        |   T-REX   /");
        System.out.println("       \\______/ " + ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);

        System.out.println(ANSI_RED + "\n                  VS\n" + ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);

        System.out.println(ANSI_RED + "          ____");
        System.out.println("      /__|_|__\\");
        System.out.println("     | TRICEROTOPS |");
        System.out.println("        \\__________/ " + ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);


        int trex = 100;
        int tri = 100;

        while (trex > 0 && tri > 0) {
            System.out.println(ANSI_GREEN + "\nYOUR MOVE, T-REX: bite or punch?" + ANSI_RESET);
            String[] moves = {"bite", "punch"};
            String input = scan.nextLine();
            
            if (input.equalsIgnoreCase("bite")) {
                System.out.println("You bit the tri! CRUNCH!");
                animateRoar();
                tri -= 60;
            } else if (input.equalsIgnoreCase("punch")) {
                System.out.println("You punched the tri! SMACK!");
                animateRoar();
                tri -= 20;
            } else {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            
         // Triceratops strikes back!
            int triAttack = (int) (Math.random() * 2);
            if (triAttack == 0) {
                System.out.println(ANSI_RED + "Triceratops bit you back! OUCH!" + ANSI_RESET);
                animateRoar();
                trex -= 30;
            } else {
                System.out.println(ANSI_RED + "Triceratops punched you back! THUMP!" + ANSI_RESET);
                animateRoar();
                trex -= 10;
            }
            
            System.out.println("\n" + ANSI_GREEN + "T-Rex Health: " + Math.max(trex, 0) + ANSI_RESET +
                    " | " + ANSI_RED + "Triceratops Health: " + Math.max(tri, 0) + ANSI_RESET);
 TimeUnit.SECONDS.sleep(1);
        }
    
    System.out.println("\nT-Rex Health: " + trex + " | Triceratops Health: " + tri);
    TimeUnit.SECONDS.sleep(1);


// Announce the winner
    if (trex <= 0) {
    	System.out.println(ANSI_RED + "Oh no! Triceratops won. Better luck next time." + ANSI_RESET);
    } else {
        System.out.println(ANSI_GREEN + "Congratulations, T-Rex wins! You're the king of the dinosaurs!" + ANSI_RESET);
    }

  }
    
}
