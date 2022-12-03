package Chars;

public class Crossbowman extends BaseHero{

    public Crossbowman(String teamName, int x, int y) {
        super("Crossbowman", 6, 3, 16, new int []{2, 3}, 10, 4, 0, false, teamName);
        super.position = new Vector2(x, y);
    }
}
