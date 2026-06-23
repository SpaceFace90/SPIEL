
public enum Difficulty {
    LEICHT(50, 8),
    MITTEL(100, 5),
    SCHWER(200, 4);

    private final int range;
    private final int maxVersuche;

    Difficulty(int range, int maxVersuche) {
        this.range = range;
        this.maxVersuche = maxVersuche;
    } 

    public int getRange() {
        return range;
    }

    public int getMaxVersuche() {
        return maxVersuche;
    }

}