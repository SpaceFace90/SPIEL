// Diese Klasse speichert die Daten von einem Spieler
public class Spieler {


    private String name;      // Name des Spielers
    private int versuche;     // Wie oft der Spieler schon geraten hat
    private int guess;        // Die zuletzt getippte Zahl


    // Baut einen neuen Spieler mit Namen und startet die Versuche bei 0
    public Spieler(String name){

        this.name = name;
        this.versuche = 0;
    }

    // Zählt die Versuche um eins hoch
    public void versucheErhoehen() {
        this.versuche++;
    }

    // Gibt zurück, wie viele Versuche gemacht wurden
    public int getVersuche(){
        return versuche;
    }

    // Gibt den Namen des Spielers zurück
    public String getName(){
        return name;
    }

    // Gibt die zuletzt getippte Zahl zurück
    public int getGuess(){
        return guess;
    }

    // Speichert die neu getippte Zahl
    public void setGuess(int newGuess){
        guess = newGuess;
    }

}