package Chars;

public class Pikeman extends BaseHero{

    public Pikeman(String teamName, int x, int y) {
        super("Pikeman", 4, 5, 0, new int []{1, 3}, 10, 4, 0, false, teamName);
        super.position = new Vector2(x, y);
    }
}
