package Chars;

public class Robber extends BaseHero{

    public Robber(String teamName, int x, int y) {
        super("Robber", 8, 3, 0, new int []{2, 4}, 10, 6, 0, false, teamName);
        super.position = new Vector2(x, y);
    }
}
