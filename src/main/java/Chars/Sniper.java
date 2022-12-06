package Chars;

import java.util.ArrayList;

public class Sniper extends BaseHero{

    public Sniper(String teamName, ArrayList<BaseHero> team, int x, int y) {
        super("Sniper", 12, 10, 32, new int []{8, 10}, 15, 9, 0, false, teamName, team);
        super.position = new Vector2(x, y);
    }
}
