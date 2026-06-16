import java.util.Random;
import java.util.Scanner;

public class Game {

    // private String spieler; #kommt von Spieler
    // private int spielerVersuche;
    private int guess;
    private int zielZahl;
    private int maxVersuche;
    private int range;
    private String hint;
    private Difficulty difficulty;
   

    public void spielen() {
        Scanner scanner = new Scanner(System.in);

        range = difficulty.getRange();
        maxVersuche = difficulty.getMaxVersuche();
        zielZahl = random.nextInt(range) + 1;

        Random random = new Random();

        maxVersuche = 5;
        range = 100;
        zielZahl = random.nextInt(range) + 1;
        spielerVersuche = 0;
        guess = 0;

        System.out.println("Ich denke an eine Zahl zwischen 1 und " + range + ".");

        while (guess != zielZahl) {
            System.out.print("Dein Tipp: ");
            guess = scanner.nextInt();
            spielerVersuche++;

            if (spielerVersuche >= maxVersuche) {
                System.out.println("You Lose, du hast die maximale Anzahl von " + maxVersuche + " gebraucht.\n" +
                        "Die richtige Zahl war " + zielZahl);
                break;
            }

            if (guess < zielZahl) {
                hint = "Zu klein";
            } else if (guess > zielZahl) {
                hint = "Zu groß";
            } else {
                hint = "Richtig! Du hast " + spielerVersuche + " Versuche gebraucht.";
            }
            System.out.println(hint);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Game spiel = new Game();
        spiel.spielen();
    }
}