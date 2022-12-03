package Chars;

public class Wizard extends BaseHero{

    public Wizard(String teamName, int x, int y) {
        super("Wizard", 17, 12, 0, new int []{-5}, 30, 9, 0, true, teamName);
        super.position = new Vector2(x, y);
    }
}
