package Models;

public class Player {
    public String name;
    public int wins = 0;
    public int losses = 0;
    public int draws = 0;
    public char symbol;
    public int currentGameScore;
    public boolean isAI;

    public Player(String name, char symbol, boolean isAI) {
        this.name = name;
        this.symbol = symbol;
        this.isAI = isAI;
    }

}