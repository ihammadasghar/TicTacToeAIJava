package Models;

public class Player{
    public String name;
    public String type;
    public int wins;
    public int losses;
    public int draws;
    public char symbol;
    public int currentGameScore;

    public Player(String name, String type, char symbol){
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

}