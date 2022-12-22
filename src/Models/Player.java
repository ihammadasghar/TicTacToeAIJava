package Models;

public class Player {
    public String name;
    public int wins = 0;
    public int losses = 0;
    public int draws = 0;
    public char symbol;
    public String color;
    public int currentGameScore;

    public Player(String name, char symbol, String color) {
        this.name = name;
        this.symbol = symbol;
        this.color = color;
    }

}