package Models;

public class Player {
    public String name;
    public String type;
    public int wins = 0;
    public int losses = 0;
    public int draws = 0;
    public char symbol;
    public int currentGameScore;

    public Player(String name, String type, char symbol) {
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

}