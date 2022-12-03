package Chars;

public class Sniper extends BaseHero{

    public Sniper(String teamName, int x, int y) {
        super("Sniper", 12, 10, 32, new int []{8, 10}, 15, 9, 0, false, teamName);
        super.position = new Vector2(x, y);
    }
}
