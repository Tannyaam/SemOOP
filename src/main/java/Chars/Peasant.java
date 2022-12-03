package Chars;

public class Peasant extends BaseHero{

    public Peasant(String teamName, int x, int y) {
        super("Peasant", 1, 1, 0, new int []{1}, 1, 3, 1, false, teamName);
        super.position = new Vector2(x, y);
    }
}
