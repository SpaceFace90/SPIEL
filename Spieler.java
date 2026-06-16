public class Spieler {
   //TESTé
 
    private String name;
    private int versuche;
 
 
    public Spieler(String name){
 
        this.name = name;
        this.versuche = 0;
    }
 
    public void versucheErhoehen() {
        versuche++;
    }
 
    public int getVersuche(){
        return versuche;
    }
 
    String getName(){
        return name;
    }
 
}