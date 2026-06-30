import java.util.Random;
import java.util.Scanner;

// Diese Klasse steuert den gesamten Ablauf vom Spiel
public class Game {

    //private int spielerVersuche;
    //private int guess;
    private Spieler spieler;              // Der Spieler, der raet
    private int zielZahl;                 // Die gesuchte Zufallszahl
    private String hint;                  // Tipp: "Zu klein" oder "Zu gross"
    private Schwierigkeit schwierigkeit;  // Gewaehlte Schwierigkeitsstufe


    // Baut ein neues Spiel mit Spieler und Schwierigkeit
     public Game(Spieler spieler, Schwierigkeit schwierigkeit){

        this.spieler = spieler;
        this.schwierigkeit = schwierigkeit;
    }

    // Fragt den Spieler nach der Schwierigkeit und gibt seine Wahl (1-3) zurück
     public static int askDifficultyNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Schwierigkeit waehlen:");
        System.out.println("1 = LEICHT");
        System.out.println("2 = MITTEL");
        System.out.println("3 = SCHWER");
        System.out.print("Deine Wahl: ");

        int wahl = 0;

    // Wiederholt die Frage, bis eine gueltige Zahl (1, 2 oder 3) kommt
    while (wahl < 1 || wahl > 3) {

        wahl = scanner.nextInt();

        if (wahl < 1 || wahl > 3) {
            System.out.println("Ungueltige Wahl. Bitte 1, 2 oder 3 eingeben.");
        }
    }


        return wahl;
    }

    // Hier läuft das eigentliche Spiel ab
    public void spielen() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Zufallszahl im erlaubten Bereich der Schwierigkeit erzeugen
        zielZahl = random.nextInt(schwierigkeit.getRange()) + 1;


        // Sicherheitsabfrage, falls noch keine Schwierigkeit gesetzt ist
        while (schwierigkeit == null) {
            int wahl = scanner.nextInt();
            if (wahl == 1 || wahl == 2 || wahl == 3) {
                schwierigkeit = Schwierigkeit.vonNummer(wahl);
            } else {
                System.out.println("Ungueltige Wahl. Bitte 1, 2 oder 3 eingeben: ");
            }
        }


        // Startinfos für den Spieler ausgeben
        System.out.println();
        System.out.println("Spiel startet!");
        System.out.println("Ich denke an eine Zahl zwischen 1 und " + schwierigkeit.getRange() + ".");
        System.out.println("Du hast " + schwierigkeit.getMaxVersuche() + " Versuche.");
        System.out.println();

        // Schleife laeuft, bis die Zahl erraten oder die Versuche aufgebraucht sind
        while (true) {

            System.out.println("Versuch " + (spieler.getVersuche() + 1) + " von " + schwierigkeit.getMaxVersuche());
            System.out.print("Dein Tipp: ");


            // Tipp einlesen und Versuche hochzählen.
            spieler.setGuess(scanner.nextInt());
            spieler.versucheErhoehen();
            System.out.println();

            // Zahl richtig geraten -> gewonnen
            if (spieler.getGuess() == zielZahl) {
                System.out.println("Richtig! Du hast " + spieler.getVersuche() + " Versuche gebraucht.");
                break;
            }

            // Keine Versuche mehr uebrig -> verloren
            if (spieler.getVersuche() >= schwierigkeit.getMaxVersuche()) {

                System.out.println("You Lose!");
                System.out.println("du hast die maximale Anzahl von " + schwierigkeit.getMaxVersuche() + " Versuchen erreicht.");

                System.out.println("Die richtige Zahl war " + zielZahl + ".");
                break;
            }

            // Tipp geben, ob die Zahl zu klein oder zu groß war
            if (spieler.getGuess() < zielZahl) {
                hint = "Zu klein";
            }

            else {
                hint = "Zu gross";
            }

            System.out.println(hint);
            System.out.println();
        }

        scanner.close();
    }

    // Startpunkt
    public static void main(String[] args) {

        // Schwierigkeit abfragen und passende Stufe holen
        int schwierigkeitsNummer = askDifficultyNumber();

        Schwierigkeit schwierigkeit = Schwierigkeit.vonNummer(schwierigkeitsNummer);

        // Spieler und Spiel erstellen und dann starten
        Spieler spieler = new Spieler("Anes");

        Game spiel = new Game(spieler, schwierigkeit);
        spiel.spielen();
    }
}
