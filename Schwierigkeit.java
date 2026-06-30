
// Diese Klasse legt die Schwierigkeitsstufen des Spiels fest
public class Schwierigkeit {

    // Drei feste Stufen: Name, Zahlenbereich und maximale Versuche
    public static final Schwierigkeit LEICHT = new Schwierigkeit("LEICHT", 50, 8);
    public static final Schwierigkeit MITTEL = new Schwierigkeit("MITTEL", 100, 5);
    public static final Schwierigkeit SCHWER = new Schwierigkeit("SCHWER", 200, 4);

    private final String name;        // Name der Stufe
    private final int range;          // Größte mögliche Zahl
    private final int maxVersuche;    // Erlaubte Anzahl an Versuchen

    // Baut eine Schwierigkeitsstufe mit ihren Werten
    private Schwierigkeit(String name, int range, int maxVersuche) {
        this.name = name;
        this.range = range;
        this.maxVersuche = maxVersuche;
    }

    // Gibt den Zahlenbereich zurück
    public int getRange() {
        return range;
    }

    // Gibt die maximale Anzahl der Versuche zurück
    public int getMaxVersuche() {
        return maxVersuche;
    }

    // Gibt den Namen der Stufe zurück
    public String getName() {
        return name;
    }


    // Wandelt die eingegebene Zahl in eine Stufe um
    public static Schwierigkeit vonNummer(int nummer) {
        switch (nummer) {
            case 1:
                return LEICHT;
            case 2:
                return MITTEL;
            case 3:
                return SCHWER;
            default:
                return null;

        }
    }
}
