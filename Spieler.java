public class Spieler {

 
    private String name;
    private int versuche;
    private int guess;
 
 
    public Spieler(String name){
 
        this.name = name;
        this.versuche = 0;
    }
 
    public void versucheErhoehen() {
        this.versuche++;
    }
 
    public int getVersuche(){
        return versuche;
    }
 
    public String getName(){
        return name;
    }

    public int getGuess(){
        return guess;
    }

    public void setGuess(int newGuess){
        guess = newGuess;
    }
 
}